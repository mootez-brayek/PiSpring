package Pi.Spring.response;

import java.util.List;

import Pi.Spring.Entity.Commentaire;
import Pi.Spring.Entity.Etat;

public class PostResponse {

	private Long idPost;

	
	private Etat etat;
	
	private String picture;
	
	private String content;

	private int likes;
	
	private int commenters;
	
	private List<Commentaire> coms;

	public Long getIdPost() {
		return idPost;
	}

	public void setIdPost(Long idPost) {
		this.idPost = idPost;
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getCommenters() {
		return commenters;
	}

	public void setCommenters(int commenters) {
		this.commenters = commenters;
	}

	public List<Commentaire> getComs() {
		return coms;
	}

	public void setComs(List<Commentaire> coms) {
		this.coms = coms;
	}

	public PostResponse(Long idPost, Etat etat, String picture, String content, int likes, int commenters,
			List<Commentaire> coms) {
		super();
		this.idPost = idPost;
		this.etat = etat;
		this.picture = picture;
		this.content = content;
		this.likes = likes;
		this.commenters = commenters;
		this.coms = coms;
	}

	public PostResponse() {
		super();
	}
	
	

}
