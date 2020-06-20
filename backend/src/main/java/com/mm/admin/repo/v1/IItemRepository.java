package com.mm.admin.repo.v1;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mm.admin.model.v1.Item;

@Repository
public interface IItemRepository extends IGenericRepository<Item>{

	List<String> findDistinctItemByAvailable(boolean available);

	List<Item> findBySubCategoriesAndAvailableAndQwt(String subCategoryName, boolean available, int qwt);

}
