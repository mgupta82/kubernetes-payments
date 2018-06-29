package com.payment.router.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.payment.router.model.CassandraTransaction;

@Repository
@Profile("cassandra")
public interface CassandraTransactionRepository extends CrudRepository<CassandraTransaction, String> {
	
	@Query("select * from cassandratransaction where messageid=?0")
	CassandraTransaction findByMessageId(String messageId);
	

}
