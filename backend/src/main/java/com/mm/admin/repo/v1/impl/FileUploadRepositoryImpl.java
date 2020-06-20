package com.mm.admin.repo.v1.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.mm.admin.dto.SearchQueryRequestDto;
import com.mm.admin.dto.SearchResponseDTO;
import com.mm.admin.model.v1.FileUpload;
import com.mm.admin.repo.v1.IFileUploadRepository;

@Repository
@Transactional
public class FileUploadRepositoryImpl extends GenericRepositoryImpl<FileUpload> implements IFileUploadRepository {

	@Override
	public SearchResponseDTO<FileUpload> search(SearchQueryRequestDto searchQuery) {
		return super.search(searchQuery);
	}

	@Override
	public void delete(Object id) {
		super.delete(id);

	}

	@Override
	public FileUpload find(Object o) {
		return super.find(o);
	}

	@Override
	public FileUpload update(FileUpload t) {
		return super.update(t);
	}

	@Override
	public FileUpload save(FileUpload t) {
		return super.save(t);
	}

	@Override
	public long count() {
		return super.count();
	}

	@Override
	public List<FileUpload> findAll() {
		return super.findAll();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FileUpload> findByFileName(String name) {
		return getEntityManager().createNamedQuery("findByFileName")
				.setParameter("name", name).getResultList();
	}
	


}
