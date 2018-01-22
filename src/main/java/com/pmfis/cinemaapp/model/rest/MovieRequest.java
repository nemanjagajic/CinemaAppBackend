package com.pmfis.cinemaapp.model.rest;


// ono sto meni dolazi s fronta
public class MovieRequest {

    private String title;
    private String genre;
    private String startTime;
    private String imdbLink;
    private Integer price;

    public MovieRequest () {

    }

    public MovieRequest(String title, String genre, String startTime, String imdbLink, Integer price) {
        this.title = title;
        this.genre = genre;
        this.startTime = startTime;
        this.imdbLink = imdbLink;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getImdbLink() {
        return imdbLink;
    }

    public void setImdbLink(String imdbLink) {
        this.imdbLink = imdbLink;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
