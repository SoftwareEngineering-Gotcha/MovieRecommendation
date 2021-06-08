package edu.knu.se.domain;





import javax.persistence.*;

@Entity
@SequenceGenerator(
        name = "FOR_RATING_SEQ",
        sequenceName = "seq_rating",
        initialValue = 1,
        allocationSize = 1
)
@Table(name = "ratings")
public class Ratings {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "FOR_RATING_SEQ")
    private Long id;

    @Column
    private Long userid;

    @Column
    private Long movieid;

    @Column
    private Float rating;

    @Column
    private Long timestamp;

    public Ratings() {
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public void setMovieid(Long movieid) {
        this.movieid = movieid;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Long getUserid() {
        return userid;
    }

    public Long getMovieid() {
        return movieid;
    }

    public Float getRating() {
        return rating;
    }

    public Long getTimestamp() {
        return timestamp;
    }
}
