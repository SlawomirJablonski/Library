package com.crud.kodillalibrary.controller;

import com.crud.kodillalibrary.domain.Status;
import com.crud.kodillalibrary.domain.copies.Copy;
import com.crud.kodillalibrary.domain.copies.CopyDto;
import com.crud.kodillalibrary.domain.readers.Reader;
import com.crud.kodillalibrary.domain.readers.ReaderDto;
import com.crud.kodillalibrary.domain.rents.Rent;
import com.crud.kodillalibrary.domain.rents.RentDto;
import com.crud.kodillalibrary.domain.titles.Title;
import com.crud.kodillalibrary.domain.titles.TitleDto;
import com.crud.kodillalibrary.exceptions.CopyNotFoundException;
import com.crud.kodillalibrary.exceptions.ReaderNotFoundException;
import com.crud.kodillalibrary.exceptions.RentNotFoundException;
import com.crud.kodillalibrary.exceptions.TitleNotFoundException;
import com.crud.kodillalibrary.mapper.CopyMapper;
import com.crud.kodillalibrary.mapper.ReaderMapper;
import com.crud.kodillalibrary.mapper.RentMapper;
import com.crud.kodillalibrary.mapper.TitleMapper;
import com.crud.kodillalibrary.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/v1/library")
public class LibraryController {

    private final LibraryService libraryService;
    private final ReaderMapper readerMapper;
    private final TitleMapper titleMapper;
    private final CopyMapper copyMapper;
    private final RentMapper rentMapper;

    @Autowired
    public LibraryController(LibraryService libraryService,
                             ReaderMapper readerMapper, TitleMapper titleMapper,
                             CopyMapper copyMapper, RentMapper rentMapper) {
        this.libraryService = libraryService;
        this.readerMapper = readerMapper;
        this.titleMapper = titleMapper;
        this.copyMapper = copyMapper;
        this.rentMapper = rentMapper;
    }

    @GetMapping("/readers/{id}")
    public ReaderDto getReaderById(@PathVariable Long id) throws ReaderNotFoundException {
        return readerMapper.mapToReaderDto(libraryService.getReader(id)
                .orElseThrow(() -> new ReaderNotFoundException("Missing reader in library DB")));
    }

    @GetMapping("/readers")
    public List<ReaderDto> getReaders() {
        return readerMapper.mapToReaderDtoList(libraryService.getReaders());
    }

    @PostMapping("/readers")
    public void createReader(@RequestBody ReaderDto readerDto) {
        libraryService.saveReader(readerMapper.mapToReder(readerDto));
    }

    @DeleteMapping("/readers/{id}")
    public void deleteReader(@PathVariable Long id) {
        libraryService.deleteReader(id);
    }

    //ok
    @PostMapping("/titles")
    public void createTitle(@RequestBody TitleDto titleDto) {
        libraryService.saveTitle(titleMapper.mapToTitle(titleDto));
    }

    @PostMapping("/copies/title/{titleId}")
    public void createCopy(@PathVariable Long titleId) throws TitleNotFoundException {
        Title title = libraryService.getTitle(titleId)
                .orElseThrow(() -> new TitleNotFoundException("Missing title in DB"));
        libraryService.saveCopy(copyMapper.mapToCopy(title));
    }

    @PutMapping("/copies")
    public void updateCopyStatus(@RequestBody CopyDto copyDto) throws CopyNotFoundException {
        Copy copy = libraryService.getCopyById(copyDto.getId())
                .orElseThrow(() -> new CopyNotFoundException("Missing copy in DB"));
        copy.setStatus(copyDto.getStatus());
        libraryService.saveCopy(copy);
    }

    @GetMapping("/copies/title/{titleId}")
    public int getAvailableCopies(@PathVariable Long titleId) throws TitleNotFoundException {
        Title title = libraryService.getTitle(titleId).
                orElseThrow(() -> new TitleNotFoundException("Missing title in DB"));
        List<CopyDto> available = copyMapper.mapToCopyDtoList(title.getCopyList());
        return available.size();
    }

    @PostMapping("/rents/readers/{readerId}/copies/{copyId}")
    public RentDto saveRent(@PathVariable Long readerId, @PathVariable Long copyId)
            throws ReaderNotFoundException, CopyNotFoundException {

        Reader readReader = libraryService.getReader(readerId)
                .orElseThrow(() -> new ReaderNotFoundException("Missing reader in library DB"));

        Copy readCopy = libraryService.findAvailableCopy(copyId)
                .orElseThrow(() -> new CopyNotFoundException("Missing available copy in DB"));

        readCopy.setStatus(Status.RENTED);
        libraryService.saveCopy(readCopy);
        Rent newRent = libraryService.createRent(readReader,readCopy);

        return rentMapper.mapToRentDto(libraryService.saveRent(newRent));
    }

    @PutMapping("/rents/{rentId}")
    public RentDto returnCopy(@PathVariable Long rentId) throws RentNotFoundException {
        Rent readRent = libraryService.getRent(rentId)
                .orElseThrow(() -> new RentNotFoundException("Missing rent in DB"));
        readRent.setReturnDate(new Date());
        Copy copy = readRent.getCopy();
        copy.setStatus(Status.AVAILABLE);
        return rentMapper.mapToRentDto(libraryService.saveRent(readRent));
    }
}
