package org.example.ws.endpoint;

import org.example.account.Account;
import org.example.accountservice.AccountDetailsRequest;
import org.example.accountservice.AccountDetailsResponse;
import org.example.ws.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class AccountServiceEndpoint {
	
	private static final String TARGET_NAMESPACE = "http://org/example/accountservice";  
	
	@Autowired
	private AccountService accountService;
	
	@PayloadRoot(localPart="AccountDetailsRequest", namespace=TARGET_NAMESPACE)
	public @ResponsePayload AccountDetailsResponse getAccountDetails(@RequestPayload AccountDetailsRequest request){
		
		 AccountDetailsResponse response = new AccountDetailsResponse(); 
		 Account account = accountService.getAccountDetails(request.getAccountNumber());
		 response.setAccountDetails(account);
		return response;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
}
