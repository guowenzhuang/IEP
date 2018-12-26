package com.ysd.iep.repository;

import com.ysd.iep.entity.StudentRecord;
import lombok.val;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * 学生学习接口
 */
public interface StudentRecordDao extends JpaRepository<StudentRecord ,Integer> {
    @Query(value = "select * from studentrecordtb where (cid ,chaid) in (select  cid,max(chaid) chaid FROM studentrecordtb group by cid) order by starttime desc",nativeQuery = true)
    Page<StudentRecord> findAllMaxCha(Pageable pageable);
}
