package com.supervons.cpj.repository;

import com.supervons.cpj.entity.LoggerInfos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * 基于 JPA 操作的 LoggerInfosRepository
 * LoggerInfosRepository based on JPA operations
 */
@Repository
public interface LoggerInfosRepository extends JpaRepository<LoggerInfos, String>, JpaSpecificationExecutor<LoggerInfos>, Serializable {
}
