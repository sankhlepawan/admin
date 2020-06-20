package com.mm.admin.repo.v1.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.mm.admin.dto.SearchQueryRequestDto;
import com.mm.admin.dto.SearchResponseDTO;
import com.mm.admin.model.v1.MilkCollection;
import com.mm.admin.repo.v1.IMilkCollectionRepository;


@Repository
@Transactional
public class MilkCollectionRepositoryImpl extends GenericRepositoryImpl<MilkCollection> implements IMilkCollectionRepository{

	@Override
	public SearchResponseDTO<MilkCollection> search(SearchQueryRequestDto searchQuery) {
		return super.search(searchQuery);
	}

	@Override
	public void delete(Object id) {
		super.delete(id);

	}

	@Override
	public MilkCollection find(Object o) {
		return super.find(o);
	}

	@Override
	public MilkCollection update(MilkCollection t) {
		return super.update(t);
	}

	@Override
	public MilkCollection save(MilkCollection t) {
		return super.save(t);
	}

	@Override
	public long count() {
		return super.count();
	}

	@Override
	public List<MilkCollection> findAll() {
		return super.findAll();
	}

}
