package com.company.service;

import com.company.PostCreateDto;
import com.company.dto.CommentCreateDTO;
import com.company.dto.PostDTO;
import lombok.NonNull;

import java.util.List;

public interface PostService {
    PostDTO getPost(@NonNull Integer id);
    PostDTO createPost(@NonNull PostCreateDto dto);

    Void createComments(List<CommentCreateDTO> dtos);
}
