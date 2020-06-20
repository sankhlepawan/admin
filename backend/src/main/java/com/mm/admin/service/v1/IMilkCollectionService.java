package com.mm.admin.service.v1;

import com.mm.admin.dto.SearchQueryRequestDto;
import com.mm.admin.dto.SearchResponseDTO;
import com.mm.admin.model.v1.MilkCollection;

public interface IMilkCollectionService {

	public MilkCollection create(MilkCollection item);
	SearchResponseDTO<MilkCollection> search(SearchQueryRequestDto searchQuery);
}
