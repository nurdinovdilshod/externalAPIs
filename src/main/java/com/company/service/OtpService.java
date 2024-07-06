package com.company.service;

import com.company.entity.AuthUser;

public interface OtpService {
    void generateOtp(AuthUser user);
}
