package Pi.Spring.Controller;


import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import org.apache.commons.io.FileUtils;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Pi.Spring.Entity.Commentaire;
import Pi.Spring.Entity.Emojis;
import Pi.Spring.Entity.Post;
import Pi.Spring.Service.PostService;
import Pi.Spring.response.Com;



@RestController
@RequestMapping("/Post")
@CrossOrigin("*")
public class PostController {
	@Autowired
	PostService postServ;
	@Autowired
	ServletContext context;
	
	@RequestMapping("/add")
	@ResponseBody
	public Com addPost(@RequestParam("file") MultipartFile file,@RequestParam("body") String post) throws JsonParseException , JsonMappingException , Exception {
		Post LL = new ObjectMapper().readValue(post, Post.class);

		boolean isExit = new File(context.getRealPath("/Images/")).exists();
        if (!isExit)
        {
        	new File (context.getRealPath("/Images/")).mkdir();
        	System.out.println("mk dir.............");
        }
        String filename = file.getOriginalFilename();
        String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
        File serverFile = new File (context.getRealPath("/Images/"+File.separator+newFileName));
        System.out.println(context.getContextPath());
        try
        {
        	System.out.println("Image");
        	 FileUtils.writeByteArrayToFile(serverFile,file.getBytes());
        	 
        }catch(Exception e) {
        	e.printStackTrace();
        }
		
		
        LL.setPicture(newFileName);
		
		return new Com(postServ.addPost(LL));
	}
	 @GetMapping("/Imgarticles/{id}")
	 public byte[] getPhoto(@PathVariable("id") Long idPost) throws Exception{
		 
		 Post p   =postServ.retrievePostById(idPost);
		 return Files.readAllBytes(Paths.get(context.getRealPath("/Images/")+p.getPicture()));
	 }
		
		@GetMapping("/CountEmojis/{id}")
		@ResponseBody
		public int nbrEmoji(@PathVariable("id") Long idPost){
			return postServ.nbrEmoji(idPost);
		}
		
		
		@GetMapping("/CountComments/{id}")
		@ResponseBody
		
		public int nbrComment(@PathVariable("id") Long idPost){
			return postServ.nbrComment(idPost);
		}
		
		
		@GetMapping("/Comments/{id}")
		@ResponseBody
		public List<Commentaire> ListComment(@PathVariable("id")Long idPost){
			return postServ.ListComment(idPost);
		}
		
		
		@GetMapping("/Emojis/{id}")
		@ResponseBody
		public List<Emojis> ListEmojis(@PathVariable("id")Long idPost){
			return postServ.ListEmojis(idPost);
		}
		
		
		@PutMapping("/update/{id}")
		@ResponseBody
		public Post updatePost(@RequestBody @PathVariable("id")Long idPost) {
			return postServ.updatePost(idPost);
		}
		
		@DeleteMapping("/delete/{id}")
		@ResponseBody
		public void deletePost(@PathVariable("id")Long idPost) {
			 postServ.deletePost(idPost);
		}
		
		@GetMapping("/retrieve")
		@ResponseBody
		public List<Post> retrieveAllPosts(Post post){
			return postServ.retrieveAllPosts(post);
		}
		
		@GetMapping("/retrieve/{id}")
		@ResponseBody
		public Post retrievePostById(@PathVariable("id")Long idPost){
			return postServ.retrievePostById(idPost);
		}
	
		
	

}

