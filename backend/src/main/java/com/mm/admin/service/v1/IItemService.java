package com.mm.admin.service.v1;

import com.mm.admin.dto.ResponseDto;
import com.mm.admin.dto.SearchQueryRequestDto;
import com.mm.admin.dto.SearchResponseDTO;
import com.mm.admin.model.v1.Item;

public interface IItemService {

	public double calculatePriceByQwt(int qwt, String name);
	public Item create(Item item);
	public ResponseDto<Item> findAll();
	SearchResponseDTO<Item> search(SearchQueryRequestDto searchQuery);
	
}
