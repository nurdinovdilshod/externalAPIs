package com.company.service;

import com.company.Post;
import com.company.PostCreateDto;
import com.company.PostRepository;
import com.company.dto.CommentCreateDTO;
import com.company.dto.PostDTO;
import com.company.resource.CommentClient;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final CommentClient commentClient;

    @Override
    public PostDTO getPost(@NonNull Integer id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post Not Found"));

        return PostDTO.builder()
                .id(post.getId())
                .title(post.getTitle())
                .body(post.getBody())
                .comments(commentClient.getAllCommentsByPostId(post.getId()))
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
        commentClient.saveComments(dtos);
        return null;
    }


}
