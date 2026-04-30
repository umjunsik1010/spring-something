package com.example.umjunsik.controller;

import com.example.umjunsik.domain.User;
import com.example.umjunsik.service.AuthService;
import com.example.umjunsik.service.ImageService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class ImageController {
    private final AuthService authService;
    private final ImageService iamgeService;

    @Autowired
    public ImageController(AuthService authService, ImageService imageService) {
        this.authService = authService;
        this.iamgeService = imageService;
    }

    @PutMapping("/users/image")
    public ResponseEntity<String> updateUserImage(@RequestParam("image") MultipartFile image, HttpServletRequest request) throws IOException {
        User currentUser = authService.getCurrentUser(request);

        String savedImageName = iamgeService.updateUserImage(currentUser, image);
        return ResponseEntity.ok(savedImageName);
    }
}
