package com.mm.admin.service.v1.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mm.admin.dto.SearchQueryRequestDto;
import com.mm.admin.dto.SearchResponseDTO;
import com.mm.admin.excpetion.NotFoundException;
import com.mm.admin.model.v1.Bio;
import com.mm.admin.model.v1.FileUpload;
import com.mm.admin.repo.v1.IBioRepository;
import com.mm.admin.service.v1.IBioService;
import com.mm.admin.service.v1.IFileUploadService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BioServiceImpl implements IBioService {

	@Autowired
	IBioRepository repo;
	
	@Autowired
	IFileUploadService fileService;
	
	@Autowired
	DozerBeanMapper mapper;
	
	@Override
	public Bio save(Bio u) {
		u.setCreatedOn(new Date());
		u.setUpdatedOn(new Date());
		return repo.save(u);
	}
	
	


	public SearchResponseDTO<Bio> search(SearchQueryRequestDto searchQuery) {
		return repo.search(searchQuery);
	}


	@Override
	public FileUpload uploadUserProfile(MultipartFile file, long bioId) {
		log.info("inside @class BioServiceimpl @method uploadUserProfile @param bioId=> {}", bioId);
		Bio bio =  repo.findByBioId(bioId);
		FileUpload uploadedFile = null;
		
		if(bio != null) {
			try {
				uploadedFile = fileService.upload(file);
				List<FileUpload> files = bio.getFiles();
				
				if(files != null && !files.isEmpty()) {
					files.add(uploadedFile);
				} else {
					files = new ArrayList<>();
					files.add(uploadedFile);
				}
				bio.setProfilePic(uploadedFile.getPath());
				repo.update(bio);
			}catch (Exception e) {
				log.error("Error inside inside @class BioServiceimpl @method uploadUserProfile => {}", e.getLocalizedMessage());
			}
		}else {
			throw new NotFoundException("Bio not found with id " + bioId);
		}
		return uploadedFile;
	}




	@Override
	public Bio update(Bio bio) {
		if(bio != null && bio.getId() != 0) {
		Bio ob =  repo.findByBioId(bio.getId());
		bio.setProfilePic(ob.getProfilePic());
		bio.setUpdatedOn(new Date());
		mapper.map(bio,ob);
		return repo.save(ob);
		}else {
		  throw new NotFoundException("Bio not found");
		}
	}

}
