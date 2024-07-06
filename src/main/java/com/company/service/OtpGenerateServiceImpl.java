package com.company.service;

import com.company.entity.AuthUser;
import com.company.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OtpGenerateServiceImpl implements OtpService {

    private final UserRepository userRepository;

    @Override
    public void generateOtp(AuthUser user) {
        user.setOtp(UUID.randomUUID().toString());
        userRepository.save(user);

    }
}
