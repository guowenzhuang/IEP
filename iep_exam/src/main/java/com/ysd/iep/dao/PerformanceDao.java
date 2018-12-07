package com.ysd.iep.dao;

import com.ysd.iep.entity.Performance;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author gaozhongye
 * @date 2018/12/7
 * 成绩表dao
 */
public interface PerformanceDao extends JpaRepository<Performance, String> {
}
