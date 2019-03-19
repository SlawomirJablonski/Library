package com.crud.kodillalibrary.domain.rents;

import com.crud.kodillalibrary.domain.copies.CopyDto;
import com.crud.kodillalibrary.domain.readers.ReaderDto;
import lombok.NoArgsConstructor;
import java.util.Date;

@NoArgsConstructor
public class RentDto {
    private Long id;
    private ReaderDto readerDto;
    private CopyDto copyDto;
    private Date rentDate;
    private Date returnDate;

    public RentDto(Long id, ReaderDto readerDto, CopyDto copyDto, Date rentDate, Date returnDate) {
        this.id = id;
        this.readerDto = readerDto;
        this.copyDto = copyDto;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
    }

    public Long getId() {
        return id;
    }

    public ReaderDto getReaderDto() {
        return readerDto;
    }

    public CopyDto getCopyDto() {
        return copyDto;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }
}
