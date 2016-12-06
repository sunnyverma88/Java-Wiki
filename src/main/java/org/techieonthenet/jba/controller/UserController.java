package org.techieonthenet.jba.controller;

import java.lang.invoke.MethodType;
import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.techieonthenet.jba.entity.Blog;
import org.techieonthenet.jba.entity.ForgotPwd;
import org.techieonthenet.jba.entity.User;
import org.techieonthenet.jba.service.BlogService;
import org.techieonthenet.jba.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService us;
	
	@Autowired
	private BlogService bs;
	
	@ModelAttribute
	public void constructModelAttributes(Model model)
	{
		User user= new User();
		Blog blog=new Blog();
		ForgotPwd fp=new ForgotPwd();
		model.addAttribute("fp", fp);
		model.addAttribute("user",user);
		model.addAttribute("blog",blog);
	}
	
	
	
	
	@RequestMapping("/users")
	public String Users(Model model)
	{
		model.addAttribute("users",us.findAll());
		return "users";
	}
	@RequestMapping("/users/{id}/{pageNumber}")
	public String details(Model model,@PathVariable int id,@PathVariable Integer pageNumber)
	{   
		
		model.addAttribute("user",us.findOneWithBlogs(id));
		Page<Blog> userblogs=bs.getBlogsbyUser(us.findOneWithBlogs(id),pageNumber);
		int current = userblogs.getNumber() + 1;
	    int begin = Math.max(1, current - 5);
	    int end = Math.min(begin + 10, userblogs.getTotalPages());
	    model.addAttribute("beginIndex", begin);
	    model.addAttribute("endIndex", end);
	    model.addAttribute("currentIndex", current);
		model.addAttribute("blogs",userblogs);
		return "account";
		
		
	}
	
	@RequestMapping("/register")
	public String showRegister()
	{
		return "user-register";
	}
	
	@RequestMapping("/user/update/{id}")
	public String showUpdate(Model model,@PathVariable("id") int id)
	{
		User user= us.findOne(id);
		model.addAttribute("user", user);
		return "editUser";
	}
	
	@RequestMapping(value="/register" , method=RequestMethod.POST)
	public String doRegister(@Valid @ModelAttribute("user")User user,BindingResult result)
	{   
		boolean response;
		
			if(result.hasErrors())
			{  
				return "user-register";
				
			}
			us.save(user);
			response=true;
		    return "redirect:/register?success="+response;
	}
		
	
	@RequestMapping(value="/users/remove/{id}")
	public String removeUser(Model model,@PathVariable("id") int id)
	{   
		us.delete(id);
		return "redirect:/users";
	}
	
	@RequestMapping(value="/user/forgotpwd")
	public String forgotPwd()
	{   
		return "forgotPwd";
	}
	
	@RequestMapping(value="/user/regeneratePwd")
	public String regeneratePwd( @ModelAttribute("fp")ForgotPwd fp,@RequestParam("email")String email)
	{   
		System.out.println(fp.getEmail());
		return "forgotPwd";
	}
	
	
}
