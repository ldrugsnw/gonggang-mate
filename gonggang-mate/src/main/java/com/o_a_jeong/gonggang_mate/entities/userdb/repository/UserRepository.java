package com.o_a_jeong.gonggang_mate.entities.userdb.repository;

import com.o_a_jeong.gonggang_mate.entities.userdb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByStuNameAndMajorName(String stuName, String majorName);

    Optional<User> findByStuName(String username);
}
