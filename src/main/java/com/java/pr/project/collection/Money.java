package com.java.pr.project.collection;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Money {
	String merchantName;
	
	BigDecimal allMoney;

}
