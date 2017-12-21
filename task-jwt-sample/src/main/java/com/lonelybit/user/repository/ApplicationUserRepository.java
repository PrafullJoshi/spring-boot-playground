package com.lonelybit.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lonelybit.user.ApplicationUser;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long>{

	ApplicationUser findUserByName(String username);
}
