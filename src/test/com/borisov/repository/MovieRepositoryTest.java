package com.borisov.repository;

import com.borisov.config.TestConfiguration;
import com.borisov.entity.Movie;
import com.borisov.util.DatabaseHelper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
@Transactional
public class MovieRepositoryTest {

    @Autowired
    private DatabaseHelper databaseHelper;

    @Autowired
    private MovieRepository movieRepository;

    @Before
    public void init(){
        databaseHelper.cleanDatabase();
        databaseHelper.prepareData();
    }

    @Test
    public void getById(){
        Optional<Movie> byId = movieRepository.findById(1L);
        System.out.println();
    }

    @Test
    public void findByNameTest(){
        Optional<Movie> memento = movieRepository.findByName("Memento");
        memento.ifPresent(System.out::println);
        assertTrue(memento.isPresent());
    }
}

