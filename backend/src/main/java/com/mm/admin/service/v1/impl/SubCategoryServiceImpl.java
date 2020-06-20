package com.mm.admin.service.v1.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mm.admin.model.v1.SubCategory;
import com.mm.admin.repo.v1.ISubCategoryRepository;
import com.mm.admin.service.v1.ISubCategoryService;

@Service
public class SubCategoryServiceImpl implements ISubCategoryService {

	@Autowired
	ISubCategoryRepository repo;

	@Override
	public Iterable<SubCategory> findAll() {
		return repo.findAll();
	}
	
}
