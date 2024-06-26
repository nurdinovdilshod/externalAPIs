package com.company.resource;

import com.company.Post;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.client.Traverson;
import org.springframework.stereotype.Service;

import java.net.URI;

@Slf4j
@Service
public class CommentResource {
    @Value("${hateoas.base.url}")
    private String baseUrl;

    public Post getPost(@NonNull Integer id) throws Exception {
        Traverson traverson = new Traverson(new URI(baseUrl + id), MediaTypes.HAL_JSON);
        EntityModel<Post> entityModel = traverson
                .follow("self")
                .toObject(new ParameterizedTypeReference<>() {
                });
        if (entityModel == null) {
            return null;
        }
        for (Link link : entityModel.getLinks()) {
            log.info("Links From Hateoas API : " + link.getHref());
        }
        return entityModel.getContent();
    }

}
