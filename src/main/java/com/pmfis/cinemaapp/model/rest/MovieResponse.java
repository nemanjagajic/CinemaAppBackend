package com.pmfis.cinemaapp.model.rest;

// ono sto ja saljem na front
public class MovieResponse {

    private int id;
    private String title;
    private String genre;
    private String startTime;
    private String imdbLink;
    private Integer gradeSum;
    private Integer gradeNum;
    private Integer numberOfPersons;
    private Integer price;

    public MovieResponse() {

    }

    public MovieResponse(int id, String title, String genre, String startTime,
                         String imdbLink, Integer gradeSum, Integer gradeNum, Integer numberOfPersons, Integer price) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.startTime = startTime;
        this.imdbLink = imdbLink;
        this.gradeSum = gradeSum;
        this.gradeNum = gradeNum;
        this.numberOfPersons = numberOfPersons;
        this.price = price;
    }

    public MovieResponse(String title, String genre, String startTime, String imdbLink, Integer gradeSum, Integer gradeNum, Integer numberOfPersons) {
        this.title = title;
        this.genre = genre;
        this.startTime = startTime;
        this.imdbLink = imdbLink;
        this.gradeSum = gradeSum;
        this.gradeNum = gradeNum;
        this.numberOfPersons = numberOfPersons;
    }

    public Integer getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setNumberOfPersons(Integer numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Integer getGradeSum() {
        return gradeSum;
    }

    public void setGradeSum(Integer gradeSum) {
        this.gradeSum = gradeSum;
    }

    public Integer getGradeNum() {
        return gradeNum;
    }

    public void setGradeNum(Integer gradeNum) {
        this.gradeNum = gradeNum;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
