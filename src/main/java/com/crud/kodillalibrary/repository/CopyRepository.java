package com.crud.kodillalibrary.repository;

import com.crud.kodillalibrary.domain.copies.Copy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface CopyRepository extends CrudRepository<Copy,Long> {

}
