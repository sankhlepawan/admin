package com.mm.admin.service.v1.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mm.admin.dto.SearchQueryRequestDto;
import com.mm.admin.dto.SearchResponseDTO;
import com.mm.admin.model.v1.Role;
import com.mm.admin.model.v1.User;
import com.mm.admin.repo.v1.IRoleRepository;
import com.mm.admin.service.v1.IRoleService;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class RoleServiceImpl implements IRoleService {

	@Autowired
	IRoleRepository repo;
	
	@Override
	public Role save(Role role) {
		log.info("inside @roleService @save method entry..");
		return repo.save(role);
	}

	@Override
	public Iterable<Role> findAll() {
		return repo.findAll();
	}

	@Override
	public SearchResponseDTO<Role> search(SearchQueryRequestDto body) {
		return repo.search(body);
	}

	
}
