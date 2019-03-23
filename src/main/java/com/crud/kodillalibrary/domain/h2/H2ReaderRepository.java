package com.crud.kodillalibrary.domain.h2;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface H2ReaderRepository extends JpaRepository<H2Reader, Long> {

    Optional<H2Reader> findById(Long id);

    List<H2Reader> findAll();
}
