package com.crud.kodillalibrary.mapper;

import com.crud.kodillalibrary.domain.rents.Rent;
import com.crud.kodillalibrary.domain.rents.RentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RentMapper {

    final
    ReaderMapper readerMapper;
    final
    CopyMapper copyMapper;

    @Autowired
    public RentMapper(ReaderMapper readerMapper, CopyMapper copyMapper) {
        this.readerMapper = readerMapper;
        this.copyMapper = copyMapper;
    }

    public Rent mapToRent(RentDto rentDto) {
        return new Rent(
                readerMapper.mapToReder(rentDto.getReaderDto()),
                copyMapper.mapToCopy(rentDto.getCopyDto()),
                rentDto.getRentDate());
    }

    public RentDto mapToRentDto(Rent rent) {
        return new RentDto(
                rent.getId(),
                readerMapper.mapToReaderDto(rent.getReader()),
                copyMapper.mapToCopyDto(rent.getCopy()),
                rent.getRentDate(),
                rent.getReturnDate());
    }
}
