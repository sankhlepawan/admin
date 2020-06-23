package com.mm.admin.service.v1;

import com.mm.admin.dto.ResponseDto;
import com.mm.admin.dto.SearchQueryRequestDto;
import com.mm.admin.dto.SearchResponseDTO;
import com.mm.admin.model.v1.User;

public interface IUserService{
  
	public User save(User u);
	
	public User findByWhatsappNumber(String whtsappNumber);

	public ResponseDto<User> findAll();

	public SearchResponseDTO<User> search(SearchQueryRequestDto body);

	public boolean delete(User user);

	public ResponseDto<User> enable(User user);

	public User getUserByUsername(String username);
}
