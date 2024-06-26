package com.company;

import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Post}
 */
@Data
public class PostCreateDto implements Serializable {
    String title;
    String body;

}