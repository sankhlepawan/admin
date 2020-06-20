package com.mm.admin.repo.v1;

import java.util.List;

import com.mm.admin.model.v1.FileUpload;

public interface IFileUploadRepository extends IGenericRepository<FileUpload>{

	List<FileUpload> findByFileName(String name);

}
