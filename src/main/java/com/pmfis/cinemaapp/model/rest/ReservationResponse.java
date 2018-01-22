package com.pmfis.cinemaapp.model.rest;

public class ReservationResponse {

    private int id;
    private int idPerson;
    private int idMovie;

    public ReservationResponse() {
    }

    public ReservationResponse(int id, int idPerson, int idMovie) {
        this.id = id;
        this.idPerson = idPerson;
        this.idMovie = idMovie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public int getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(int idMovie) {
        this.idMovie = idMovie;
    }
}
