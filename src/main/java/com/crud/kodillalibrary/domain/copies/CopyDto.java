package com.crud.kodillalibrary.domain.copies;

import com.crud.kodillalibrary.domain.Status;
import com.crud.kodillalibrary.domain.titles.TitleDto;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CopyDto {
    private Long id;
    private TitleDto titleDto;
    private Status status;

    public CopyDto(Long id, TitleDto titleDto, Status status) {
        this.id = id;
        this.titleDto = titleDto;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public TitleDto getTitleDto() {
        return titleDto;
    }

    public Status getStatus() {
        return status;
    }
}
