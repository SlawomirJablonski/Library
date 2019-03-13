package com.crud.kodillalibrary.domain.rents;

import com.crud.kodillalibrary.domain.copies.Copy;
import com.crud.kodillalibrary.domain.readers.Reader;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;

@NoArgsConstructor
@Getter
@Entity(name = "RENTS")
public class Rent {
    //wypożyczeń, która zawiera id egzemplarza, id czytelnika, datę wypożyczenia i datę zwrotu.
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID",unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "READER_ID")
    private Reader reader;

    @ManyToOne
    @JoinColumn(name = "COPY_ID")
    private Copy copy;

    @NotNull
    @Column(name = "RENT_DATE")
    private Date rentDate;

    @Column(name = "RETURN_DATE")
    private Date returnDate;

    public Rent(Reader reader, Copy copy, Date rentDate) {
        this.reader = reader;
        this.copy = copy;
        this.rentDate = rentDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public void setCopy(Copy copy) {
        this.copy = copy;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
