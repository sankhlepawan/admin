package com.mm.admin.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.NoArgsConstructor;
import lombok.ToString;


@JsonInclude(Include. NON_NULL)
@Component
@ToString
@NoArgsConstructor
public class ResponseDto {
	
	Iterable items;
	List data;
	long count;
	String status;
	
	public ResponseDto items(Iterable items){
		this.items = items;
		return this;
	}
	
	public ResponseDto status(String status){
		this.status = status;
		return this;
	}
	
	public ResponseDto count(long count){
		this.count = count;
		return this;
	}
	
	public ResponseDto data(List data){
		this.data = data;
		return this;
	}
	
	
	public ResponseDto build() {
		ResponseDto res = new ResponseDto();
		res.items = this.items;
		res.data = this.data;
		res.count = this.count;
		res.status = this.status;
		return res;
	}

}	
