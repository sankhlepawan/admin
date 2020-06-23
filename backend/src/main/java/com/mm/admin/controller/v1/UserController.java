package com.mm.admin.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mm.admin.dto.ResponseDto;
import com.mm.admin.dto.SearchQueryRequestDto;
import com.mm.admin.dto.SearchResponseDTO;
import com.mm.admin.dto.UserProfileDTO;
import com.mm.admin.model.v1.User;
import com.mm.admin.service.v1.IUserService;

@RestController
@RequestMapping(value = { "/v1/user" }, consumes = {"text/plain;charset=UTF-8","application/json"})
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	IUserService service;

	@PostMapping(value="/create")
	public User findById(@RequestBody User user){
		return service.save(user);
	}
	
	@GetMapping(value="/findAll")
	public ResponseDto findById(){
		return service.findAll() ;
	}
	
	@PostMapping(value="/enable")
	public ResponseDto enable(@RequestBody User user){
		return service.enable(user) ;
	}
	
	@PostMapping(value="/delete")
	public boolean delete(@RequestBody User user){
		return service.delete(user);
	}
	
	@PostMapping(value="/search")
	public SearchResponseDTO<User> search(@RequestBody SearchQueryRequestDto body){
		return service.search(body);
	}
	
	@PostMapping(value="/profile")
	public UserProfileDTO profile(@RequestHeader (value = "Authorization", required = true) String token) {
		return service.getUserProfile(token);
		
	}
	
	
}
