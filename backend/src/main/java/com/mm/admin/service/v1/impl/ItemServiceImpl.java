package com.mm.admin.service.v1.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mm.admin.dto.ResponseDto;
import com.mm.admin.dto.SearchQueryRequestDto;
import com.mm.admin.dto.SearchResponseDTO;
import com.mm.admin.model.v1.Item;
import com.mm.admin.repo.v1.IItemRepository;
import com.mm.admin.service.v1.IItemService;
import com.mm.admin.utils.Utils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ItemServiceImpl implements IItemService{

	@Autowired
	IItemRepository repo;
	
	@Autowired
	ResponseDto resDto;
	
	@Override
	public double calculatePriceByQwt(int qwt, String name) {
		List<Item> item = repo.findBySubCategoriesAndAvailableAndQwt(name, true, 0);
		if(qwt > 0) {
			return Utils.calculateItemTotal(qwt, item.get(0).getPrice());
		}
		return 0;
	}

	@Override
	public Item create(Item item) {
		return repo.save(item);
	}

	@Override
	public ResponseDto findAll() {
		resDto.data(repo.findAll());
		resDto.count( repo.count());
		return resDto.build();
		
	}
	
	@Override
	public SearchResponseDTO<Item> search(SearchQueryRequestDto searchQuery) {
		return repo.search(searchQuery);
	}

}
