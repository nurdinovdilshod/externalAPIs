package com.company.service;

import com.company.dto.UserCreateDTO;
import com.company.entity.AuthUser;

public interface UserService {
    AuthUser create(UserCreateDTO dto);
}
