package com.orthofx.BankAccounts.Accounts;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("/accounts")
	public List<Account>getAllPersons(){
		return accountService.getAllAccounts();
	}
	
	@RequestMapping("/accounts/{id}")  //default is get
	public Optional<Account> getAccount(@PathVariable String id) {
		return accountService.getAccount(id);
	}
	@RequestMapping(method=RequestMethod.POST, value="/accounts") //post is specified
	public void addAccount(@RequestBody Account account) { //converts from JSON to object of type Person
		accountService.addAccount(account);
	}
	@RequestMapping(method=RequestMethod.PUT, value="/accounts/{id}") 
	public void updateAccount(@RequestBody Account account, @PathVariable String id) { 
		accountService.updateAccount(id, account);
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/accounts/{id}") 
	public void deletePerson(@PathVariable String id) {
		accountService.deleteAccount(id);
	}

}
