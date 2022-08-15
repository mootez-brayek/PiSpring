package Pi.Spring.Service;

import org.springframework.data.repository.query.Param;

import Pi.Spring.Entity.Post;
import Pi.Spring.Entity.RatingPost;

public interface RatingService {
public String rate(RatingPost rate,Long idPost);
public float rateTotale(Long idPost);
}
