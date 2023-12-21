package com.example.service;

import com.example.domain.entity.Actor;
import com.example.domain.entity.Director;
import com.example.domain.entity.Movie;
import com.example.domain.request.MovieRequest;
import com.example.domain.response.MovieResponse;
import com.example.repository.MovieRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
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
    public void 영화단건조회_정상조회_테스트() {
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

    @Test
    public void 영화단건조회_불가_테스트() {
        //given
        int movieId = 1;
        Movie movie = new Movie();
        movie.setName("hi");
        movie.setDirector(new Director());
        movie.setActors(List.of(new Actor()));

        //when
        when(movieRepository.findById(anyLong())).thenReturn(null);

        //then
        assertThrows(NullPointerException.class, () -> movieService.getMovie(movieId));
    }

    @Test
    public void 영화다건조회_테스트(){
        //given
        //List<Movie> movies = new List<Movie>;

        //when

        //then
    }

    @Test
    public void 영화저장_테스트(){
        //given
        MovieRequest movieRequest = new MovieRequest("new_name",2023);
        Movie movie = new Movie("new_name",2023);

        //when
        when(movieRepository.save(Mockito.any(Movie.class))).thenReturn(movie);
        doNothing().when(logService).saveLog();

        //then
        movieService.saveMovie(movieRequest);
    }

    @Test
    public void 영화업데이트_테스트(){
        //given
        long movieId = 1;
        MovieRequest movieRequest = new MovieRequest("new_name",2023);
        Movie movie = new Movie("exist_name",2022);
        movie.setId(movieId);

        //when
        when(movieRepository.findById(movieId)).thenReturn(Optional.of(movie));

        //then
        movieService.updateMovie(movieId,movieRequest);
    }

    @Test
    public void 영화삭제_테스트(){

    }


}
