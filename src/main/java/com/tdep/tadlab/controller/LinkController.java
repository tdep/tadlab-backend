package com.tdep.tadlab.controller;


//TODO: Change cross origins

import com.tdep.tadlab.entity.projectDb.Link;
import com.tdep.tadlab.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "PostmanRuntime/7.37.0")
@RestController
@RequestMapping("/api/v1")
public class LinkController {

    @Autowired private LinkService linkService;

    @GetMapping("/links")
    public ResponseEntity<List<Link>> getAllLinks() {
        return linkService.getAllLinks();
    }

    @GetMapping("/links/{id}")
    public ResponseEntity<Link> getLinkById(@PathVariable("id") int id) {
        return linkService.getLinkById(id);
    }

    @PostMapping("/links")
    public ResponseEntity<Link> createLink(@RequestBody Link link) {
        System.out.println(link);
        return linkService.createLink(link);
    }

    @PutMapping("/links/{id}")
    public ResponseEntity<Link> updateLink(@PathVariable("id") int id, @RequestBody Link link) {
        return linkService.updateLink(id, link);
    }

    @DeleteMapping("/links/{id}")
    public ResponseEntity<HttpStatus> deletePortfolioEntry(@PathVariable("id") int id) {
        return linkService.deleteLink(id);
    }

    @DeleteMapping("links")
    public ResponseEntity<HttpStatus> deleteAllLinks() {
        return linkService.deleteAllLinks();
    }
}
