package com.pmfis.cinemaapp.model.persistence;

import javax.persistence.*;
import java.util.List;

@Entity
public class Movie {
    private int id;
    private String title;
    private String genre;
    private String startTime;
    private String imdbLink;
    private Integer gradeSum;
    private Integer gradeNum;
    private Integer numberOfPersons;
    private List<Person> persons;
    private Integer price;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "genre")
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Basic
    @Column(name = "start_time")
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "imdb_link")
    public String getImdbLink() {
        return imdbLink;
    }

    public void setImdbLink(String imdbLink) {
        this.imdbLink = imdbLink;
    }

    @Basic
    @Column(name = "grade_sum")
    public Integer getGradeSum() {
        return gradeSum;
    }

    public void setGradeSum(Integer gradeSum) {
        this.gradeSum = gradeSum;
    }

    @Basic
    @Column(name = "grade_num")
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

    @Basic
    @Column(name = "number_of_persons")
    public Integer getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setNumberOfPersons(Integer numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (id != movie.id) return false;
        if (title != null ? !title.equals(movie.title) : movie.title != null) return false;
        if (genre != null ? !genre.equals(movie.genre) : movie.genre != null) return false;
        if (startTime != null ? !startTime.equals(movie.startTime) : movie.startTime != null) return false;
        if (imdbLink != null ? !imdbLink.equals(movie.imdbLink) : movie.imdbLink != null) return false;
        if (gradeSum != null ? !gradeSum.equals(movie.gradeSum) : movie.gradeSum != null) return false;
        if (gradeNum != null ? !gradeNum.equals(movie.gradeNum) : movie.gradeNum != null) return false;
        if (numberOfPersons != null ? !numberOfPersons.equals(movie.numberOfPersons) : movie.numberOfPersons != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (imdbLink != null ? imdbLink.hashCode() : 0);
        result = 31 * result + (gradeSum != null ? gradeSum.hashCode() : 0);
        result = 31 * result + (gradeNum != null ? gradeNum.hashCode() : 0);
        result = 31 * result + (numberOfPersons != null ? numberOfPersons.hashCode() : 0);
        return result;
    }


    @ManyToMany
    @JoinTable(name = "reservation", catalog = "", schema = "cinema",
            joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "person_id", referencedColumnName = "id", nullable = false))
    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
