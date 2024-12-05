package com.blogapp12.controller;


import com.blogapp12.payload.CommentDto;
import com.blogapp12.payload.PostWithCommentDto;
import com.blogapp12.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private CommentService commentService;



 // dependency injection
    public CommentController(CommentService commentService) {

        this.commentService = commentService;
    }


    // creating the comments for each post..............

    //    http://localhost:8082/api/comments/1
    @PostMapping
    @RequestMapping("/{postId}")
    public ResponseEntity<CommentDto>createComment(@RequestBody CommentDto commentDto , @PathVariable long postId){

         CommentDto commentdto= commentService.createComment(commentDto ,postId);

        return new ResponseEntity<>(commentdto , HttpStatus.CREATED);
    }






// fetch the  all comments for individual post...........

    // http://localhost:8082/api/comments/post/3
    @GetMapping
@RequestMapping("/post/{postId}")
    public ResponseEntity<PostWithCommentDto>getAllCommentsByPostId(@PathVariable long postId){

       PostWithCommentDto postWithCommentDto = commentService.getAllCommentsByPostId(postId);

        return new ResponseEntity<>(postWithCommentDto,HttpStatus.OK);
    }


}
