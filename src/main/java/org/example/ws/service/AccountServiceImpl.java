package org.example.ws.service;

import org.example.account.Account;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

	public Account getAccountDetails(String accountNumber) {
		
		System.out.println("getAccountDetails invoke for : "+accountNumber);
		Account account = new Account();
		account.setAccountBalance(5000);
		account.setAccountName("biswa");
		account.setAccountNumber("ab123456");
		
		return account;
	}

}
