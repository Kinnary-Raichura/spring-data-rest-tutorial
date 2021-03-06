package com.kinnary.tutorial.jpa.repository;

import com.kinnary.tutorial.jpa.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by kraichura on 10/30/2015.
 */
@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    public List<Todo> findByTitleAndDescription( String title,
                                                   String description);
}
