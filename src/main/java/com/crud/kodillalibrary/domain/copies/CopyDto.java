package com.crud.kodillalibrary.domain.copies;

import com.crud.kodillalibrary.domain.Status;
import com.crud.kodillalibrary.domain.titles.Title;
import com.crud.kodillalibrary.domain.titles.TitleDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CopyDto {
    private Long id;
    private TitleDto titleDto;
    private Status status;
}
