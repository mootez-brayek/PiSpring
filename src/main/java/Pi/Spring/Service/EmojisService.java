package Pi.Spring.Service;

import Pi.Spring.Entity.Emojis;



public interface EmojisService {
public void updateEmojis(Long idEmojis);
public void addAndAffectEmojis(Emojis emojis, Long idPost);
}
