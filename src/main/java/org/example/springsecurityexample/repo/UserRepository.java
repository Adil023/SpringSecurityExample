package org.example.springsecurityexample.repo;

import org.example.springsecurityexample.modle.User;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
       User findByUsername(String username);
}
