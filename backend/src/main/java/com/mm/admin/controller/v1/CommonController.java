/*
 * package com.mm.admin.controller.v1;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.web.bind.annotation.CrossOrigin; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.mm.admin.dto.ResponseDto; import com.mm.admin.model.v1.Category;
 * import com.mm.admin.model.v1.SubCategory; import
 * com.mm.admin.service.v1.ICategoryService; import
 * com.mm.admin.service.v1.ISubCategoryService;
 * 
 * @RestController
 * 
 * @RequestMapping(value = { "/v1/common" })
 * 
 * @CrossOrigin("*") public class CommonController {
 * 
 * @Autowired ISubCategoryService subCategorySrv;
 * 
 * @Autowired ICategoryService categoryService;
 * 
 * @GetMapping(value="/findAllSubCategory") public ResponseDto<SubCategory>
 * findAllSubCategory(){ return new
 * ResponseDto<SubCategory>(subCategorySrv.findAll(), 200); }
 * 
 * @GetMapping(value="/findAllCategory") public ResponseDto<Category>
 * findAllCategory(){ return new
 * ResponseDto<Category>(categoryService.findAll(), 200); } }
 */