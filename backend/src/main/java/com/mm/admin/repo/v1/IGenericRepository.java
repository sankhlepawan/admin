/*
 * @Author: Pawan Sankhle
 * @Date: 09-10-2019
*/

package com.mm.admin.repo.v1;

import java.util.List;

import com.mm.admin.dto.SearchQueryRequestDto;
import com.mm.admin.dto.SearchResponseDTO;

public interface IGenericRepository<T>{
	
	SearchResponseDTO<T> search(SearchQueryRequestDto searchQuery);

	void delete(Object id);

	T find(Object id);

	T update(T t);

	T save(T t);

	long count();

	List<T> findAll();
}
