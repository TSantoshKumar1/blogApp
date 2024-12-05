package com.blogapp12.payload;

import java.util.List;

public class ListPostDto {

    private List<PostDto> postDto;
    private int totalPages;

    private int elements;

    private int pageNumber;

    private boolean lastPage;

    private boolean firstpage;

    public List<PostDto> getPostDto() {
        return postDto;
    }

    public void setPostDto(List<PostDto> postDto) {
        this.postDto = postDto;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getElements() {
        return elements;
    }

    public void setElements(int elements) {
        this.elements = elements;
    }

    public boolean isLastPage() {
        return lastPage;
    }

    public void setLastPage(boolean lastPage) {
        this.lastPage = lastPage;
    }

    public boolean isFirstpage() {
        return firstpage;
    }

    public void setFirstpage(boolean firstpage) {
        this.firstpage = firstpage;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}
