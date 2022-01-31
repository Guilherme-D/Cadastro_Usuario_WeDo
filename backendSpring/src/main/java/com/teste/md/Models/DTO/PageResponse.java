package com.teste.md.Models.DTO;

import com.teste.md.Models.Users;

import java.util.List;

public class PageResponse {
    int total;
    List<Users> content;
    PageResponse pageRequest;

    public PageResponse() {
    }

    public PageResponse(int total, List<Users> content, PageResponse pageRequest) {
        this.total = total;
        this.content = content;
        this.pageRequest = pageRequest;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Users> getContent() {
        return content;
    }

    public void setContent(List<Users> content) {
        this.content = content;
    }

    public PageResponse getPageRequest() {
        return pageRequest;
    }

    public void setPageRequest(PageResponse pageRequest) {
        this.pageRequest = pageRequest;
    }
}
