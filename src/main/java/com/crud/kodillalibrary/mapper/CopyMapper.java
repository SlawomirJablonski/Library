package com.crud.kodillalibrary.mapper;

import com.crud.kodillalibrary.domain.copies.Copy;
import com.crud.kodillalibrary.domain.copies.CopyDto;
import com.crud.kodillalibrary.domain.titles.Title;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CopyMapper {

    final
    TitleMapper titleMapper;

    @Autowired
    public CopyMapper(TitleMapper titleMapper) {
        this.titleMapper = titleMapper;
    }

    public Copy mapToCopy(CopyDto copyDto) {
        return new Copy(
                titleMapper.mapToTitle(copyDto.getTitleDto()),
                copyDto.getStatus());
    }

    public CopyDto mapToCopyDto(Copy copy) {
        return new CopyDto(
                copy.getId(),
                titleMapper.mapToTitleDto(copy.getTitle()),
                copy.getStatus());
    }
}
