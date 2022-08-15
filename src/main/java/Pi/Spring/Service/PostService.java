package Pi.Spring.Service;



import java.io.IOException;
import java.util.List;



import Pi.Spring.Entity.Commentaire;
import Pi.Spring.Entity.Emojis;
import Pi.Spring.Entity.Post;

public interface PostService {
public String addPost(Post post);
public Post updatePost(Long idPost);
public void deletePost(Long idPost);
public List<Post> retrieveAllPosts(Post post);
public Post retrievePostById(Long idPost);


public int nbrEmoji(Long idPost);
public int nbrComment(Long idPost);
public List<Commentaire> ListComment(Long idPost);
public List<Emojis> ListEmojis(Long idPost);





}
