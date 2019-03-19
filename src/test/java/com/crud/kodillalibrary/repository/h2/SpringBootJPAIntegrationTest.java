package com.crud.kodillalibrary.repository.h2;

import com.crud.kodillalibrary.KodillaLibraryApplication;
import com.crud.kodillalibrary.domain.h2.H2Reader;
import com.crud.kodillalibrary.domain.h2.H2ReaderRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KodillaLibraryApplication.class)
public class SpringBootJPAIntegrationTest {

    @Autowired
    private H2ReaderRepository h2readerRepository;

    @Test
    public void testReaderRepositorySave() {
        //Given
        H2Reader testReader = new H2Reader("Sebastian", "Vettel");
        //When
        h2readerRepository.save(testReader);
        //Then
        long id = testReader.getId();
        Optional<H2Reader> readReader = h2readerRepository.findById(id);
        Assert.assertTrue(readReader.isPresent());
        //CleanUp
        h2readerRepository.delete(id);
    }
}
