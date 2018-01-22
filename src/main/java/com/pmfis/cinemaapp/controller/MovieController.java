package com.pmfis.cinemaapp.controller;

import com.pmfis.cinemaapp.dao.MovieDAO;
import com.pmfis.cinemaapp.model.persistence.Movie;
import com.pmfis.cinemaapp.model.rest.MovieRequest;
import com.pmfis.cinemaapp.model.rest.MovieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;


@Controller
@RequestMapping("movie")
public class MovieController implements BasicController<MovieRequest, MovieResponse> {

    @Autowired
    private MovieDAO moviesDAO;

    @Override
    @ResponseBody
    @GetMapping("getAll")
    public List<MovieResponse> getAll() {
        List<Movie> result = moviesDAO.getAll();
        List<MovieResponse> responseList = new LinkedList<>();

        for (Movie m : result) {
            responseList.add(new MovieResponse(
                    m.getId(),
                    m.getTitle(),
                    m.getGenre(),
                    m.getStartTime(),
                    m.getImdbLink(),
                    m.getGradeSum(),
                    m.getGradeNum(),
                    m.getNumberOfPersons(),
                    m.getPrice()
            ));
        }

        return responseList;
    }

    @Override
    @ResponseBody
    @GetMapping("getMovie/{id}")
    public MovieResponse getById(@PathVariable("id") int id) {
        Movie result = moviesDAO.getById(id);
        MovieResponse response = new MovieResponse(
                result.getId(),
                result.getTitle(),
                result.getGenre(),
                result.getStartTime(),
                result.getImdbLink(),
                result.getGradeSum(),
                result.getGradeNum(),
                result.getNumberOfPersons(),
                result.getPrice()
        );

        return response;
    }

    // create
    @Override
    @ResponseBody
    @PostMapping("add")
    public MovieResponse post(@RequestBody MovieRequest entity) {
        Movie movie = new Movie();
        movie.setTitle(entity.getTitle());
        movie.setGenre(entity.getGenre());
        movie.setImdbLink(entity.getImdbLink());
        movie.setStartTime(entity.getStartTime());
        movie.setGradeNum(0);
        movie.setGradeSum(0);
        movie.setNumberOfPersons(0);

        moviesDAO.create(movie);

        MovieResponse response = new MovieResponse(
                movie.getId(),
                movie.getTitle(),
                movie.getGenre(),
                movie.getStartTime(),
                movie.getImdbLink(),
                movie.getGradeSum(),
                movie.getGradeNum(),
                movie.getNumberOfPersons(),
                movie.getPrice()
        );

        return response;
    }

    @Override
    @ResponseBody
    @PutMapping("put/{id}")
    public MovieResponse put(@PathVariable("id") int id, @RequestBody MovieRequest entity) {
        Movie movie = new Movie();

        movie.setTitle(entity.getTitle());
        movie.setGenre(entity.getGenre());
        movie.setStartTime(entity.getStartTime());
        movie.setImdbLink(entity.getImdbLink());

        moviesDAO.update(id, movie);

        MovieResponse response = new MovieResponse();
        response.setTitle(movie.getTitle());
        response.setGenre(movie.getGenre());
        response.setStartTime(movie.getStartTime());
        response.setImdbLink(movie.getImdbLink());

        return response;
    }

    @Override
    @ResponseBody
    @DeleteMapping("delete/{id}")
    public MovieResponse delete(@PathVariable("id") int id) {
        Movie result = moviesDAO.getById(id);

        MovieResponse response = new MovieResponse(
            result.getId(),
            result.getTitle(),
            result.getGenre(),
            result.getStartTime(),
            result.getImdbLink(),
            result.getGradeSum(),
            result.getGradeNum(),
            result.getNumberOfPersons(),
            result.getPrice()
        );

        moviesDAO.delete(id);

        return response;
    }
}
