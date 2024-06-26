package com.company.service;

import com.company.Post;
import com.company.PostCreateDto;
import com.company.PostRepository;
import com.company.dto.CommentCreateDTO;
import com.company.dto.CommentDTO;
import com.company.dto.PostDTO;
import com.company.resource.CommentResource;
import lombok.NonNull;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final CommentResource commentResource;

    public PostServiceImpl(PostRepository postRepository, CommentResource commentResource) {
        this.postRepository = postRepository;
        this.commentResource = commentResource;
    }

    @Override
    public PostDTO getPost(@NonNull Integer id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post Not Found"));

        return PostDTO.builder()
                .id(post.getId())
                .title(post.getTitle())
                .body(post.getBody())
                .comments(commentResource.getAllComments(post.getId()))
                .build();
    }

    @Override
    public PostDTO createPost(@NonNull PostCreateDto dto) {
        Post post = Post.builder()
                .body(dto.getBody())
                .title(dto.getTitle())
                .build();
        postRepository.save(post);
        return PostDTO.builder()
                .id(post.getId())
                .body(dto.getBody())
                .title(dto.getTitle())
                .comments(new ArrayList<>())
                .build();
    }

    @Override
    public Void createComments(@NonNull List<CommentCreateDTO> dtos) {
        commentResource.saveAll(dtos);
        return null;
    }


}
