package app.vercel.mzaki.movies;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    
    private @Id ObjectId id;
    private String imdbId;
    private String body;
    private LocalDateTime created;
    private LocalDateTime updated;

    public Review(String imbdbId, String body, LocalDateTime created, LocalDateTime updated) {
        this.body = body;
        this.imdbId = imbdbId;
        this.created = created;
        this.updated = updated;
    }
}
