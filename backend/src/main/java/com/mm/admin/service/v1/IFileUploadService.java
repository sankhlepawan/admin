package com.mm.admin.service.v1;


import org.springframework.web.multipart.MultipartFile;

import com.mm.admin.model.v1.FileUpload;

public interface IFileUploadService {

	public FileUpload upload(MultipartFile file);

	
}
