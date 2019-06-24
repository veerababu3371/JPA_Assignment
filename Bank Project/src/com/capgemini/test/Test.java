package com.capgemini.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;

import com.capgemini.bean.Account;
import com.capgemini.service.BankServiceClass;
/**
 * 
 * @author DOLA SAI RAM
 *
 */
class Test {
	static BankServiceClass bsc;
	@BeforeAll
	public static void init()
	{
		bsc = new BankServiceClass(); 
	}
	
	
	@org.junit.jupiter.api.Test
	void test() {
		assertEquals("invali", bsc.addAccount(new Account("abc", "", "xy", "qwe",741258L , "sairam", "Sairam", 20000.0)));
	}
	
	
}
