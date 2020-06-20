package com.mm.admin.service.v1;

import com.mm.admin.dto.SearchQueryRequestDto;
import com.mm.admin.dto.SearchResponseDTO;
import com.mm.admin.model.v1.Role;

public interface IRoleService {

	public Role save(Role role);

	public Iterable<Role> findAll();
	
	public SearchResponseDTO<Role> search(SearchQueryRequestDto body);
}

