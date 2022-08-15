package Pi.Spring.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Pi.Spring.Entity.Emojis;
import Pi.Spring.Entity.Post;
import Pi.Spring.Repositury.EmojisRepositury;
import Pi.Spring.Repositury.PostRepositury;

@Service
public class EmojisServiceImpl implements EmojisService{
	@Autowired
	PostRepositury postRepo;
	
	@Autowired 
	EmojisRepositury emojiRepo;
	
	@Transactional
	@Override
	public void addAndAffectEmojis(Emojis emojis, Long idPost) {
		Post post= postRepo.findById(idPost).orElse(null);
		post.setLikes(post.getLikes() + 1); 
		emojis.setEmojisPosts(post);
		 emojiRepo.save(emojis);
		
	}

	@Override
	public void updateEmojis(Long idEmojis) {
	Emojis emojis=emojiRepo.findById(idEmojis).orElse(null);
		
		emojiRepo.save(emojis);
		
	}

}
