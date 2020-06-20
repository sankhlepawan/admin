package com.mm.admin.service.v1;

import org.springframework.web.multipart.MultipartFile;

import com.mm.admin.dto.SearchQueryRequestDto;
import com.mm.admin.dto.SearchResponseDTO;
import com.mm.admin.model.v1.Bio;
import com.mm.admin.model.v1.FileUpload;

public interface IBioService{
  
	public Bio save(Bio b);
	
	public SearchResponseDTO<Bio> search(SearchQueryRequestDto body);
	
	public FileUpload uploadUserProfile(MultipartFile file, long userId);

}
