package com.pmfis.cinemaapp.dao;

import com.pmfis.cinemaapp.model.persistence.Movie;
import com.pmfis.cinemaapp.model.persistence.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.LinkedList;
import java.util.List;

@Transactional
@Repository
public class MovieDAO implements BasicDAO<Movie> {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    PersonDAO personDAO;

    @Override
    public List<Movie> getAll() {
        String hql = "FROM Movie m ORDER BY m.id";

        return (List<Movie>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Movie getById(int id) {
        Movie movie = entityManager.find(Movie.class, id);

        if (movie != null) {
            return movie;
        } else {
            throw new IllegalArgumentException("Movie with the given id doesn't exist");
        }
    }

    @Override
    public Movie create(Movie entity) {
        entityManager.persist(entity);
        entityManager.flush();
        return entity;
    }

    @Override
    public Movie update(int id, Movie entity) {
        Movie movie = getById(id);
        movie.setTitle(entity.getTitle());
        movie.setGenre(entity.getGenre());
        movie.setStartTime(entity.getStartTime());
        movie.setImdbLink(entity.getImdbLink());
        movie.setPrice(entity.getPrice());

        entityManager.flush();

        return movie;
    }

    @Override
    public Movie delete(int id) {
        Movie movie = getById(id);
        entityManager.remove(movie);
        entityManager.flush();
        return movie;
    }

    public void addReservation(int idMovie, int idPerson) {
        Movie movie = getById(idMovie);
        Person person = personDAO.getById(idPerson);

        person.getMovies().add(movie);
        movie.getPersons().add(person);

        int count = movie.getNumberOfPersons();
        movie.setNumberOfPersons(count + 1);

        entityManager.flush();
    }

    public void deleteReservation(int idMovie, int idPerson) {
        Movie movie = getById(idMovie);
        Person person = personDAO.getById(idPerson);

        person.getMovies().remove(movie);
        movie.getPersons().remove(person);

        int count = movie.getNumberOfPersons();
        movie.setNumberOfPersons(count + 1);

        entityManager.flush();
    }

    // Get people who have reserved the movie
    public List<Person> getReservationByMovieId(int idMovie) {
        Movie movie = getById(idMovie);
        return movie.getPersons();

    }

    // Get movies reserved by the person
    public List<Movie> getReservationByPersonId(int idPerson) {
        Person person = personDAO.getById(idPerson);
        return person.getMovies();
    }

}
