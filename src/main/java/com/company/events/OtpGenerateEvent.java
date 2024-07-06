package com.company.events;

import com.company.entity.AuthUser;
import lombok.Getter;
import lombok.Value;

@Getter
@Value
public /*final*/ class OtpGenerateEvent {
     AuthUser authUser;


}
