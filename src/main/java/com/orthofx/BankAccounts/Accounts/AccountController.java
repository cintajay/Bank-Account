package com.orthofx.BankAccounts.Accounts;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.orthofx.BankAccounts.person.Person;

@RestController
public class AccountController {
	
	@Autowired
	private AccountConverterService accountService;
	
//	@RequestMapping("/persons/{id}/accounts")
//	public List<Account>getAllAccounts(@PathVariable Long id){
//		return accountService.getAllAccounts(id);
//	}
	@RequestMapping("/persons/{id}/accounts")
	public List<AccountDto>getAllAccounts(@PathVariable Long id){
		return accountService.getAllAccounts(id);
	}
	
	@RequestMapping("/persons/{personId}/accounts/{id}")  //default is get
	public AccountDto getAccount(@PathVariable Long id) {
		return accountService.getAccount(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/persons/{personId}/accounts") //post is specified
	public void addAccount(@RequestBody AccountDto account, @PathVariable Long personId) { //converts from JSON to object of type Person	
		account.setPerson(new Person(personId,""));
		accountService.addAccount(account);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/persons/{personId}/accounts/{id}") 
	public void updateAccount(@RequestBody AccountDto account, @PathVariable Long personId, @PathVariable Long id) { 
		//check if personId, id exist
		account.setPerson(new Person(personId,""));
		accountService.updateAccount(account, id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/persons/{personId}/accounts/{id}") 
	public void deleteAccount(@PathVariable Long personId, @PathVariable Long id) {
		accountService.deleteAccount(id);
	}

}
