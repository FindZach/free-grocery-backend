package com.findzach.mastin.repository;

import com.findzach.mastin.domain.MastinUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<MastinUser, Long> {
}
