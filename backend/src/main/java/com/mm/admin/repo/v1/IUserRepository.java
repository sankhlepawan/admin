package com.mm.admin.repo.v1;

import com.mm.admin.model.v1.User;

public interface IUserRepository extends IGenericRepository<User>{
	
	public User findByWhatsappNumber(String number);
	
	public User enableUser(long userId, boolean enable);
	public User findByUsername(String username);
	
	
}
	