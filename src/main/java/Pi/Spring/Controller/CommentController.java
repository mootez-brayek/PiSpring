package Pi.Spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Pi.Spring.Entity.Commentaire;
import Pi.Spring.Entity.Post;
import Pi.Spring.Service.CommentService;

@RestController
@RequestMapping("/Comment")
@CrossOrigin("*")
public class CommentController {
	@Autowired
	CommentService commentService;
	
	
	
	@PostMapping("/add/{idPost}")
	@ResponseBody
	public String addAndAffectComment(@RequestBody Commentaire comment,@PathVariable("idPost")Long idPost){
		return commentService.addAndAffectComment(comment, idPost);
	}
	
	@PutMapping("/update/{id}")
	@ResponseBody
	public Commentaire updateComment(@RequestBody @PathVariable("id")Long idComment) {
		return commentService.updateComment(idComment);
	}
	
	@GetMapping("/retrieve/{id}")
	@ResponseBody
	public Commentaire retrieveCommentById(@PathVariable("id")Long idComment){
		return commentService.retrieveCommentById(idComment);
	}
	
	@GetMapping("/retrieve")
	@ResponseBody
	public List<Commentaire> retrieveAllCommentaire(Commentaire comment){
		return commentService.retrieveAllCommentaire(comment);
	}
	
	@GetMapping("/retrieveByPost/{id}")
	@ResponseBody
	public List<Commentaire> retrieveCommentByPost(@PathVariable("id")Long idPost){
		return commentService.retrieveCommentByPost(idPost);
	}

	
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public void DeleteComment(@PathVariable("id")Long idComment) {
		commentService.deleteComment(idComment);
	}
	
}
