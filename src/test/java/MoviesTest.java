import com.github.sunitparekh.Movie;
import com.github.sunitparekh.Movies;
import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;


public class MoviesTest {

    Movie munnaBhaiMBBS = new Movie("Munna Bhai M.B.B.S.", LocalDate.of(2003, 12, 19), "Sanjay Datt", "Gracy Singh");
    Movie lageRahoMunnaBhai = new Movie("Lage Raho Munna Bhai", LocalDate.of(2006, 9, 1), "Sanjay Datt", "Vidya Balan");
    Movie threeIdiot = new Movie("3 Idiots", LocalDate.of(2009, 12, 25), "Amir Khan", "Kareena Kapoor");

    @Test
    public void shouldSortMoviesOnReleaseDate() {

        Movies movies = new Movies(threeIdiot,lageRahoMunnaBhai,munnaBhaiMBBS);

        movies.sortByReleaseDate();

        assertThat(movies.get(0), equalTo(munnaBhaiMBBS));
        assertThat(movies.get(1), equalTo(lageRahoMunnaBhai));
        assertThat(movies.get(2), equalTo(threeIdiot));
    }

    @Test
    public void shouldFilterMoviesOnLeadActorIgnoringCase() {

        Movies movies = new Movies(threeIdiot,lageRahoMunnaBhai,munnaBhaiMBBS);

        movies = movies.filterByLeadActor("amir khan");

        assertThat(movies.size(),equalTo(1));
        assertThat(movies.get(0), equalTo(threeIdiot));
    }
}
