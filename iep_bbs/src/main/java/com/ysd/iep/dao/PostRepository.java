package com.ysd.iep.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ysd.iep.entity.Post;


public interface PostRepository extends JpaRepository<Post, Integer>{

}
