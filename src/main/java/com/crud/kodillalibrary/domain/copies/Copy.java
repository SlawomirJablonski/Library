package com.crud.kodillalibrary.domain.copies;

import com.crud.kodillalibrary.domain.Status;
import com.crud.kodillalibrary.domain.rents.Rent;
import com.crud.kodillalibrary.domain.titles.Title;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "COPIES")
public class Copy {

    private Long id;
    private Title title;
    private Status status;
    private List<Rent> rentList = new ArrayList<>();

    public Copy() {
    }

    public Copy(Title title, Status status) {
        this.title = title;
        this.status = status;
    }

    @Id
    @GeneratedValue
    @Column(name = "ID",unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "TITLE_ID")
    public Title getTitle() {
        return title;
    }

    @Column(name = "STATUS")
    public Status getStatus() {
        return status;
    }

    @OneToMany(
            targetEntity=Rent.class,
            mappedBy="copy",
            cascade = CascadeType.ALL,
            fetch=FetchType.LAZY  )
    public List<Rent> getRentList() {
        return rentList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setRentList(List<Rent> rentList) {
        this.rentList = rentList;
    }

}