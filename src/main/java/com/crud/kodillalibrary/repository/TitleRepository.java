package com.crud.kodillalibrary.repository;

import com.crud.kodillalibrary.domain.titles.Title;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public interface TitleRepository extends CrudRepository<Title,Long> {

    Optional<Title> getTitleById(Long id);

}