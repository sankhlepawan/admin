package com.mm.admin.repo.v1.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mm.admin.dto.SearchQueryRequestDto;
import com.mm.admin.dto.SearchResponseDTO;
import com.mm.admin.model.v1.Role;
import com.mm.admin.repo.v1.IRoleRepository;

@Repository
public class RoleRepositoryImpl extends GenericRepositoryImpl<Role> implements IRoleRepository{

	@Override
	public SearchResponseDTO<Role> search(SearchQueryRequestDto searchQuery) {
		return super.search(searchQuery);
	}

	@Override
	public void delete(Object id) {
		super.delete(id);

	}

	@Override
	public Role find(Object o) {
		return super.find(o);
	}

	@Override
	public Role update(Role t) {
		return super.update(t);
	}

	@Override
	public Role save(Role t) {
		return super.save(t);
	}

	@Override
	public long count() {
		return super.count();
	}

	@Override
	public List<Role> findAll() {
		return super.findAll();
	}


}
