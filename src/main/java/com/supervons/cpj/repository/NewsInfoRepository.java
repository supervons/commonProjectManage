package com.supervons.cpj.repository;

import com.supervons.cpj.entity.NewsInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * 基于 JPA 操作的 NewsInfoRepository
 * NewsInfoRepository based on JPA operations
 */
@Repository
public interface NewsInfoRepository extends JpaRepository<NewsInfo, String>, JpaSpecificationExecutor<NewsInfo>, Serializable {
}
