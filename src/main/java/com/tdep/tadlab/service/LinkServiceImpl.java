package com.tdep.tadlab.service;

import com.tdep.tadlab.entity.Link;
import com.tdep.tadlab.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LinkServiceImpl implements LinkService {

    @Autowired
    private LinkRepository linkRepository;

    public ResponseEntity<List<Link>> getAllLinks(String linkName) {
        try {
            List<Link> links = new ArrayList<>();

            if (linkName == null) {
                links.addAll(linkRepository.findAll());
            } else {
                links.addAll(linkRepository.findLinksByName(linkName));
            }
            if (links.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Link> getLinkById(long linkId) {
        Optional<Link> linkData = linkRepository.findById(linkId);

        return linkData.map(
                link -> new ResponseEntity<>(
                        link, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(
                        HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<Link> getLinkByName(String linkName) {
        Optional<Link> linkData = linkRepository.findByName(linkName);

        return linkData.map(
                link -> new ResponseEntity<>(
                        link, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(
                        HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<Link> createLink(Link link) {
        try {
            Link _link = linkRepository
                    .save(new Link(
                            link.getLinkName(),
                            link.getLinkType(),
                            link.getUrlId(),
                            link.getEntryId(),
                            link.getProjectId(),
                            link.getEntryType()));
            return new ResponseEntity<>(_link, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Link> updateLink(long linkId, Link link) {
        Optional<Link> linkData = linkRepository.findById(linkId);

        if (linkData.isPresent()) {
            Link _link = linkData.get();
            _link.setLinkName(link.getLinkName());
            _link.setLinkType(link.getLinkType());
            _link.setUrlId(link.getUrlId());
            _link.setEntryId(link.getEntryId());
            _link.setProjectId(link.getProjectId());
            _link.setEntryType(link.getEntryType());
            return new ResponseEntity<>(linkRepository.save(_link), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<HttpStatus> deleteLink(long linkId) {
        try {
            linkRepository.deleteById(linkId);
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


