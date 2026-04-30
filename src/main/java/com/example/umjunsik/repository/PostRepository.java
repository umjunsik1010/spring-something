package com.example.umjunsik.repository;

import com.example.umjunsik.domain.Post;
import com.example.umjunsik.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Long countByUser(User user);
    List<Post> findByUser(User user);
}