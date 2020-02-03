package com.example.userservice.mysql.repository;

import com.example.userservice.web.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User, String> {

}
