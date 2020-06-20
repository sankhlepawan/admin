package com.mm.admin.service.v1;

import com.mm.admin.dto.SearchQueryRequestDto;
import com.mm.admin.dto.SearchResponseDTO;

public interface IGenericSearchService<T> {

	SearchResponseDTO<T> search(SearchQueryRequestDto searchQuery);
}
