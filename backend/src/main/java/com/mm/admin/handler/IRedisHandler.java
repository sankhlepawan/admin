package com.mm.admin.handler;

import com.mm.admin.model.v1.inputs.RedisTemplateInput;

public interface IRedisHandler {
   
	public RedisTemplateInput get(String key);
	public void set(String key, RedisTemplateInput template);
	public void delete(String key);
}
