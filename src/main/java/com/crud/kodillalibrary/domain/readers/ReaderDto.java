package com.crud.kodillalibrary.domain.readers;

import lombok.NoArgsConstructor;
import java.util.Date;

@NoArgsConstructor
public class ReaderDto {
    private Long id;
    private String name;
    private String surname;
    private Date created;

    public ReaderDto(Long id, String name, String surname, Date created) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getCreated() {
        return created;
    }
}
