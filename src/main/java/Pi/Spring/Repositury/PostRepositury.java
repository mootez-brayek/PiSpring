package Pi.Spring.Repositury;


import java.util.List;

import javax.transaction.Transactional;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Pi.Spring.Entity.Post;


@Repository
public interface PostRepositury extends CrudRepository<Post, Long>{
	
	@Query("SELECT p FROM Post p ")
	@Transactional
	public List<Post> retrieveAllPosts(Post post);
	
	
	@Query("SELECT p FROM Post p WHERE p.idPost=?1 ")
	@Transactional
	public List<Post> retrievePostById(Long idPost);
	
}
