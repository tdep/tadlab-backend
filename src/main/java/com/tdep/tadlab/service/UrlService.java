package com.tdep.tadlab.service;

import com.tdep.tadlab.entity.Url;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UrlService {

    ResponseEntity<List<Url>> getAllUrls(String urlName);

    ResponseEntity<Url> getUrlById(long urlId);

    ResponseEntity<Url> getUrlByName(String urlName);

    ResponseEntity<Url> createUrl(Url url);

    ResponseEntity<Url> updateUrl(long urlId, Url url);

    ResponseEntity<HttpStatus> deleteUrl(long urlId);

    ResponseEntity<HttpStatus> deleteAllUrls();
}
