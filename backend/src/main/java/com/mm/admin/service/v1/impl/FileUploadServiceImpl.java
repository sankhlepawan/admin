package com.mm.admin.service.v1.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.mm.admin.excpetion.FileStorageException;
import com.mm.admin.model.v1.FileUpload;
import com.mm.admin.repo.v1.IFileUploadRepository;
import com.mm.admin.service.v1.IFileUploadService;

@Service
public class FileUploadServiceImpl implements IFileUploadService{

	@Autowired
	IFileUploadRepository repo;
	
	private final Path fileStorageLocation;
	

	private String uploadDirPath;
	

    @Autowired
    public FileUploadServiceImpl(@Value("${file.upload-dir}") String uploadDirPath) {
    	this.uploadDirPath = uploadDirPath;
        this.fileStorageLocation = Paths.get(uploadDirPath)
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }
	
	@Override
	public FileUpload upload(MultipartFile file) {
		
		// Normalize file name
		
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
        String newName = Long.toUnsignedString(fileName.hashCode()) + "." + extension;
        FileUpload fileupload = new FileUpload();
        fileupload.setFileType(file.getContentType());
        fileupload.setName(newName);
        
        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(newName);
            fileupload.setPath("public/" + targetLocation.getFileName());
            fileupload.setSize(file.getSize());
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            
            List<FileUpload> oldFile = repo.findByFileName(newName);
            if(oldFile == null || oldFile.size() == 0) {
            	 return repo.save(fileupload);
            }
            return oldFile.get(0);
        
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
       
		
	}
}
