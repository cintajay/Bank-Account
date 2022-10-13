package com.orthofx.BankAccounts.Accounts;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orthofx.BankAccounts.person.Person;
import com.orthofx.BankAccounts.person.PersonDto;

@Service
public class AccountConverterService {

	@Autowired
	private AccountRepository accountRepository;

	private AccountDto EntityToDTO(Account account) {
		AccountDto dto = new AccountDto();
		dto.setId(account.getId());
		dto.setAccNumber(account.getAccNumber());
		dto.setAccType(account.getAccType());
		dto.setPerson(account.getPerson());
		return dto;
	}

	public Account DTOToEntity(AccountDto dto) {
		Account account = new Account();
		account.setId(dto.getId());
		account.setAccNumber(dto.getAccNumber());
		account.setAccType(dto.getAccType());
		account.setPerson(dto.getPerson());
		return account;
	}

	public List<AccountDto> getAllAccounts(Long id) { 
		return accountRepository.findByPersonId(id).stream().map(this::EntityToDTO).collect(Collectors.toList());
		
	}
	public AccountDto getAccount(Long id) {	//to get 1 account based on id
		Account account=accountRepository.getOne(id); 
		AccountDto dto=EntityToDTO(account);
		return dto;
	}
	public void addAccount(AccountDto dto) {
		Account account=DTOToEntity(dto);
		accountRepository.save(account);
	}
	public void updateAccount( AccountDto dto, Long id) {
		Account account=DTOToEntity(dto);
		account.setAccNumber(account.getAccNumber());
		account.setAccType(account.getAccType());
		accountRepository.save(account);	
	}
	public void deleteAccount(Long id) {
		accountRepository.deleteById(id);
	}

}
