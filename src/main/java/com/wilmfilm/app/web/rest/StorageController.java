package com.wilmfilm.app.web.rest;

import com.wilmfilm.app.service.StorageService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/file")
public class StorageController {

    @Autowired
    private StorageService storageService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam(value = "file") MultipartFile file) {
        return new ResponseEntity<>(storageService.uploadFile(file), HttpStatus.OK);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    //    @GetMapping("/download/{fileName}")
    //    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileName) {
    //        byte[] data = storageService.downloadFile(fileName);
    //        ByteArrayResource resource = new ByteArrayResource(data);
    //        return ResponseEntity.ok()
    //            .contentLength(data.length)
    //            .header("Content-Type", "application/octet-stream")
    //            .header("Content-Disposition", "Attachment; filename=\"" + fileName + "\"")
    //            .body(resource);
    //    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileName) {
        byte[] data = storageService.downloadFile(fileName);
        ByteArrayResource resource = new ByteArrayResource(data);

        // Save the file to a specific directory on the server
        String directory = "/Users/ali/Desktop";
        try {
            Path filePath = Paths.get(directory, fileName);
            Files.write(filePath, data);
        } catch (IOException e) {
            // Handle file save error
        }

        return ResponseEntity.ok()
            .contentLength(data.length)
            .header("Content-Type", "application/octet-stream")
            .header("Content-Disposition", "attachment; filename=\"" + fileName + "\"")
            .body(resource);
    }

    @DeleteMapping("/delete/{fileName}")
    public ResponseEntity<String> deleteFile(@PathVariable String fileName) {
        return new ResponseEntity<>(storageService.deleteFile(fileName), HttpStatus.OK);
    }
}
