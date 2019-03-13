package com.crud.kodillalibrary.mapper;

import com.crud.kodillalibrary.domain.titles.Title;
import com.crud.kodillalibrary.domain.titles.TitleDto;
import org.springframework.stereotype.Component;

@Component
public class TitleMapper {

    public Title mapToTitle(TitleDto titleDto){
        return new Title(
                titleDto.getTitle(),
                titleDto.getAuthor(),
                titleDto.getPublicationYear());
    }

    public TitleDto mapToTitleDto(Title title){
        return new TitleDto(
                title.getId(),
                title.getTitle(),
                title.getAuthor(),
                title.getPublicationYear());
    }
}
