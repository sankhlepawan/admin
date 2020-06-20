package com.mm.admin.service.v1.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mm.admin.dto.SearchQueryRequestDto;
import com.mm.admin.dto.SearchResponseDTO;
import com.mm.admin.model.v1.CollectionStatusType;
import com.mm.admin.model.v1.MilkCollection;
import com.mm.admin.repo.v1.IMilkCollectionRepository;
import com.mm.admin.service.v1.IMilkCollectionService;

@Service
public class MilkCollectionServiceImpl implements IMilkCollectionService {

	
	@Autowired
	IMilkCollectionRepository repo;
	
	
	@Override
	public MilkCollection create(MilkCollection item) {
		item.setStatus(CollectionStatusType.ACCEPTED);
		item.setCreatedOn(new Date());
		return repo.save(item);
	}

	@Override
	public SearchResponseDTO<MilkCollection> search(SearchQueryRequestDto searchQuery) {
		return repo.search(searchQuery);
	}

}
