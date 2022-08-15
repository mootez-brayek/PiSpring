package Pi.Spring.Service;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Pi.Spring.Entity.Commentaire;
import Pi.Spring.Entity.Emojis;
import Pi.Spring.Entity.Post;
import Pi.Spring.Repositury.CommentRepository;
import Pi.Spring.Repositury.PostRepositury;


@Service
public class PostSeriveImpl implements PostService{

	
	@Autowired
	PostRepositury postRepo;
	@Autowired
	CommentRepository commentRepo;
	
	@Override
	public String addPost(Post post) {
		
		
		List<String> badwords=new ArrayList<>();
		badwords.add("bad");
		badwords.add("badwords");
		badwords.add("bads");
		String motPost[]=post.getContent().split(" ");
		String com ="";
		 
	for(String mots:motPost){

		
			if (badwords.contains(mots)){
			    mots="*****";
				com=com+" "+mots;
				post.setContent(com);
				post.setCreationDate(LocalDateTime.now());
				postRepo.save(post);
				return com;
			}
		else
			com=com+" "+mots;}
	 post.setContent(com);
	 post.setCreationDate(LocalDateTime.now());
	 postRepo.save(post);
	 postRepo.retrieveAllPosts(post);
	 
	 return com;
		
		
	}



	@Override
	public int nbrEmoji(Long idPost) {
		Post post=postRepo.findById(idPost).orElse(null);
		
		return post.getEmojis().size();
	}



	@Override
	public int nbrComment(Long idPost) {
		Post post=postRepo.findById(idPost).orElse(null);
		return post.getComments().size();
	}



	@Override
	public List<Commentaire> ListComment(Long idPost) {
		Post post=postRepo.findById(idPost).orElse(null);
		
		return post.getComments();
	}



	@Override
	public List<Emojis> ListEmojis(Long idPost) {
		Post post=postRepo.findById(idPost).orElse(null);
		return post.getEmojis();
	}



	@Override
	public Post updatePost(Long idPost) {
		Post post=postRepo.findById(idPost).orElse(null);
		post.setContent(post.getContent());
		post.setEtat(post.getEtat());
		post.setCreationDate(LocalDateTime.now());
		
		 return  postRepo.save(post) ;
		
	}



	@Override
	public void deletePost(Long idPost) {
		
		postRepo.deleteById(idPost);
		
		
	}



	@Override
	public List<Post> retrieveAllPosts(Post post) {
		
		return postRepo.retrieveAllPosts(post);
	}



	@Override
	public Post retrievePostById(Long idPost) {
		
		return postRepo.findById(idPost).orElse(null);
	}




















	}






