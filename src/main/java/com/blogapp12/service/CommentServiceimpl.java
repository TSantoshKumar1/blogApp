package com.blogapp12.service;

import com.blogapp12.entity.Comment;
import com.blogapp12.entity.Post;
import com.blogapp12.exception.ResourceNotFoundException;
import com.blogapp12.payload.CommentDto;
import com.blogapp12.payload.PostDto;
import com.blogapp12.payload.PostWithCommentDto;
import com.blogapp12.repository.CommentRepository;
import com.blogapp12.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentServiceimpl implements CommentService{



    private CommentRepository commentRepository;
    private PostRepository postRepository;

    private ModelMapper modelMapper;


    // for dependency injecting
    public CommentServiceimpl(CommentRepository commentRepository, PostRepository postRepository, ModelMapper modelMapper) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CommentDto createComment(CommentDto commentDto, long postId) {

        Optional<Post> byId = postRepository.findById(postId);
        Post post = byId.get();
        Comment comment = mapToEntity(commentDto);

        comment.setPost(post);

        Comment saveComment = commentRepository.save(comment);

        CommentDto commentdto = mapToDto(saveComment);


        return commentdto;
    }




 @Override
    public PostWithCommentDto getAllCommentsByPostId(long postId) {

     Post post= postRepository.findById(postId).orElseThrow(

             ()-> new ResourceNotFoundException("comment not found with id:"+postId)
     );


      PostDto postDto = new PostDto();
      postDto.setTitle(post.getTitle());
      postDto.setContent(post.getContent());
      postDto.setDescription(post.getDescription());


     List<Comment> bypostId = commentRepository.findByPostId(postId);

        List<CommentDto> commentdto = bypostId.stream().map(c -> mapToDto(c)).collect(Collectors.toList());

     PostWithCommentDto postWithCommentDto = new PostWithCommentDto();
     postWithCommentDto.setPostDto(postDto);
     postWithCommentDto.setCommentDto(commentdto);


     return postWithCommentDto;
    }






    public Comment mapToEntity(CommentDto commentDto){

        Comment comment = modelMapper.map(commentDto, Comment.class);
        return  comment;

    }

    public CommentDto  mapToDto(Comment comment){

        CommentDto  commentDto = modelMapper.map(comment, CommentDto.class);

        return commentDto;
    }
}
