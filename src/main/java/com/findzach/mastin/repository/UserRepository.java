package com.findzach.mastin.repository;

import com.findzach.mastin.domain.user.MastinUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Zach Smith
 * @since 9/15/2024
 */
@Repository
public interface UserRepository extends JpaRepository<MastinUser, Long> {
}
