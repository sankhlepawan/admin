package com.mm.admin.repo.v1;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mm.admin.model.v1.Order;

@Repository
public interface IOrderRepo extends CrudRepository<Order, Long> {

	public List<Order> findByWhtsappNumber(String whtsappNumber);
	
}
