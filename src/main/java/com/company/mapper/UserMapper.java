package com.company.mapper;

import com.company.dto.UserCreateDTO;
import com.company.entity.AuthUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    AuthUser fromCreateDTO(UserCreateDTO dto);

}