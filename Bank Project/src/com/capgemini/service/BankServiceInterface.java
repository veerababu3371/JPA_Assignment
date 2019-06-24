package com.capgemini.service;

import java.sql.SQLException;
import java.util.List;

import com.capgemini.bean.Account;
import com.capgemini.bean.Transaction;
/**
 * 
 * @author DOLA SAI RAM
 *
 */
public interface BankServiceInterface {
	public String addAccount(Account a) throws ClassNotFoundException, SQLException;
	public String deposit(Long accountId, Double amount);
	public String withDraw(Long accountId, Double amount);
	public Double showBalance(Long accountId);
	public String fundTransfer(Long accountId1, Long accountId2, Double amount);
	public void printTransaction(Long accountId);
	
}
