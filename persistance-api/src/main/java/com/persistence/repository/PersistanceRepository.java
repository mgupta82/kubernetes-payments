package com.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.persistence.entity.PersistanceTransaction;

public interface PersistanceRepository extends JpaRepository<PersistanceTransaction, Long>{
	
	@Query("select count(pt)>0 from PersistanceTransaction pt WHERE pt.msg_Id = ?1")
    public Boolean existsByMsgId(@Param("msg_Id") String msg_Id);

}
