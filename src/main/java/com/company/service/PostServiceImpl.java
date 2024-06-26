package com.company.service;

import com.company.Post;
import com.company.resource.CommentResource;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final CommentResource commentResource;

    @Override
    public Post getPost(@NonNull Integer id) throws Exception {
        return commentResource.getPost(id);
    }
}
