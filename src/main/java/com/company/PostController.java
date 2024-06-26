package com.company;

import com.company.dto.CommentCreateDTO;
import com.company.dto.PostDTO;
import com.company.service.PostServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/post")
public class PostController {
    private final PostRepository postRepository;
    private final PostServiceImpl postServiceImpl;

    public PostController(PostRepository postRepository, PostServiceImpl postServiceImpl) {
        this.postRepository = postRepository;
        this.postServiceImpl = postServiceImpl;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getPost(@PathVariable Integer id) {
        return ResponseEntity.ok(postServiceImpl.getPost(id));

    }

    @PostMapping
    public ResponseEntity<PostDTO> create(@RequestBody PostCreateDto dto) {
        return ResponseEntity.ok(postServiceImpl.createPost(dto));
    }

    @PostMapping("/comment/create")
    public ResponseEntity<Void> createComments(@RequestBody List<CommentCreateDTO> dtos) {
        postServiceImpl.createComments(dtos);
        return ResponseEntity.noContent().build();
    }
}
