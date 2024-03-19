package com.tdep.tadlab.service;

import com.tdep.tadlab.entity.projectDb.Link;
import com.tdep.tadlab.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LinkServiceImpl implements LinkService {

    @Autowired
    private LinkRepository linkRepository;

    public ResponseEntity<List<Link>> getAllLinks() {
        try {
            List<Link> links = new ArrayList<>(
                    linkRepository.findAll());

            if (links.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(links, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Link> getLinkById(int id) {
        Optional<Link> linkData = linkRepository.findById(id);

        return linkData.map(
                entry -> new ResponseEntity<>(
                        entry, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(
                        HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<Link> createLink(Link link) {
        try {
            Link _link = linkRepository
                    .save(new Link(
                            link.getEntryName(),
                            link.getEntryType(),
                            link.getLinkType(),
                            link.getUrl()
                    ));
            System.out.println(link);
            return new ResponseEntity<>(_link, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Link> updateLink(int id, Link link) {
        Optional<Link> linkData = linkRepository.findById(id);

        if (linkData.isPresent()) {
            System.out.println(linkData.get());
            Link _link = linkData.get();
            _link.setEntryName(link.getEntryName());
            _link.setEntryType(link.getEntryType());
            _link.setLinkType(link.getLinkType());
            _link.setUrl(link.getUrl());
            return new ResponseEntity<>(linkRepository.save(_link), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<HttpStatus> deleteLink(int id) {
        try {
            linkRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<HttpStatus> deleteAllLinks() {
        try {
            linkRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
