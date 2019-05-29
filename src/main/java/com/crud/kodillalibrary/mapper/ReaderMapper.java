package com.crud.kodillalibrary.mapper;


import com.crud.kodillalibrary.domain.readers.Reader;
import com.crud.kodillalibrary.domain.readers.ReaderDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReaderMapper {
    public Reader mapToReder(ReaderDto readerDto) {
        return new Reader(
                readerDto.getName(),
                readerDto.getSurname());

    }

    public ReaderDto mapToReaderDto(Reader reader){
        return new ReaderDto(
                reader.getId(),
                reader.getName(),
                reader.getSurname(),
                reader.getCreated());
    }

    public List<ReaderDto> mapToReaderDtoList(List<Reader> list){
        return list.stream()
                .map(this::mapToReaderDto)
                .collect(Collectors.toList());
    }
}
