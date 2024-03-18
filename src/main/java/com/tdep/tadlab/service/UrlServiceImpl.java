package com.tdep.tadlab.service;

import com.tdep.tadlab.entity.Url;
import com.tdep.tadlab.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UrlServiceImpl implements UrlService {

    @Autowired
    private UrlRepository urlRepository;

    public ResponseEntity<List<Url>> getAllUrls(String urlName) {
        try {
            List<Url> urls = new ArrayList<>();

            if (urlName == null) {
                urls.addAll(urlRepository.findAll());
            } else {
                urls.addAll(urlRepository.findUrlsByName(urlName));
            }
            if (urls.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(urls, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Url> getUrlById(long urlId) {
        Optional<Url> urlData = urlRepository.findById(urlId);

        return urlData.map(
                url -> new ResponseEntity<>(
                        url, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(
                        HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<Url> getUrlByName(String urlName) {
        Optional<Url> urlData = urlRepository.findByName(urlName);

        return urlData.map(
                url -> new ResponseEntity<>(
                        url, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(
                        HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<Url> createUrl(Url url) {
        try {
            Url _url = urlRepository
                    .save(new Url(
                            url.getUrlName(),
                            url.getUrl(),
                            url.getEntryId(),
                            url.getEntryName(),
                            url.getEntryType()));
            return new ResponseEntity<>(_url, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Url> updateUrl(long urlId, Url url) {
        Optional<Url> urlData = urlRepository.findById(urlId);

        if (urlData.isPresent()) {
            Url _url = urlData.get();
            _url.setUrlName(url.getUrlName());
            _url.setUrl(url.getUrl());
            _url.setEntryId(url.getEntryId());
            _url.setEntryName(url.getEntryName());
            _url.setEntryType(url.getEntryType());
            return new ResponseEntity<>(urlRepository.save(_url), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<HttpStatus> deleteUrl(long urlId) {
        try {
            urlRepository.deleteById(urlId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<HttpStatus> deleteAllUrls() {
        try {
            urlRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
