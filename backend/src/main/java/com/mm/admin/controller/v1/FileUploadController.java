package com.mm.admin.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mm.admin.model.v1.FileUpload;
import com.mm.admin.service.v1.IFileUploadService;

@RestController
@RequestMapping(value = { "/v1/file" }, consumes = {"text/plain;charset=UTF-8","application/json","multipart/form-data"})
@CrossOrigin("*")
public class FileUploadController {
	
	@Autowired
	IFileUploadService service;

	@PostMapping(value="/upload")
	public FileUpload upload(@RequestParam("file") MultipartFile file){
		 return service.upload(file);
	}
	
	
	
	
	
	
}
