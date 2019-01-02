package com.ysd.iep.repository;

import com.ysd.iep.entity.StudentRecord;
import lombok.val;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 学生学习接口
 */
public interface StudentRecordDao extends JpaRepository<StudentRecord ,Integer> {
    @Query(value = "select * from studentrecordtb where (cid ,chaid) in (select  cid,max(chaid) chaid FROM studentrecordtb group by cid) and sid =:id order by starttime desc",nativeQuery = true)
    Page<StudentRecord> findAllMaxCha(@Param("id") String id, Pageable pageable);

    List<StudentRecord> findBySidAndCid(String sid,Integer cid);


    /**
     * 根据学生id 课程id 章节id  查询学生的已经观看时间
     * @param id   学生id
     * @param cid  课程id
     * @param chaid  章节id
     * @return
     */
    @Query(value = "select watchtime from iep_student.studentrecordtb where sid=:id and cid=:cid and chaid=:chaid",nativeQuery = true)
    String findWatch(@Param("id") String id,
                     @Param("cid") Integer cid,
                     @Param("chaid") Integer chaid);

    @Query(value = "select * from iep_student.studentrecordtb where sid=:id and cid=:cid",nativeQuery = true)
    List<StudentRecord> findWatch(@Param("id") String id,
                                  @Param("cid") Integer cid);

    @Query(value = "select * from iep_student.studentrecordtb where sid=:id and cid=:cid and chaid=:chaid",nativeQuery = true)
    StudentRecord findRecord(@Param("id") String id,
                  @Param("cid") Integer cid,
                  @Param("chaid") Integer chaid);
}
