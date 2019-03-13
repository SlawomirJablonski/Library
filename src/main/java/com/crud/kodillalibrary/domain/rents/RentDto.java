package com.crud.kodillalibrary.domain.rents;

import com.crud.kodillalibrary.domain.copies.Copy;
import com.crud.kodillalibrary.domain.copies.CopyDto;
import com.crud.kodillalibrary.domain.readers.Reader;
import com.crud.kodillalibrary.domain.readers.ReaderDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RentDto {
    private Long id;
    private ReaderDto readerDto;
    private CopyDto copyDto;
    private Date rentDate;
    private Date returnDate;
}
