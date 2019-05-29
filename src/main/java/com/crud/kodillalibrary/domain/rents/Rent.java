package com.crud.kodillalibrary.domain.rents;

import com.crud.kodillalibrary.domain.copies.Copy;
import com.crud.kodillalibrary.domain.readers.Reader;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RENTS")
public class Rent {

    private Long id;
    private Reader reader;
    private Copy copy;
    private Date rentDate;
    private Date returnDate;

    public Rent() {
    }

    public Rent(Reader reader, Copy copy, Date rentDate) {
        this.reader = reader;
        this.copy = copy;
        this.rentDate = rentDate;
    }

    @Id
    @GeneratedValue
    @Column(name = "ID",unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "READER_ID")
    public Reader getReader() {
        return reader;
    }

    @ManyToOne
    @JoinColumn(name = "COPY_ID")
    public Copy getCopy() {
        return copy;
    }

    @Column(name = "RENT_DATE", nullable = false)
    public Date getRentDate() {
        return rentDate;
    }

    @Column(name = "RETURN_DATE")
    public Date getReturnDate() {
        return returnDate;
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
