package app.vercel.mzaki.movies;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> allMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> movie(ObjectId id) {
        return movieRepository.findById(id);
    }

    public Optional<Movie> movieByImdbId(String imdbId) {
        return movieRepository.findByImdbId(imdbId);
    }
}
