package com.tdep.tadlab.service;

import com.tdep.tadlab.entity.projectDb.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LinkService {

    ResponseEntity<List<Link>> getAllLinks();

    ResponseEntity<Link> getLinkById(int id);

    ResponseEntity<Link> createLink(Link link);

    ResponseEntity<Link> updateLink(int id, Link link);

    ResponseEntity<HttpStatus> deleteLink(int id);

    ResponseEntity<HttpStatus> deleteAllLinks();
}
