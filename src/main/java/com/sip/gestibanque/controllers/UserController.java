package com.sip.gestibanque.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import com.sip.gestibanque.entities.User;
import com.sip.gestibanque.repositories.UserRepository;



@Controller
@RequestMapping("/users")
public class UserController {
	
	
	@Autowired
	UserRepository userRepository;
	
	
	@GetMapping("/save")
	public String getFormAddUser(Model model)
	{
		
		User user = new User();
		model.addAttribute("user", user);
		return "user/addUser";
	}
	
	@PostMapping("/save")
	//@ResponseBody
	public String saveUser(User user)
	{
		userRepository.save(user);  
		
		return "redirect:list";
	}
	
	@RequestMapping("/list")
	//@ResponseBody
	public String getUsers(Model model)
	{
		List<User> users = (List<User>) userRepository.findAll();  
		model.addAttribute("users", users);
		
		return "user/listUser";
	}
	
	@GetMapping("/delete/{id}")
	//@ResponseBody
	public String deleteUser(@PathVariable("id") int id)
	{
		userRepository.deleteById(id);
		return "redirect:../list";
	}
	
	@GetMapping("/update/{id}")
	public String getFormUpdateUser(@PathVariable("id") int id, Model model)
	{
		Optional<User> opUser = userRepository.findById(id);
		User user = opUser.get(); 
		
		model.addAttribute("user", user);
		
		return "user/updateUser";
	}
	
	@PostMapping("/update")
	//@ResponseBody
	public String updateBanque(User user)
	{
		userRepository.save(user); 
		return "redirect:list";
	}
	

}
