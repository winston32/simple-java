package com.example.simplejava.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

/**
 * Simple REST controller exposing add endpoints.
 */
@RestController
public class AddController {

    private static final Logger log = LoggerFactory.getLogger(AddController.class);

    // GET /add?a=3&b=5
    @GetMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Integer> addGet(@RequestParam(name = "a", defaultValue = "3") int a,
                                       @RequestParam(name = "b", defaultValue = "5") int b) {
        log.info("Received GET /add request with a={} b={}", a, b);
        int sum = a + b;
        log.debug("Computed sum for GET: {}", sum);
        return Map.of("a", a, "b", b, "sum", sum);
    }

    // POST /add with JSON body {"a": 4, "b": 6}
    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Integer> addPost(@RequestBody Map<String, Integer> body) {
        log.info("Received POST /add request; body={}", body);
        Integer a = body.get("a");
        Integer b = body.get("b");
        boolean usedDefault = false;

        // fallback to defaults if missing
        // if (Objects.isNull(a)) {
        //     a = 3;
        //     usedDefault = true;
        // }
        // if (Objects.isNull(b)) {
        //     b = 5;
        //     usedDefault = true;
        // }

        if (usedDefault) {
            log.warn("POST /add missing parameters; falling back to defaults a={} b={}", a, b);
        }

        int sum = a + b;
        log.debug("Computed sum for POST: {}", sum);
        return Map.of("a", a, "b", b, "sum", sum);
    }
}