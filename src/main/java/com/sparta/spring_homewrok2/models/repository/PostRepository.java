package com.sparta.spring_homewrok2.models.repository;


import com.sparta.spring_homewrok2.models.ListPostInterface;
import com.sparta.spring_homewrok2.models.Post;
import com.sparta.spring_homewrok2.models.PostInterface;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;



public interface PostRepository extends JpaRepository<Post,Long> {

    List<ListPostInterface> findAllByOrderByModifiedAtDesc();
    PostInterface findAllById(Long id);






}
