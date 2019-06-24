package com.capgemini.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.omg.CORBA.Current;

import com.capgemini.bean.Account;
import com.capgemini.bean.Transaction;
/**
 * 
 * @author DOLA SAI RAM
 *
 */
public class BankDaoClass implements BankDaoInterface {
	static ArrayList<Account> account = new ArrayList<Account>();
	static List<Transaction> transaction = new ArrayList<Transaction>();
	Transaction t = new Transaction();
	static
	{
		account.add(new Account("Sairam", "dola", "joga rao", "Latha", 123456L, "Sairam", "Vishakaptnam", 2000.0));
		transaction.add(new Transaction(123456L, "Deposit", new Date(), 2000.0));
		account.add(new Account("Sairam", "dola", "joga rao", "Latha", 123459L, "Sairam", "Vishakaptnam", 20000.0));
		transaction.add(new Transaction(123459L, "Deposit", new Date(), 2000.0));
	}

	@Override
	public String addAccount(Account a) throws SQLException, ClassNotFoundException  {
		// TODO Auto-generated method stub
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankapp_db", "root", "jvb@3371");
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ACCOUNT VALUES(?,?,?)");
		preparedStatement.setString(1, a.getFirstName());
		preparedStatement.setString(2, a.getLastName());
		preparedStatement.setString(3, a.getFathersName());
		//preparedStatement.setString(4, a.getMothersName());
		//preparedStatement.setString(5, a.getAddress());
		//preparedStatement.setString(6, a.getPassword());
		preparedStatement.execute();
		System.out.println("hello world");
	
		
		account.add(a);
		return "Created";
	}

	@Override
	public String deposit(Long accountId, Double amount) {
		Double updateAmount =0.0;
		for(Account a:account)
		{
			if(a.getAccountId().equals(accountId) && amount>0)
			{
//					Transaction t = new Transaction();
					t = new Transaction();
					t.setAccountId(accountId);
					t.setAmount(amount);
					t.setD(new Date());
					t.setType("Deposit");
					transaction.add(t);
				updateAmount =a.getBalance()+amount;
				a.setBalance(updateAmount);
				return "success";
			}
		}
		return "invalid amount";
		
	}

	@Override
	public String withDraw(Long accountId, Double amount) {
		
		Double updateAmount =0.0;
		for(Account a:account)
		{
			if(a.getAccountId().equals(accountId));
			{
				if(a.getBalance()>=amount){
				{
//					Transaction t = new Transaction();
					t = new Transaction();
					t.setAccountId(accountId);
					t.setAmount(amount);
					t.setD(new Date());
					t.setType("Withdraw");
					transaction.add(t);
					updateAmount = a.getBalance()-amount;
					a.setBalance(updateAmount);
					return "success";
				}
				
			}
			}
		}
		return "Insufficient amount";
	}

	@Override
	public String fundTransfer(Long accountId1, Long accountId2, Double amount) {
		synchronized(this)
		{
//				Transaction 
			t = new Transaction();
			t.setAccountId(accountId1);
			t.setAmount(amount);
			t.setD(new Date());
			t.setType("Fund Transfer Deposit");
			transaction.add(t);
			t = new Transaction();
			t.setAccountId(accountId2);
			t.setAmount(amount);
			t.setD(new Date());
			t.setType("Fund Transfer Deposit");
			transaction.add(t);
			String status=withDraw(accountId1, amount);
			transaction.remove(transaction.size()-1);
			if(status.equals("success"))
			{
				deposit(accountId2, amount);
				transaction.remove(transaction.size()-1);
				return "success";
			}
			else
			{
				return "Invalid Amount";
			}
		}
	}

	@Override
	public void printTransaction(Long accountId) {
//		List<Transaction> list=new ArrayList<Transaction>();
//		list=transaction.stream().filter((e)->e.getAccountId().equals(accountId)).collect(Collectors.toList());
//		return list;
		
		for(Transaction t: transaction)
		{
			if(t.getAccountId().equals(accountId))
			{
				System.out.println(t);
			}
		}
		
	}
	
	public Boolean uniqueIds(Long id)
	{
		List<Long> uniqueId = account.stream().map((e)->e.getAccountId()).collect(Collectors.toList());
		if(uniqueId.contains(id))
		{
			return true;
		}
		return false;
	}
	
	public Account listing(Long id)
	{
		for(Account a:account)
		{
			if(a.getAccountId().equals(id));
			{
				return a;
			}
		}
		return null;
	}
	public boolean checkAccount(Long id, String password)
	{
		for(Account a:account)
		{
			if(a.getAccountId().equals(id) && a.getPassword().equals(password))
				return true;
		}
		return false;
	}

	@Override
	public Double showBalance(Long accountId) {
		for(Account a:account)
		{
			if(a.getAccountId().equals(accountId))
					return a.getBalance();
		}
		return null;
	}


}
