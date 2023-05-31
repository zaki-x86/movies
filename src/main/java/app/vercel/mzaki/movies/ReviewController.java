package app.vercel.mzaki.movies;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReview(@PathVariable String id) {
        return new ResponseEntity<Review>(reviewService.getReview(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Review> saveReview(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<Review>(reviewService.saveReview(payload.get("id"), payload.get("review")), HttpStatus.CREATED);
    }
}
