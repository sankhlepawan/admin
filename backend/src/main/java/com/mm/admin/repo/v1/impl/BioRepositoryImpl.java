package com.mm.admin.repo.v1.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.mm.admin.dto.SearchQueryRequestDto;
import com.mm.admin.dto.SearchResponseDTO;
import com.mm.admin.model.v1.Bio;
import com.mm.admin.repo.v1.IBioRepository;

@Repository
@Transactional
public class BioRepositoryImpl extends GenericRepositoryImpl<Bio> implements IBioRepository {

	@Override
	public SearchResponseDTO<Bio> search(SearchQueryRequestDto searchQuery) {
		return super.search(searchQuery);
	}

	@Override
	public void delete(Object id) {
		super.delete(id);

	}

	@Override
	public Bio find(Object o) {
		return super.find(o);
	}

	@Override
	public Bio update(Bio t) {
		return super.update(t);
	}

	@Override
	public Bio save(Bio t) {
		return super.save(t);
	}

	@Override
	public long count() {
		return super.count();
	}

	@Override
	public List<Bio> findAll() {
		return super.findAll();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Bio findByBioId(long bioId) {
		return (Bio) getEntityManager().createNamedQuery("findByBioId")
				.setParameter("bioId", bioId).getSingleResult();
		
	}

	

}
