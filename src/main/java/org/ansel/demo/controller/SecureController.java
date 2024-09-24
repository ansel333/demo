package org.ansel.demo.controller;

import lombok.RequiredArgsConstructor;
import org.ansel.demo.common.config.JasyptConfigurations;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SecureController {
    private final JasyptConfigurations jasyptConfigurations;

    @PostMapping("/encrypt")
    public String encryptPassword(@RequestBody final Map<String, String> request) {
        return this.jasyptConfigurations.stringEncryptor().encrypt(request.get("password"));
    }

    @PostMapping("/decrypt")
    public String decryptPassword(@RequestBody final Map<String, String> request) {
        return this.jasyptConfigurations.stringEncryptor().decrypt(request.get("password"));
    }
}
