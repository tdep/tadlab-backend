package com.tdep.tadlab.service;

import com.tdep.tadlab.entity.PortfolioEntry;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PortfolioEntryService {

    ResponseEntity<List<PortfolioEntry>> getAllPortfolioEntries();

    ResponseEntity<PortfolioEntry> getPortfolioEntryById(long entryId);

    ResponseEntity<PortfolioEntry> createPortfolioEntry(PortfolioEntry portfolioEntry);

    ResponseEntity<PortfolioEntry> updatePortfolioEntry(long entryId, PortfolioEntry portfolioEntry);

    ResponseEntity<HttpStatus> deletePortfolioEntry(long entryId);

    ResponseEntity<HttpStatus> deleteAllPortfolioEntries();
}
