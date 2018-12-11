package com.ysd.iep.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ysd.iep.entity.PostPage;

public interface PostpageRepository extends JpaRepository<PostPage, Integer>, JpaSpecificationExecutor<PostPage> {

}
