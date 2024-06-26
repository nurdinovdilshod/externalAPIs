package com.company.resource;

import com.company.dto.CommentCreateDTO;
import com.company.dto.CommentDTO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentResource {
    private final WebClient webClient;

    @Value("${comments.base.postComments}")
    private String postCommentsUrl;
    @Value("${comments.base.saveComments}")
    private String saveCommentsUrl;

    public List<CommentDTO> getAllComments(@NonNull Integer postId) {
        return webClient
                .get()
                .uri(postCommentsUrl, postId)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<CommentDTO>>() {
                })
                .block();

    }

    public void saveAll(List<CommentCreateDTO> commentCreateDTO) {

        webClient
                .post()
                .uri(saveCommentsUrl)
                .body(BodyInserters.fromValue(commentCreateDTO))
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

}
