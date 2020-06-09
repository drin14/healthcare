package com.labcourse.registrationservice.Repositories;

import com.labcourse.registrationservice.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

}
