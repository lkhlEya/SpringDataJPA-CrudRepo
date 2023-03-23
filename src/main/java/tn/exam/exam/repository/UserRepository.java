package tn.exam.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.exam.exam.entity.User;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
