package Pi.Spring.Repositury;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import Pi.Spring.Entity.Commentaire;
import Pi.Spring.Entity.Post;


public interface CommentRepository extends CrudRepository<Commentaire, Long> {

	@Query("SELECT c FROM Commentaire c")
	@Transactional
	public List<Commentaire> retrieveAllCommentaire(Commentaire comment);
	
	
	@Query("select c from Commentaire  c LEFT JOIN c.CommentPosts p  WHERE p.idPost=?1")
	@Transactional
	public List<Commentaire> retrieveCommentByPost(Long idPost);
	
	

	
}
