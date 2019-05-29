package com.crud.kodillalibrary.repository;

import com.crud.kodillalibrary.domain.Status;
import com.crud.kodillalibrary.domain.copies.Copy;
import com.crud.kodillalibrary.domain.titles.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TitleRepositoryTestSuite {

    /*@Autowired
    private TitleRepository titleRepository;

    @Test
    public void testTitleRepositorySave() {
        //Given
        Title testTitle = new Title("Java Puzzlers", "Joshua Bloch", 2009);
        Copy testCopy = new Copy(testTitle, Status.AVAILABLE);

        //When
        titleRepository.save(testTitle);

        //Then
        Long id = testTitle.getId();
        Optional<Title> readTitle = titleRepository.findById(id);
        Assert.assertTrue(readTitle.isPresent());

        //CleanUp
        titleRepository.delete(id);
    }*/
}
