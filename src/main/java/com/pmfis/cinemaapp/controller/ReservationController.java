package com.pmfis.cinemaapp.controller;

import com.pmfis.cinemaapp.dao.MovieDAO;
import com.pmfis.cinemaapp.model.persistence.Movie;
import com.pmfis.cinemaapp.model.persistence.Person;
import com.pmfis.cinemaapp.model.rest.MovieResponse;
import com.pmfis.cinemaapp.model.rest.PersonResponse;
import com.pmfis.cinemaapp.model.rest.ReservationRequest;
import com.pmfis.cinemaapp.model.rest.ReservationResponse;
import org.hibernate.collection.internal.PersistentBag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;


@Controller
@RequestMapping("movie/reservation")
public class ReservationController {

    @Autowired
    private MovieDAO movieDAO;

    public List<ReservationResponse> getAll() {
        return null;
    }

    public ReservationResponse getById(int id) {
        return null;
    }

    // create reservation
    @ResponseBody
    @PostMapping("add")
    public ReservationResponse post(@RequestBody ReservationRequest entity) {
        movieDAO.addReservation(entity.getIdMovie(), entity.getIdPerson());

        ReservationResponse response = new ReservationResponse();
        response.setIdMovie(entity.getIdMovie());
        response.setIdPerson(entity.getIdPerson());

        return response;
    }

    public ReservationResponse put(int id, ReservationRequest entity) {
        return null;
    }


    @ResponseBody
    @DeleteMapping("delete/{idMovie}/{idPerson}")
    public ReservationResponse delete(@PathVariable int idMovie, @PathVariable int idPerson) {
        movieDAO.deleteReservation(idMovie, idPerson);

        ReservationResponse response = new ReservationResponse();
        response.setIdMovie(idMovie);
        response.setIdPerson(idPerson);

        return response;
    }

    @ResponseBody
    @GetMapping("getMovies/{personId}")
    public List<MovieResponse> getMovies(@PathVariable int personId) {
        List<Movie> movies = movieDAO.getReservationByPersonId(personId);
        List<MovieResponse> response = new LinkedList<>();

        for (Movie m: movies) {
            response.add(new MovieResponse(
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

        return response;
    }

    @ResponseBody
    @GetMapping("getPersons/{movieId}")
    public List<PersonResponse> getPersons(@PathVariable int movieId) {
        List<Person> persons = movieDAO.getReservationByMovieId(movieId);
        List<PersonResponse> response = new LinkedList<>();

        for (Person p: persons) {
            response.add(new PersonResponse(
               p.getId(),
               p.getUsername(),
               p.getPassword(),
               p.getRole()
            ));
        }

        return response;
    }
}
