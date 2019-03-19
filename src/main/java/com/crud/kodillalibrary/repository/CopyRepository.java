package com.crud.kodillalibrary.repository;

import com.crud.kodillalibrary.domain.Status;
import com.crud.kodillalibrary.domain.copies.Copy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public interface CopyRepository extends CrudRepository<Copy,Long> {

    Copy findById(Long id);

    Optional<Copy> findCopyById(Long id);

    List<Copy> findAll();

}
