package com.mm.admin.service.v1.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mm.admin.dto.ResponseDto;
import com.mm.admin.dto.SearchQueryRequestDto;
import com.mm.admin.dto.SearchResponseDTO;
import com.mm.admin.model.v1.User;
import com.mm.admin.repo.v1.IUserRepository;
import com.mm.admin.service.v1.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserRepository repo;
	
	
	@Override
	public User save(User u) {
		return repo.save(u);
	}


	@Override
	public User findByWhatsappNumber(String number) {
		return repo.findByWhatsappNumber(number);
	}


	@Override
	public ResponseDto<User> findAll() {
		// return repo.findAll();
		return new ResponseDto<User>(repo.findAll(),0);
		
		
	}


	public SearchResponseDTO<User> search(SearchQueryRequestDto searchQuery) {
		return repo.search(searchQuery);
	}


	@Override
	public ResponseDto<User> enable(User user) {
		return new ResponseDto(Arrays.asList(repo.enableUser(user.getId(), user.isEnable())),1);
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

}
