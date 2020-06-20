package com.mm.admin.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mm.admin.dto.SearchQueryRequestDto;
import com.mm.admin.dto.SearchResponseDTO;
import com.mm.admin.model.v1.MilkCollection;
import com.mm.admin.service.v1.IMilkCollectionService;

@RestController
@RequestMapping(value = { "/v1/collection" })
@CrossOrigin("*")
public class MilkCollectionController {

		@Autowired
		IMilkCollectionService service;
	  
	  	@PostMapping(value="/create")
		public MilkCollection create(@RequestBody MilkCollection item){
			return service.create(item);
		}
	  	

	  	@PostMapping(value="/search")
		public SearchResponseDTO<MilkCollection> search(@RequestBody SearchQueryRequestDto body){
			return service.search(body);
		}
}
