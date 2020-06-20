package com.mm.admin.handler;

import com.mm.admin.model.v1.inputs.RedisTemplateInput;

public interface IGoogleMapHandler {

	void setUerAddressByLatLong(Float lat, Float lng, RedisTemplateInput user);
}
