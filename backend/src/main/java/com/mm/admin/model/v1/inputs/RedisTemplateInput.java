package com.mm.admin.model.v1.inputs;

import java.util.Date;
import java.util.Locale;

import com.mm.admin.model.v1.LastSelectedMenu;
import com.mm.admin.model.v1.PaymentType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RedisTemplateInput {

	String whtsappNumber;
	Locale locale;
	LastSelectedMenu selectedMenu;
	Date updateOn;
	String itemName;
	double total;
	int qwt;
	String unit;
	String latLng;
	PaymentType paymentMethod;
	String shippingAddress;
	boolean subscription;
}