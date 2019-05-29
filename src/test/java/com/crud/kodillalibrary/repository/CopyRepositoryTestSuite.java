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

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CopyRepositoryTestSuite {

    /*//najpierw save the transient instance before flushing kretynie!
    @Autowired
    private TitleRepository titleRepository;

    @Autowired
    private CopyRepository copyRepository;

    @Test
    public void testCopyRepositorySave() {
        //Given
        Title testTitle = new Title("Java Puzzlers", "Joshua Bloch", 2009);
        Copy testCopy = new Copy(testTitle, Status.AVAILABLE);

        //When
        titleRepository.save(testTitle);
        copyRepository.save(testCopy);

        //Then
        Status requestStatus = Status.AVAILABLE;
        Long id = testCopy.getId();
        Copy requestCopy = copyRepository.findById(id);
        Long idTitle = testTitle.getId();
        Assert.assertEquals(requestStatus, requestCopy.getStatus());
        Assert.assertEquals(2009, requestCopy.getTitle().getPublicationYear());

        //CleanUp
        copyRepository.delete(id);
        titleRepository.delete(idTitle);
    }*/
}
