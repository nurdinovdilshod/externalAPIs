package com.company;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/task")
@RequiredArgsConstructor
public class PostController {
    private final TaskRepository taskRepository;

    @GetMapping
    public ResponseEntity<List<Task>> getAll() {
        log.info("Requests For All TAsks");
        return ResponseEntity.ok(taskRepository.getTasks());
    }


}
