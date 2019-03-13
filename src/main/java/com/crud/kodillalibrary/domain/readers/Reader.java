package com.crud.kodillalibrary.domain.readers;

import com.crud.kodillalibrary.domain.rents.Rent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;



@Entity
@Table(name = "READERS")
public class Reader {

    private Long id;
    private String name;
    private String surname;
    private Date created;
    private List<Rent> rentList;

    public Reader() {
    }

    public Reader(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.created = new Date();
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public Long getId() {
        return id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    @Column(name = "SURNAME")
    public String getSurname() {
        return surname;
    }

    @NotNull
    @Column(name = "CREATED")
    public Date getCreated() {
        return created;
    }

    @OneToMany(
            targetEntity=Rent.class,
            mappedBy="reader",
            cascade = CascadeType.ALL,
            fetch=FetchType.LAZY  )
    public List<Rent> getRentList() {
        return rentList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setRentList(List<Rent> rentList) {
        this.rentList = rentList;
    }
}

//@AllArgsConstructor
//@NoArgsConstructor
//@Getter