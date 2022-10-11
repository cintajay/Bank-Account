package com.orthofx.BankAccounts.Accounts;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;
	
	public List<Account> getAllAccounts(Long id){    //public method to get the list
		List<Account> accounts =new ArrayList<>();
		accountRepository.findByPersonId(id)
		.forEach(accounts::add);
		return accounts;
	}
	public Optional<Account> getAccount(Long id) {	//to get 1 account based on id
		return accountRepository.findById(id); 
	}
	public void addAccount(Account account) {
		accountRepository.save(account);
	}
	public void updateAccount(Account account) {
		accountRepository.save(account);
	}
	public void deleteAccount(Long id) {
		accountRepository.deleteById(id); 
	}

}
