package com.zloebok.todoproject.repository;

import com.zloebok.todoproject.entity.ToDoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
public interface ToDoRepository extends JpaRepository<ToDoEntity, Long> {
    @Transactional
    @Modifying
    @Query("update ToDoEntity t set t.description = ?1, t.updated = ?2 where t.id = ?3")
    void updateDescriptionAndUpdatedById(String description, Date updated, @NonNull Long id);

}
