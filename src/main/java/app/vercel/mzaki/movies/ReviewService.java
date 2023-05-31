package app.vercel.mzaki.movies;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public Review saveReview(String id, String review) {
        Review newReview = reviewRepository.insert(new Review(id, review, LocalDateTime.now(), LocalDateTime.now()));

        mongoTemplate.update(Movie.class)
            .matching(Criteria.where("imdbId").is(id))
            .apply(new Update().push("reviews").value(newReview))
            .first();

        return newReview;
    }

    public Review getReview(String id) {
        // Get Reviews by imdbId not ObjectId
        return reviewRepository.findByImdbId(id);

    }
}
