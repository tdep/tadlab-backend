package com.tdep.tadlab.controller;


//TODO: Change cross origins

import com.tdep.tadlab.entity.Url;
import com.tdep.tadlab.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class UrlController {

    @Autowired private UrlService urlService;

    @GetMapping("/urls")
    public ResponseEntity<List<Url>> getAllUrls(@RequestParam(required = false) String urlName) {
        return urlService.getAllUrls(urlName);
    }

    @GetMapping("/urls/{id}")
    public ResponseEntity<Url> getUrlById(@PathVariable("id") long urlId) {
        return urlService.getUrlById(urlId);
    }

    @GetMapping("urls/{name}")
    public ResponseEntity<Url> getUrlByName(@PathVariable("name") String urlName) {
        return urlService.getUrlByName(urlName);
    }

    @PostMapping("/urls")
    public ResponseEntity<Url> createUrl(@RequestBody Url url) {
        return urlService.createUrl(url);
    }

    @PutMapping("/urls/{id}")
    public ResponseEntity<Url> updateUrl(@PathVariable("id") long urlId, Url url) {
        return urlService.updateUrl(urlId, url);
    }

    @DeleteMapping("/urls/{id}")
    public ResponseEntity<HttpStatus> deleteUrl(@PathVariable("id") long urlId) {
        return urlService.deleteUrl(urlId);
    }

    @DeleteMapping("/urls")
    public ResponseEntity<HttpStatus> deleteAllUrls() {
        return urlService.deleteAllUrls();
    }
}
