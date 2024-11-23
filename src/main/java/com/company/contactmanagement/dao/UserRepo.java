package com.company.contactmanagement.dao;

import com.company.contactmanagement.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
