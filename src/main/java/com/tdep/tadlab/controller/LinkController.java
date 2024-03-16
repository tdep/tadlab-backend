package com.tdep.tadlab.controller;


//TODO: Change cross origins

import com.tdep.tadlab.entity.Link;
import com.tdep.tadlab.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class LinkController {

    @Autowired private LinkService linkService;

    @GetMapping("/links")
    public ResponseEntity<List<Link>> getAllLinks(@RequestParam(required = false) String linkName) {
        return linkService.getAllLinks(linkName);
    }

    @GetMapping("/links/{id}")
    public ResponseEntity<Link> getLinkById(@PathVariable("id") long linkId) {
        return linkService.getLinkById(linkId);
    }

    @GetMapping("/links/{name}")
    public ResponseEntity<Link> getLinkByName(@PathVariable("name") String linkName) {
        return linkService.getLinkByName(linkName);
    }

    @PostMapping("/links")
    public ResponseEntity<Link> createLink(@RequestBody Link link) {
        return linkService.createLink(link);
    }

    @PutMapping("/links/{id}")
    public ResponseEntity<Link> updateLink(@PathVariable("id") long linkId, Link link) {
        return linkService.updateLink(linkId, link);
    }

    @DeleteMapping("/links/{id}")
    public ResponseEntity<HttpStatus> deleteLink(@PathVariable("id") long linkId) {
        return linkService.deleteLink(linkId);
    }

    @DeleteMapping("/links")
    public ResponseEntity<HttpStatus> deleteAllLinks() { return linkService.deleteAllLinks(); }
}
