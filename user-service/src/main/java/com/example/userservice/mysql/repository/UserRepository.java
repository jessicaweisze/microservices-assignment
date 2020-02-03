package com.example.userservice.mysql.repository;

import com.example.userservice.web.model.ResolutionUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <ResolutionUser, Integer> {

}
