package com.company.service;

import com.company.dto.UserCreateDTO;
import com.company.entity.AuthUser;
import com.company.events.OtpGenerateEvent;
import com.company.mapper.UserMapper;
import com.company.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final ApplicationEventPublisher publisher;

    @Override
    public AuthUser create(UserCreateDTO dto) {
        AuthUser authUser = userMapper.fromCreateDTO(dto);
        userRepository.save(authUser);
        publisher.publishEvent(new OtpGenerateEvent(authUser));
        return authUser;
    }
}
