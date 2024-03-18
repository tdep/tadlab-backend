package com.tdep.tadlab.service;

import com.tdep.tadlab.entity.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LinkService {

    ResponseEntity<List<Link>> getAllLinks();

    ResponseEntity<Link> getLinkById(long linkid);

    ResponseEntity<Link> createLink(Link link);

    ResponseEntity<Link> updateLink(long linkId, Link link);

    ResponseEntity<HttpStatus> deleteLink(long linkId);

    ResponseEntity<HttpStatus> deleteAllLinks();
}
