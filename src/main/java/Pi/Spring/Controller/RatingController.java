package Pi.Spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import Pi.Spring.Entity.RatingPost;
import Pi.Spring.Service.RatingService;

@RestController
@RequestMapping("/Rating")
public class RatingController {
	@Autowired
	RatingService rateService;
	
	
	@PostMapping("/add/{id}")
	@ResponseBody
	public String rate(@RequestBody RatingPost rate,@PathVariable ("id")Long idPost) {
		return rateService.rate(rate, idPost);
	}
	
	@GetMapping("/CountRate/{id}")
	@ResponseBody
	public float rateTotale(RatingPost rating,@PathVariable("id")Long idPost){
	
		return rateService.rateTotale(idPost);
	}

}
