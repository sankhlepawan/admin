package com.mm.admin.repo.v1;

import com.mm.admin.model.v1.Bio;

public interface IBioRepository extends IGenericRepository<Bio>{
	
	public Bio findByBioId(long bioId);
	
	
}
	