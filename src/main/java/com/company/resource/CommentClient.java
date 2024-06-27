package com.company.resource;

import com.company.dto.CommentCreateDTO;
import com.company.dto.CommentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "CommentClient", url = "${comments.base.url}")
public interface CommentClient {
    @GetMapping("/{id}/post")
    List<CommentDTO> getAllCommentsByPostId(@PathVariable Integer id);
    @PostMapping("/saveAll")
    List<CommentDTO> saveComments(@RequestBody List<CommentCreateDTO> dtos);
}
