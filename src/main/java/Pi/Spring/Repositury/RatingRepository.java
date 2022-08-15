package Pi.Spring.Repositury;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import Pi.Spring.Entity.Post;
import Pi.Spring.Entity.RatingPost;



@Repository
public interface RatingRepository  extends CrudRepository<RatingPost, Long> {
	
	
	@Query("select AVG(r.rate) from RatingPost  r LEFT JOIN r.RatePost p  WHERE p.idPost=?1")
	@Transactional
	public float rateTotale(Long idPost);

	

}
