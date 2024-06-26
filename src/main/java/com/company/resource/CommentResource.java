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

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentResource {
    private final RestTemplate restTemplate;

    @Value("${comments.base.postComments}")
    private String postCommentsUrl;
    @Value("${comments.base.saveComments}")
    private String saveCommentsUrl;

    public List<CommentDTO> getAllComments(@NonNull Integer postId) {

//        ResponseEntity<List> responseEntity = restTemplate.getForEntity(url, List.class, post.getId());
//        List comments = responseEntity.getBody();
//        List comments = restTemplate.getForObject(url, List.class, post.getId());

//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("Authorization","Bearer ............");
//        httpHeaders.setBasicAuth("username", "123");
//        httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");

        try {
            return restTemplate.exchange(
                    postCommentsUrl,
                    HttpMethod.GET,
                    HttpEntity.EMPTY,
                    new ParameterizedTypeReference<List<CommentDTO>>() {
                    }, postId).getBody();
        } catch (ResourceAccessException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public void saveAll(List<CommentCreateDTO> commentCreateDTO) {
        HttpEntity<List<CommentCreateDTO>> httpEntity = new HttpEntity<>(commentCreateDTO);
        restTemplate.exchange(saveCommentsUrl, HttpMethod.POST, httpEntity, Void.class);
    }

}
