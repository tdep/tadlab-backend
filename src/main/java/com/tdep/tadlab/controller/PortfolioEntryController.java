package com.tdep.tadlab.controller;


//TODO: Change cross origins

import com.tdep.tadlab.entity.PortfolioEntry;
import com.tdep.tadlab.service.PortfolioEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class PortfolioEntryController {

    @Autowired private PortfolioEntryService portfolioEntryService;

    @GetMapping("/entries")
    public ResponseEntity<List<PortfolioEntry>> getAllPortfolioEntries(@RequestParam(required = false) String entryName) {
        return portfolioEntryService.getAllPortfolioEntries(entryName);
    }

    @GetMapping("/entries/{id}")
    public ResponseEntity<PortfolioEntry> getPortfolioEntryById(@PathVariable("id") long entryId) {
        return portfolioEntryService.getPortfolioEntryById(entryId);
    }

    @GetMapping("/entries/{name}")
    public ResponseEntity<PortfolioEntry> getPortfolioEntryByName(@PathVariable("name") String entryName) {
        return portfolioEntryService.getPortfolioEntryByName(entryName);
    }

    @PostMapping("/entries")
    public ResponseEntity<PortfolioEntry> createPortfolioEntry(@RequestBody PortfolioEntry portfolioEntry) {
        return portfolioEntryService.createPortfolioEntry(portfolioEntry);
    }

    @PutMapping("/entries/{id}")
    public ResponseEntity<PortfolioEntry> updatePortfolioEntry(@PathVariable("id") long entryId, PortfolioEntry portfolioEntry) {
        return portfolioEntryService.updatePortfolioEntry(entryId, portfolioEntry);
    }

    @DeleteMapping("/entries/{id}")
    public ResponseEntity<HttpStatus> deletePortfolioEntry(@PathVariable("id") long entryId) {
        return portfolioEntryService.deletePortfolioEntry(entryId);
    }

    @DeleteMapping("entries")
    public ResponseEntity<HttpStatus> deleteAllPortfolioEntries() {
        return portfolioEntryService.deleteAllPortfolioEntries();
    }
}
