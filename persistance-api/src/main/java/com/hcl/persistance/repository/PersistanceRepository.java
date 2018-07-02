package com.hcl.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.persistance.entity.PersistanceTransaction;

public interface PersistanceRepository extends JpaRepository<PersistanceTransaction, Long>{

}
