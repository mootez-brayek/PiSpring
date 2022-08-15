package Pi.Spring.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Pi.Spring.Entity.Commentaire;
import Pi.Spring.Entity.Post;
import Pi.Spring.Repositury.CommentRepository;
import Pi.Spring.Repositury.PostRepositury;

@Service
public class CommentServiceImpl implements CommentService{
	@Autowired
	PostRepositury postRepo;
	
	@Autowired
	CommentRepository commentRepo;

	@Override
	public String addAndAffectComment(Commentaire comment, Long idPost) {
		Post post=postRepo.findById(idPost).orElse(null);
		List<String> badwords=new ArrayList<>();
		badwords.add("badbad");
		badwords.add("badwords");
		badwords.add("bads");
		
		String motcommentaire[]=comment.getContent().split(" ");
		String com ="";
		for(String mots:motcommentaire){

			
			if (badwords.contains(mots)){
			    mots="*****";
				com=com+" "+mots;	
				comment.setContent(com);
				comment.setCommentPosts(post);
				post.setCommenters(post.getCommenters()+ 1);
				comment.setCreationDateComment(LocalDateTime.now());
				commentRepo.save(comment);
				
				return com;
			}
		else
			com=com+" "+mots;}
		comment.setContent(com);
		comment.setCommentPosts(post);
		post.setCommenters(post.getCommenters()+ 1);
		comment.setCreationDateComment(LocalDateTime.now());
		commentRepo.save(comment);
		
		return com;
		}


	@Override
	public Commentaire updateComment(Long idPost) {
		Commentaire comment=commentRepo.findById(idPost).orElse(null);
		return commentRepo.save(comment);
	}

	@Override
	public Commentaire retrieveCommentById(Long idComment) {
		return commentRepo.findById(idComment).orElse(null);
	}

	@Override
	public List<Commentaire> retrieveAllCommentaire(Commentaire comment) {
		
		return commentRepo.retrieveAllCommentaire(comment);
	}

	@Override
	public List<Commentaire> retrieveCommentByPost(Long idPost) {
		Post post= postRepo.findById(idPost).orElse(null);
		List<Commentaire> commentaires = post.getComments();
		return commentaires;
	}

	@Override
	public void deleteComment(Long idComment) {
		Commentaire c=commentRepo.findById(idComment).orElse(null);
		commentRepo.delete(c);
		
	}


}
