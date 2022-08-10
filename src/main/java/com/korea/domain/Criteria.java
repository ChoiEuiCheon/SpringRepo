package com.korea.domain;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
@Getter
@Setter
@ToString
public class Criteria {
	private int pageNum;
	private int amount;
	
	public Criteria() {
		this(1,10);
		type="T";
		keyWord="";
	}
	public Criteria(int pageNum, int amount) {
		this.pageNum=pageNum;
		this.amount=amount;
				
	}
	
	private String type;
	private String keyWord;
}
