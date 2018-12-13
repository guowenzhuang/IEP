package com.ysd.iep.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ysd.iep.entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer>, JpaSpecificationExecutor<Post> {

	 public Post queryPostByPostId(Integer postId);
	 
	 @Query(value="INSERT INTO posttb(post_title) VALUES(?1)", nativeQuery = true)
	 @Modifying
	 @Transactional
	 public Integer insertPort(String title);
	

}
