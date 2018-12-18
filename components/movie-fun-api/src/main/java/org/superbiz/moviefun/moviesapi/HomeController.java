package org.superbiz.moviefun.moviesapi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.Map;

@Controller
public class HomeController {

    private final MoviesClient moviesBean;
    private final MovieFixtures movieFixtures;


    public HomeController(MoviesClient moviesBean, MovieFixtures movieFixtures) {
        this.moviesBean = moviesBean;
        this.movieFixtures = movieFixtures;

    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/setup")
    public String setup(Map<String, Object> model) {
        for (MovieInfo movie : movieFixtures.load()) {
            moviesBean.addMovie(movie);
        }

        /*for (Album album : albumFixtures.load()) {
            albumsBean.addAlbum(album);
        }*/

        model.put("movies", moviesBean.getMovies());
        //model.put("albums", albumsBean.getAlbums());

        return "setup";
    }
}
