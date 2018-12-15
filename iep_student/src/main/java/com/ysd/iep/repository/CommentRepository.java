package com.ysd.iep.repository;

import com.ysd.iep.entity.CommentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ysd.iep.entity.StudentComment;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 评价接口
 *
 * @author ASUS
 */
public interface CommentRepository extends JpaRepository<StudentComment, Integer>, JpaSpecificationExecutor<StudentComment> {
    @Query(value = "select new com.ysd.iep.entity.CommentDTO(c.cid,count(c.mid)) from StudentComment c group by cid")
    Page<CommentDTO> queryCommentPagingOrder(Pageable pageable);
    
    
    
}
