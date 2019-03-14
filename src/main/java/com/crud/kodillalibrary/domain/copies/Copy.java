package com.crud.kodillalibrary.domain.copies;

import com.crud.kodillalibrary.domain.Status;
import com.crud.kodillalibrary.domain.rents.Rent;
import com.crud.kodillalibrary.domain.titles.Title;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@NoArgsConstructor
@Getter
@Entity(name = "COPIES")
public class Copy {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID",unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "TITLE_ID")
    private Title title;
    //private Long titleId;

    @Column(name = "STATUS")
    private Status status;


    @OneToMany(
            targetEntity=Rent.class,
            mappedBy="copy",
            cascade = CascadeType.ALL,
            fetch=FetchType.LAZY  )
    private List<Rent> rentList;

    public Copy(Title title, Status status) {
        this.title = title;
        this.status = status;
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
