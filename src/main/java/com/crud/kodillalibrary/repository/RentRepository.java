package com.crud.kodillalibrary.repository;

import com.crud.kodillalibrary.domain.rents.Rent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public interface RentRepository extends CrudRepository<Rent,Long> {

    Optional<Rent> getRentById(Long rentId);

    Rent save(Rent rent);

}