package com.company.listeners;

import com.company.entity.AuthUser;
import com.company.events.OtpGenerateEvent;
import com.company.events.SendMailEvent;
import com.company.repository.UserRepository;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class UserEventListeners {
    private final UserRepository userRepository;

    public UserEventListeners(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT,
//            condition = "#event.authUser.email ne null ")
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @EventListener
    @Async
    public CompletableFuture<SendMailEvent> generateOtpEventListener(OtpGenerateEvent event) throws InterruptedException {
        AuthUser authUser = event.getAuthUser();
        TimeUnit.SECONDS.sleep(10);
        authUser.setOtp(UUID.randomUUID().toString());
        log.info("Generate Otp with : {}", authUser);
        userRepository.save(authUser);
//        throw new RuntimeException("Exception For Testing EOP");
        return CompletableFuture.completedFuture(new SendMailEvent(authUser.getEmail(), authUser.getOtp()));
    }

    @EventListener({SendMailEvent.class})
    public void verificationMailSenderListener(OtpGenerateEvent event) {
        log.info("Maik send to : {}", event);
    }

}
