package com.ysd.iep.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ysd.iep.entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer>, JpaSpecificationExecutor<Post> {

	 public Post queryPostByPostId(Integer postId);
	 
	 @Query(value = "UPDATE posttb SET post_isstick=1 WHERE post_id=?1", nativeQuery = true)
	 @Modifying
	 @Transactional
	 public Integer stickPost(Integer postId);
	 
	 @Query(value = "UPDATE posttb SET post_isstick=0 WHERE post_id=?1", nativeQuery = true)
	 @Modifying
	 @Transactional
	 public Integer cancelStick(Integer postId);
	 
	 public Post findByPostId(Integer postId);

}
