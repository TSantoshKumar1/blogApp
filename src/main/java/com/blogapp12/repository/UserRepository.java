package com.blogapp12.repository;

import com.blogapp12.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User , Long> {

    public boolean existsByEmail(String email);

    public boolean existsByUsername(String username);

    public User findByUsername( String username);
}


