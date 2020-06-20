package com.mm.admin.service.v1;

import java.util.Locale;

import com.mm.admin.model.v1.SubCategory;
import com.mm.admin.model.v1.inputs.RedisTemplateInput;

public interface IWhatsappMenuService {

	String createOrderMenu(Locale locale);

	String createSelectPaymentMenu(Locale locale, RedisTemplateInput user);

	String createSubCategoryMenu(String name, Locale locale);

	String getSelectQwtMenu(SubCategory subCategory, Locale locale);

	String getAddressConfirmMenu(Locale locale);

	String getUserOrders(RedisTemplateInput user, Locale locale);

}
