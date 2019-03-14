package com.crud.kodillalibrary.repository;

import com.crud.kodillalibrary.domain.readers.Reader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public interface ReaderRepository extends CrudRepository<Reader,Long> {

    Reader save(Reader reader);

    Optional<Reader> findById(Long id);
}