package com.blogapp12.service;

import com.blogapp12.payload.ListPostDto;
import com.blogapp12.payload.PostDto;

import java.util.List;

public interface PostService {

    public PostDto createPost(PostDto postDto);

    void deletePost(long postId);

    public ListPostDto fetchAllPosts(int pageNo, int pageSize , String sortBy, String direction);

    public PostDto getPostById(Long id);
}
