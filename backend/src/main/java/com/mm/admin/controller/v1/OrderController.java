package com.mm.admin.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mm.admin.dto.ResponseDto;
import com.mm.admin.model.v1.Order;
import com.mm.admin.service.v1.IOrderService;

@RestController
@RequestMapping(value = { "/v1/order" })
@CrossOrigin("*")
public class OrderController {

    @Autowired
	IOrderService service; 
	
	@GetMapping(value="/findAll")
	public ResponseDto findAll() {
		//return service.findAll();
		return null;
	}
	
	@GetMapping(value="/detailById/{orderId}")
	public Order findById(@PathVariable("orderId") Long orderId){
		return service.findById(orderId);
	}
	
	@PostMapping(value="/update")
	public Order findById(@RequestBody Order order){
		return service.update(order);
	}
	
	
}

