package com.pmfis.cinemaapp.model.rest;

public class ReservationRequest {

    private int idMovie;
    private int idPerson;

    public ReservationRequest() {

    }

    public ReservationRequest(int idMovie, int idPerson) {
        this.idMovie = idMovie;
        this.idPerson = idPerson;
    }

    public int getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(int idMovie) {
        this.idMovie = idMovie;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }
}
