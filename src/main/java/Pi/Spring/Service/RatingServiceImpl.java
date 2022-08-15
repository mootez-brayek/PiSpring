package Pi.Spring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Pi.Spring.Entity.Post;
import Pi.Spring.Entity.RatingPost;
import Pi.Spring.Repositury.PostRepositury;
import Pi.Spring.Repositury.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	RatingRepository rateRepo;
	@Autowired
	PostRepositury postRepo;
	
	@Override
	public String rate(RatingPost rate,Long idPost) {
		Post post= postRepo.findById(idPost).orElse(null);
		if(rate.getRate()<=10.0){
		rate.setRatePost(post);
		rateRepo.save(rate);
		return "rate accepted";}
		return "rate over 10";
		
		
		
		
	}

	@Override
	public float rateTotale(Long idPost) {
		Post post=postRepo.findById(idPost).orElse(null);
		
		return rateRepo.rateTotale(idPost);
	}

}
