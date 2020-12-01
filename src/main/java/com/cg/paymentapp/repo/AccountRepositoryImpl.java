package com.cg.paymentapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.paymentapp.beans.BankAccount;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.exception.BankAccountNotFoundException;
@Repository
public interface AccountRepositoryImpl extends JpaRepository<BankAccount,Integer>{
@Query("SELECT wallet FROM Wallet wallet WHERE wallet.id=:Id")
List<Wallet> findAllAccounts(@Param("Id") Integer id) throws BankAccountNotFoundException ;


}