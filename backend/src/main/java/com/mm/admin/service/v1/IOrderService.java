package com.mm.admin.service.v1;

import com.mm.admin.dto.ResponseDto;
import com.mm.admin.model.v1.Order;
import com.mm.admin.model.v1.User;
import com.mm.admin.model.v1.inputs.RedisTemplateInput;

public interface IOrderService {

	public Order create(User user);

	public String processAndPlaceOrderByWhatsapp(RedisTemplateInput userTemplate);

	public ResponseDto findAll();

	Order findById(Long orderId);

	public Order update(Order order);
}
