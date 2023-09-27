package com.example.service;

import com.example.domain.entity.Actor;
import com.example.domain.entity.Director;
import com.example.domain.entity.Movie;
import com.example.domain.response.MovieResponse;
import com.example.repository.MovieRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

//mokito와 함께하겠다
@ExtendWith(MockitoExtension.class)
public class MovieServiceMockTest {

    //Mock 객체 만들기
    @Mock
    private MovieRepository movieRepository;
    @Mock
    private LogService logService;

    @InjectMocks
    private MovieService movieService;

    @Test
    @DisplayName("단건 조회 테스트")
    public void getMovieTest() {
        //given
        int movieId = 1;
        Movie movie = new Movie();
        movie.setName("hi");
        movie.setDirector(new Director());
        movie.setActors(List.of(new Actor()));

        //when
        when(movieRepository.findById(anyLong())).thenReturn(Optional.of(movie));

        //then
        MovieResponse result = movieService.getMovie(movieId);
        assertNotNull(result);
    }
}
