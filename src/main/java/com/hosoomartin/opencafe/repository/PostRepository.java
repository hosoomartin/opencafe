package com.hosoomartin.opencafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hosoomartin.opencafe.domain.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

}
