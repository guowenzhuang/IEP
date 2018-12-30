package com.ysd.iep.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.ysd.iep.entity.CoursePost;

public interface CoursePostRepository extends JpaRepository<CoursePost, Integer>, JpaSpecificationExecutor<CoursePost> {

	@Query(value = "SELECT * FROM courseposttb p JOIN coursereplytb r ON p.post_id=r.post_id \r\n"
			+ "WHERE r.reply_parentid=0 AND r.course_id IN ?1 \r\n"
			+ "ORDER BY r.reply_likenum DESC,r.reply_time DESC LIMIT 5", nativeQuery = true)
	public List<CoursePost> getHotPost(List<Integer> courseIds);

}
