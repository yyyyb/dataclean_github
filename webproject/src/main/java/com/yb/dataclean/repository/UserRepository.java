package com.yb.dataclean.repository;

import com.yb.dataclean.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    public User findByUseridAndPassword(String userid,String password);
}
