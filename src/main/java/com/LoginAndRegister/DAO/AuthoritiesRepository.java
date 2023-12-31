package com.LoginAndRegister.DAO;

import com.LoginAndRegister.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthoritiesRepository extends JpaRepository<Role, Integer> {
}