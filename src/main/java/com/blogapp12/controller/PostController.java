package com.blogapp12.controller;

import com.blogapp12.entity.Post;
import com.blogapp12.payload.ListPostDto;
import com.blogapp12.payload.PostDto;
import com.blogapp12.service.PostService;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;


    //  using constructor dependency instead of Autowired

    public PostController(PostService postService) {
        this.postService = postService;
    }


//creating the posts................


    // http://localhost:8082/api/posts
    @PostMapping
    public ResponseEntity<?>createPost(@Valid @RequestBody PostDto postDto , BindingResult bindingResult){

        if(bindingResult.hasErrors()) {

            return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        PostDto dto = postService.createPost(postDto);
        return new ResponseEntity<>(dto , HttpStatus.CREATED) ;
    }



// deleting the posts...........


    // http://localhost:8082/api/posts/2
   @DeleteMapping
   @RequestMapping("/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable long postId){
        postService.deletePost(postId);

        return new ResponseEntity<>("deleted successful!!", HttpStatus.OK);

    }




//     fetching the posts with pagination and  sorting ...........


  //  http://localhost:8082/api/posts?pageNo=0&pageSize=4&sortBy=title&direction=desc
    @GetMapping
    public ResponseEntity<?>getAllPosts(
            @RequestParam(name="pageNo", defaultValue = "0",required = false) int pageNo,
            @RequestParam(name="pageSize",defaultValue = "4",required = false) int pageSize,
            @RequestParam(name="sortBy" , defaultValue = "title",required = false) String sortBy,
            @RequestParam(name="direction" , defaultValue = "asc",required = false) String direction
    ){

          ListPostDto listPostDto = postService.fetchAllPosts(pageNo,pageSize ,sortBy , direction);

        return new ResponseEntity<>(listPostDto,HttpStatus.OK);
}



// fetching the post by id...........



//  http://localhost:8082/api/posts/1

@GetMapping("/post/{id}")

public ResponseEntity<PostDto>getPostById(@PathVariable long id){

    PostDto postDto = postService.getPostById(id);

    return new ResponseEntity<>(postDto,HttpStatus.OK);
}


}
