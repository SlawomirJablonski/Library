package com.crud.kodillalibrary.repository;


import com.crud.kodillalibrary.domain.titles.Title;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Transactional
@Component
public interface TitleRepository extends CrudRepository<Title,Long> {

}
