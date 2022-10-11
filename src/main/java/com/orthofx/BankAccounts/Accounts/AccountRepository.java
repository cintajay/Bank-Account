package com.orthofx.BankAccounts.Accounts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{ //<class, primary key type>
	//public List<Account> findbyAccType(String accType);    //custom find method, works as long as accType exist in Account
	public List<Account> findByPersonId(Long personId); 
}
