package com.sip.gestibanque.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.sip.gestibanque.entities.User;
import com.sip.gestibanque.repositories.UserRepository;
import com.sip.gestibanque.services.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserService userService;

	@GetMapping("/save")
	public String getFormAddUser(Model model) {
		User user = new User();
		model.addAttribute("user", user);

		return "user/addUser";
	}

	@PostMapping("/save")
	public String saveUser(User user) {
//		userRepository.save(user);
		this.userService.saveUser(user);

		return "redirect:list";
	}

	@RequestMapping("/list")
	public String getUsers(Model model) {
		List<User> users = (List<User>) userRepository.findAll();
		model.addAttribute("users", users);

		return "user/listUser";
	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		userRepository.deleteById(id);

		return "redirect:../list";
	}

	@GetMapping("/update/{id}")
	public String getFormUpdateUser(@PathVariable("id") int id, Model model) {
		Optional<User> opUser = userRepository.findById(id);
		User user = opUser.get();
		model.addAttribute("user", user);

		return "user/updateUser";
	}

	@PostMapping("/update")
	// @ResponseBody
	public String updateBanque(User user) {
		userRepository.save(user);

		return "redirect:list";
	}

	@PostMapping("/search")
	public String getFormSearchUser(Model model,
			@RequestParam(value = "inputname", required = false) String inputname) {

		List<User> users = userRepository.findByNomOrPrenom(inputname, inputname);
		model.addAttribute("users", users);

		return "user/listUser";
//		return "redirect:list";
	}

}
