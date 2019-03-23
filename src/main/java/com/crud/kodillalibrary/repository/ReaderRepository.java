package com.crud.kodillalibrary.repository;

import com.crud.kodillalibrary.domain.readers.Reader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public interface ReaderRepository extends CrudRepository<Reader,Long> {

    Optional<Reader> getReaderById(Long id);

    List<Reader> findAll();
}