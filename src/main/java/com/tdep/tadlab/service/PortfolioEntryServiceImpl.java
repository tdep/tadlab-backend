package com.tdep.tadlab.service;

import com.tdep.tadlab.entity.PortfolioEntry;
import com.tdep.tadlab.repository.PortfolioEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PortfolioEntryServiceImpl implements PortfolioEntryService{

    @Autowired
    private PortfolioEntryRepository portfolioEntryRepository;

    public ResponseEntity<List<PortfolioEntry>> getAllPortfolioEntries() {
        try {
            List<PortfolioEntry> portfolioEntries = new ArrayList<>(
                    portfolioEntryRepository.findAll());

            if (portfolioEntries.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(portfolioEntries, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<PortfolioEntry> getPortfolioEntryById(long entryId) {
        Optional<PortfolioEntry> entryData = portfolioEntryRepository.findById(entryId);

        return entryData.map(
                entry -> new ResponseEntity<>(
                        entry, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(
                        HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<PortfolioEntry> createPortfolioEntry(PortfolioEntry portfolioEntry) {
        try {
            PortfolioEntry _portfolioEntry = portfolioEntryRepository
                    .save(new PortfolioEntry(
                            portfolioEntry.getEntryName(),
                            portfolioEntry.getEntryType()
                    ));
            System.out.println(portfolioEntry);
            return new ResponseEntity<>(_portfolioEntry, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<PortfolioEntry> updatePortfolioEntry(long entryId, PortfolioEntry portfolioEntry) {
        Optional<PortfolioEntry> entryData = portfolioEntryRepository.findById(entryId);

        if (entryData.isPresent()) {
            System.out.println(entryData.get());
            PortfolioEntry _portfolioEntry = entryData.get();
            _portfolioEntry.setEntryName(portfolioEntry.getEntryName());
            _portfolioEntry.setEntryType(portfolioEntry.getEntryType());
            return new ResponseEntity<>(portfolioEntryRepository.save(_portfolioEntry), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<HttpStatus> deletePortfolioEntry(long entryId) {
        try {
            portfolioEntryRepository.deleteById(entryId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<HttpStatus> deleteAllPortfolioEntries() {
        try {
            portfolioEntryRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
