package com.fawry.intern.atm.repository;

import com.fawry.intern.atm.repository.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtmRepo extends JpaRepository<Account, Long> {

}
