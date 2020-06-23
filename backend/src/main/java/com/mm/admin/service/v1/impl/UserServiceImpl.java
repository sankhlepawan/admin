package com.mm.admin.service.v1.impl;

import java.util.Arrays;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mm.admin.dto.ResponseDto;
import com.mm.admin.dto.SearchQueryRequestDto;
import com.mm.admin.dto.SearchResponseDTO;
import com.mm.admin.dto.UserProfileDTO;
import com.mm.admin.model.v1.User;
import com.mm.admin.repo.v1.IUserRepository;
import com.mm.admin.security.JwtTokenUtil;
import com.mm.admin.service.v1.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserRepository repo;
	
	
	@Autowired
	ResponseDto resDto;
	
	@Autowired
	DozerBeanMapper beanMapper;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Override
	public User save(User u) {
		u.setUsername(u.getFirstName().toLowerCase());
		u = setDefaultPassword(u);
		return repo.save(u);
	}


	private User setDefaultPassword(User u) {
		u.setPassword(bCryptPasswordEncoder.encode("P@wan#1991"));
		return u;
	}


	@Override
	public User findByWhatsappNumber(String number) {
		return repo.findByWhatsappNumber(number);
	}


	@Override
	public ResponseDto findAll() {
		resDto.data(Arrays.asList(repo.findAll()));
		resDto.count(1);
		return resDto.build();
		
		
	}


	public SearchResponseDTO<User> search(SearchQueryRequestDto searchQuery) {
		return repo.search(searchQuery);
	}


	@Override
	public ResponseDto enable(User user) {
		resDto.data(Arrays.asList(repo.enableUser(user.getId(), user.isEnable())));
		resDto.count(1);
		return resDto.build();
	}


	@Override
	public boolean delete(User user) {
		try {
			if(user.getId() != null) {
				repo.delete(user.getId());
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}


	@Override
	public User getUserByUsername(String username) {
		return repo.findByUsername(username);
	}


	@Override
	public UserProfileDTO getUserProfile(String token) {
		String username = jwtTokenUtil.getUsernameFromToken(token);
		User u = getUserByUsername(username);
		UserProfileDTO user = new UserProfileDTO();
		beanMapper.map(u, user);
		return user;
		
	}
}
