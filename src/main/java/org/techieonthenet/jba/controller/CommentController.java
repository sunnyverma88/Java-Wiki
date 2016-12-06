package org.techieonthenet.jba.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.techieonthenet.jba.entity.Blog;
import org.techieonthenet.jba.entity.Comment;
import org.techieonthenet.jba.entity.User;
import org.techieonthenet.jba.service.BlogService;
import org.techieonthenet.jba.service.CommentService;
import org.techieonthenet.jba.service.UserService;

@Controller
public class CommentController {

	@Autowired
	private UserService us;
	
	@Autowired
	private BlogService bs;
	
	@Autowired
	private CommentService cs;
	
	@ModelAttribute
	public User constructUser()
	{
		return new User();
	}
	@ModelAttribute
	public Blog constructBlog()
	{
		return new Blog();
	}
	@ModelAttribute
	public Comment constructComment()
	{
		return new Comment();
	}
	
	
	
	@RequestMapping(value="/comment/blog/{id}",method=RequestMethod.POST)
	public String doAddComment(@Valid @ModelAttribute("comment")Comment comment,Principal principal,BindingResult result,Model model,RedirectAttributes rdr,@PathVariable("id") int blogId)
	{   
		if(result.hasErrors())
		{   
		    System.out.println("Isnide Error "+result.getAllErrors().toString());
			return "redirect:/blog/"+blogId;
			
		}
		String email=principal.getName();
		System.out.println("inside save comment");
		cs.save(comment, email, blogId);
		rdr.addFlashAttribute("message", "Thanks for submitting the Comment.");
		return "redirect:/blog/"+blogId; 
		
	}
}
