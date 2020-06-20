package com.mm.admin.service.v1.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mm.admin.model.v1.Category;
import com.mm.admin.repo.v1.ICategoryRepository;
import com.mm.admin.service.v1.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	ICategoryRepository repo;
	
	@Override
	public Iterable<Category> findAll() {
		return repo.findAll();
	}

}
