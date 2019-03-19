
package com.crud.kodillalibrary.repository;

import com.crud.kodillalibrary.domain.readers.Reader;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReaderRepositoryTestSuite {

    /*@Autowired
    private ReaderRepository readerRepository;

    @Test
    public void testReaderRepositorySave(){
        //Given
        Reader testReader = new Reader("Sebastian","Vettel");
        //When
        readerRepository.save(testReader);
        //Then
        long id = testReader.getId();
        Optional<Reader> readReader = readerRepository.findById(id);
        Assert.assertTrue(readReader.isPresent());
        //CleanUp
        readerRepository.delete(id);

    }*/
}