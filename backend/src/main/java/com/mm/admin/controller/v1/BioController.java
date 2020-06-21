package com.mm.admin.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mm.admin.dto.SearchQueryRequestDto;
import com.mm.admin.dto.SearchResponseDTO;
import com.mm.admin.model.v1.Bio;
import com.mm.admin.model.v1.FileUpload;
import com.mm.admin.service.v1.IBioService;

@RestController
@RequestMapping(value = { "/v1/bio" }, consumes = {"text/plain;charset=UTF-8","application/json"})
@CrossOrigin("*")
public class BioController {
	
	@Autowired
	IBioService service;

	@PostMapping(value="/create")
	public Bio findById(@RequestBody Bio bio){
		return service.save(bio);
	}
	
	@PostMapping(value="/search")
	public SearchResponseDTO<Bio> search(@RequestBody SearchQueryRequestDto body){
		return service.search(body);
	}
	
	@PostMapping(value="/update")
	public Bio update(@RequestBody Bio bio){
		return service.update(bio);
	}
	
	@PostMapping(value="/uploadProfilePic/{bioId}",consumes = {"multipart/form-data"})
	public FileUpload uploadProfilePice(@RequestParam("file") MultipartFile file, @PathVariable("bioId") long bioId){
		 return service.uploadUserProfile(file, bioId);
	}
	
	
}
