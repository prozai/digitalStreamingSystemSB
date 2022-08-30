package com.digitalStreamingSystemSB.repository;

import com.digitalStreamingSystemSB.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Admin findByEmail(String email);
    Admin findByEmailAndPassword(String email, String password);
}

