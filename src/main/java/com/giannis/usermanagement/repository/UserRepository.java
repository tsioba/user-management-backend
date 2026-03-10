package com.giannis.usermanagement.repository;

import com.giannis.usermanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT COUNT(u) > 0 FROM User u WHERE LOWER(u.name) = LOWER(:name) AND LOWER(u.surname) = LOWER(:surname)")
    boolean existsByFullName(@Param("name") String name, @Param("surname") String surname);

}