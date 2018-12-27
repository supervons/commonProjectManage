package com.supervons.cpj.repository;

import java.io.Serializable;
import java.util.List;

import com.supervons.cpj.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * 基于 JPA 操作的 UserInfoRepository
 * UserInfoRepository based on JPA operations
 */
@Repository
public interface UserInfoRepository extends JpaRepository<User, String>, JpaSpecificationExecutor<User>, Serializable {
}
