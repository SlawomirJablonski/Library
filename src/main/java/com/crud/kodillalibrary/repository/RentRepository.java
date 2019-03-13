package com.crud.kodillalibrary.repository;

import com.crud.kodillalibrary.domain.rents.Rent;
import org.springframework.data.repository.CrudRepository;

public interface RentRepository extends CrudRepository<Rent,Long> {

}
