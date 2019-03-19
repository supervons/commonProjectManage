package com.supervons.cpj.repository;

import com.supervons.cpj.entity.NewsInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * 基于 JPA 操作的 NewsInfoRepository
 * NewsInfoRepository based on JPA operations
 */
@Repository
public interface NewsInfoRepository extends JpaRepository<NewsInfo, String>, JpaSpecificationExecutor<NewsInfo>, Serializable {
    @Query(value ="select * from news_info c "
            + "order by c.news_time desc  limit ?1,?2 ",nativeQuery = true)
    List<NewsInfo> findAllList(Integer pageNumber, Integer pageSize);

    @Query(value ="select count(*) from news_info c "
            + "order by c.news_time desc ",nativeQuery = true)
    Integer countAllList();
}
