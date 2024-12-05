package com.blogapp12.service;

import com.blogapp12.entity.Post;
import com.blogapp12.exception.ResourceNotFoundException;
import com.blogapp12.payload.ListPostDto;
import com.blogapp12.payload.PostDto;
import com.blogapp12.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

private PostRepository postRepository;

private ModelMapper modelMapper;

public PostServiceImpl(PostRepository postRepository , ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
}


// creating the posts.............
    @Override
    public PostDto createPost(PostDto postDto) {

        Post post = mapToEntity(postDto);
        Post saved = postRepository.save(post);

        PostDto postDto1 = mapToDto(saved);

        return postDto1;
    }



    // deleting the posts.........
    @Override
    public void deletePost(long postId) {

        postRepository.deleteById(postId);

    }


    // fetching the all the posts........
    @Override
    public ListPostDto fetchAllPosts(int pageNo, int pageSize , String sortBy, String direction) {

//        List<Post> allposts = postRepository.findAll();

    Sort sort = direction.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending():Sort.by(sortBy).descending();

       Pageable pageable =  PageRequest.of(pageNo , pageSize , sort);
        Page<Post> all = postRepository.findAll(pageable);
        List<Post> post = all.getContent();
        List<PostDto> postDtos = post.stream().map(p -> mapToDto(p)).collect(Collectors.toList());

        ListPostDto listPostDto = new ListPostDto();
        listPostDto.setPostDto(postDtos);
        listPostDto.setTotalPages(all.getTotalPages());
        listPostDto.setElements(all.getNumberOfElements());
        listPostDto.setPageNumber(all.getNumber());
        listPostDto.setFirstpage(all.isFirst());
        listPostDto.setLastPage(all.isLast());

        return listPostDto;

    }




    @Override
    public PostDto getPostById(Long id) {

       Post post =   postRepository.findById(id).orElseThrow(

               ()-> new ResourceNotFoundException("post not found with id:"+id)
       );

       return mapToDto(post);

    }





    public Post mapToEntity(PostDto postDto){

        Post post = modelMapper.map(postDto, Post.class);

        return post;
    }




    public PostDto mapToDto(Post post){

        PostDto dto = modelMapper.map(post, PostDto.class);
        return dto;
    }

}
