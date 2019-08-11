package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.transactions;

public interface TransactionsRepo extends JpaRepository<transactions, Integer> {

	@Query(value = "SELECT * FROM transactions t WHERE t.transaction_id=?1 and t.otp=?2 and t.otp_status='active' and t.transaction_status='pending' ", nativeQuery = true)
	public transactions validate(int transactionId, String otp);

	@Query(value = "SELECT * FROM transactions t WHERE t.transaction_id=?1 and t.otp_status='active' and t.transaction_status='pending' ", nativeQuery = true)
	public transactions findByTransactionId(int transactionId);

}
