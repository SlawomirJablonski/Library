package com.crud.kodillalibrary.repository;

import com.crud.kodillalibrary.domain.copies.Copy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public interface CopyRepository extends CrudRepository<Copy,Long> {

    Optional<Copy> getCopyById(Long id);

    List<Copy> findAll();

}
