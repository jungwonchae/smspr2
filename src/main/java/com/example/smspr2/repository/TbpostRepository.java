package com.example.smspr2.repository;

import com.example.smspr2.domain.Tbpost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public class TbpostRepository extends JpaRepository<Tbpost, String> {
}
