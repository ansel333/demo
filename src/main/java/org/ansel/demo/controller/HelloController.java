package org.ansel.demo.controller;

import com.google.common.collect.Maps;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public Map<String, String> hello(
            @RequestParam(required = false, defaultValue = "world") String name
    ) {
        Map<String, String> result = Maps.newHashMap();
        result.put("message", "hello " + name);
        return result;
    }
}
