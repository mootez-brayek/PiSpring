package Pi.Spring.Service;

import java.util.List;

import Pi.Spring.Entity.Commentaire;
import Pi.Spring.Entity.Post;

public interface CommentService {

	public String addAndAffectComment(Commentaire comment, Long idPost);
	public Commentaire updateComment(Long idPost);
	public Commentaire retrieveCommentById(Long idComment);
	public List<Commentaire> retrieveAllCommentaire(Commentaire comment);
	public List<Commentaire> retrieveCommentByPost(Long idPost);
	public void deleteComment(Long idComment);
	
}
