package com.github.sunitparekh;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Movies extends ArrayList<Movie> {

    public Movies(Movie... movies) {
        for (Movie m : movies) { add(m); }
    }

    public void sortByReleaseDate() {
        sort((m1, m2) -> m1.getReleaseDate().compareTo(m2.getReleaseDate()));
    }

    public Movies filterByLeadActor(String leadActor) {
        return stream()
                .filter(movie -> movie.getLeadActor().equalsIgnoreCase(leadActor))
                .collect(Collectors.toCollection(Movies::new));
    }
}
