package com.crud.kodillalibrary.service;

import com.crud.kodillalibrary.domain.Status;
import com.crud.kodillalibrary.domain.copies.Copy;
import com.crud.kodillalibrary.domain.readers.Reader;
import com.crud.kodillalibrary.domain.rents.Rent;
import com.crud.kodillalibrary.domain.titles.Title;
import com.crud.kodillalibrary.repository.CopyRepository;
import com.crud.kodillalibrary.repository.ReaderRepository;
import com.crud.kodillalibrary.repository.RentRepository;
import com.crud.kodillalibrary.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {
    private final ReaderRepository readerRepository;
    private final TitleRepository titleRepository;
    private final CopyRepository copyRepository;
    private final RentRepository rentRepository;

    @Autowired
    public LibraryService(ReaderRepository readerRepository, TitleRepository titleRepository,
                          CopyRepository copyRepository, RentRepository rentRepository) {
        this.readerRepository = readerRepository;
        this.titleRepository = titleRepository;
        this.copyRepository = copyRepository;
        this.rentRepository = rentRepository;
    }

    public Optional<Reader> getReader(Long id) {
        return readerRepository.getReaderById(id);
    }

    public List<Reader> getReaders() {
        return readerRepository.findAll();
    }

    public void saveReader(final Reader reader){
        readerRepository.save(reader);
    }

    public void deleteReader(final Long id){
        readerRepository.delete(id);
    }

    public void saveTitle(final Title title){
        titleRepository.save(title);
    }

    public void saveCopy(final Copy copy) {
        copyRepository.save(copy);
    }

    public Optional<Title> getTitle(final Long id){
        return titleRepository.getTitleById(id);
    }

    public Optional<Copy> getCopyById(final Long id){
        return copyRepository.getCopyById(id);
    }

    public Optional<Copy> findAvailableCopy(final Long id){
        List<Copy> list = copyRepository.findAll();
        return list.stream()
                .filter(copy -> copy.getId().equals(id) & copy.getStatus()==Status.AVAILABLE)
                .findAny();
    }

    public Rent createRent(final Reader reader, final Copy copy){
        return new Rent(reader,copy,new Date());
    }

    public Optional<Rent> getRent(final Long rentId){
        return rentRepository.getRentById(rentId);
    }

    public Rent saveRent(final Rent rent){
        return rentRepository.save(rent);
    }

}
