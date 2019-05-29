package com.crud.kodillalibrary.mapper;

import com.crud.kodillalibrary.domain.Status;
import com.crud.kodillalibrary.domain.copies.Copy;
import com.crud.kodillalibrary.domain.copies.CopyDto;
import com.crud.kodillalibrary.domain.titles.Title;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CopyMapper {

    private final TitleMapper titleMapper;

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

    public Copy mapToCopy(Title title){
        return new Copy(title, Status.AVAILABLE);
    }

    public List<CopyDto> mapToCopyDtoList(List<Copy> list){
        return list.stream()
                .filter(copy -> copy.getStatus()==Status.AVAILABLE)
                .map(this::mapToCopyDto)
                .collect(Collectors.toList());
    }
}
