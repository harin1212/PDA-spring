package com.example.controller;

import com.example.domain.Movie;
import com.example.domain.request.MovieRequest;
import com.example.service.MovieService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name="무비 컨트롤러다")
@RestController //컨트롤러임을 인식하게 해줌
@RequiredArgsConstructor //생성자로 autowired
@RequestMapping("/api")

public class MovieController {
    private final MovieService movieService; //주입받기
    @GetMapping(value = "/v1/movies")
    public List<Movie> getMovies(){
        return movieService.getMovies();
    }
    
    @GetMapping("/v1/movies/{movieId}")
    public Movie getMovie(
            //movieId 받기 위해 설정
            @PathVariable(value = "movieId") long movieId
    ){
        return movieService.getMovie(movieId);
    }

    @PostMapping("/v1/movies")
    public void createMovie(
            //객체정보 받기 -> post, put api에서만 사용
            @RequestBody MovieRequest movieRequest
            ){
        movieService.createMovie(movieRequest);
    }

    @PutMapping("/v1/movies/{movieId}")
    public void updateMovie(
            @PathVariable(value = "movieId") long movieId
    ){
        movieService.updateMovie(movieId);
    }

    @DeleteMapping("/v1/movies/{movieId}")
    public void deleteMovie(
            @PathVariable(value = "movieId") long movieId
    ){
        movieService.deleteMovie(movieId);
    }
}
