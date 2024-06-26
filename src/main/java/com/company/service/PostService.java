package com.company.service;

import com.company.Post;
import lombok.NonNull;

public interface PostService {
    Post getPost(@NonNull Integer id) throws Exception;

}
