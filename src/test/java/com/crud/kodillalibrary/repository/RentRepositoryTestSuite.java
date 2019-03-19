package com.crud.kodillalibrary.repository;

import com.crud.kodillalibrary.domain.Status;
import com.crud.kodillalibrary.domain.copies.Copy;
import com.crud.kodillalibrary.domain.readers.Reader;
import com.crud.kodillalibrary.domain.rents.Rent;
import com.crud.kodillalibrary.domain.titles.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RentRepositoryTestSuite {

    /*@Autowired
    private ReaderRepository readerRepository;
    @Autowired
    private TitleRepository titleRepository;
    @Autowired
    private CopyRepository copyRepository;
    @Autowired
    private RentRepository rentRepository;

    @Test
    public void testRentRepositorySave(){
        //Given
        Reader testReader = new Reader("Sebastian","Vettel");
        Title testTitle = new Title("Java Puzzlers", "Joshua Bloch", 2009);
        Copy testCopy = new Copy(testTitle, Status.AVAILABLE);
        Rent testRent = new Rent(testReader,testCopy,new Date());

        //When
        readerRepository.save(testReader);
        titleRepository.save(testTitle);
        copyRepository.save(testCopy);
        rentRepository.save(testRent);

        //Then
        Long id = testRent.getId();
        Long idReader = testReader.getId();
        Long idTitle = testTitle.getId();
        Long idCopy = testCopy.getId();
        Rent readRent = rentRepository.findById(id);
        Assert.assertEquals("Vettel",readRent.getReader().getSurname());

        //CleanUp
        rentRepository.delete(id);
        copyRepository.delete(idCopy);
        titleRepository.delete(idTitle);
        readerRepository.delete(idReader);
    }*/

}
