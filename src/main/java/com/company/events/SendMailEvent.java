package com.company.events;

import lombok.*;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class SendMailEvent {
    private String email;
    private String otp;
}
