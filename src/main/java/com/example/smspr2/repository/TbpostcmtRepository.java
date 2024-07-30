package com.example.smspr2.repository;

import com.example.smspr2.domain.Tbpostcmt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TbpostcmtRepository extends JpaRepository<Tbpostcmt, String> {
}
