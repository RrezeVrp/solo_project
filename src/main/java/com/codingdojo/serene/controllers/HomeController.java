package com.codingdojo.serene.controllers;

import javax.servlet.http.HttpSession;  
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.serene.models.LoginUser;
import com.codingdojo.serene.models.Post;
import com.codingdojo.serene.models.User;
import com.codingdojo.serene.services.PostService;
import com.codingdojo.serene.services.UserService;

@Controller
public class HomeController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private PostService postService;
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("/register")
	public String register(@ModelAttribute("newUser") User newUser) {
		return "register.jsp";
	}
	@RequestMapping("/login")
	public String login(@ModelAttribute("newLogin") User newLogin) {
		return "login.jsp";
	}
	
	@PostMapping("/register/new")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result,HttpSession session, Model model) {
		User user =userService.register(newUser,result);
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "register.jsp";
		}else {
			
			session.setAttribute("userId", user.getId());
			return "redirect:/home";
		}
	}
	
	@PostMapping("/login/new")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin,BindingResult result,HttpSession session,Model model) {
		User user = userService.login(newLogin, result);
		 
	    if(result.hasErrors() || user==null) {
	        model.addAttribute("newUser", new User());
	        return "login.jsp";
	    }
	     
	    session.setAttribute("userId", user.getId());
	 
	    return "redirect:/home";
	}
	
	@RequestMapping("/home")
	public String main(HttpSession session, Model model) {
	 
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("user", userService.findById(userId));
		model.addAttribute("posts", postService.all());
		
	    return "home.jsp";
	    
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("userId", null);
	     
	    return "redirect:/";
	}
	@RequestMapping("/post/new")
	public String newName(@ModelAttribute("post") Post post, Model model, HttpSession session ) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		User user = userService.findById((Long)session.getAttribute("userId"));
		model.addAttribute("user", user);
		return "new.jsp";
	}
	@PostMapping("/post/news")
	public String addPost(@Valid @ModelAttribute("post") Post post, BindingResult result,Model model) {
		if (result.hasErrors()) {
    		return "new.jsp";
    	}
    	
		postService.create(post);
    	
    	return "redirect:/home";
	}
	@RequestMapping("/post/{id}")
    public String showDetails(Model model, @PathVariable("id") Long id, HttpSession session) {
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
    	
    	Post post = postService.findById(id);
    	model.addAttribute("post", post);
    	model.addAttribute("user", userService.findById((Long)session.getAttribute("userId")));
    	
    	return "details.jsp";
    }
	@RequestMapping("/post/{id}/edit")
    public String editPost(@ModelAttribute("post") Post post,Model model, @PathVariable("id") Long id, HttpSession session) {
    	
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
    	
    	Post p = postService.findById(id);
    	model.addAttribute("post", p);
    	
    	return "edit.jsp";
    }
	@PostMapping("/post/{id}")
    public String updatePost(@Valid @ModelAttribute("post") Post post, BindingResult result, Model model) {
    	
    	if (result.hasErrors()) {
    		return "edit.jsp";
    	}
    	

        postService.update(post);
        
    	
    	return "redirect:/home";
    }
	@RequestMapping("/post/{id}/delete")
	 public String delete(@PathVariable("id") Long id) {
		 postService.delete(postService.findById(id));
		 return "redirect:/home";
		 
	 }
	@RequestMapping("/about")
	public String about(HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		return "about.jsp";
	}
	@RequestMapping("/team")
	public String team(HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		return "team.jsp";
	}
	
}
