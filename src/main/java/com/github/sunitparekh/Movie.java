package com.github.sunitparekh;

import java.time.LocalDate;

public class Movie {
    private final String title;
    private final LocalDate releaseDate;
    private final String leadActor;
    private final String leadActress;

    public Movie(String title, LocalDate releaseDate, String leadActor, String leadActress) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.leadActor = leadActor;
        this.leadActress = leadActress;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                '}';
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public String getLeadActor() {
        return leadActor;
    }

    public String getLeadActress() {
        return leadActress;
    }
}
