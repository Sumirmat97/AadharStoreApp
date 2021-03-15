package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("SELECT u FROM User u WHERE u.name LIKE %?1%")
    public List<User> searchByName(String keyword);
	
	@Query("SELECT u FROM User u WHERE u.address LIKE %?1%")
    public List<User> searchByAddress(String keyword);	
	
	@Query("SELECT u FROM User u WHERE u.aadharNo LIKE %?1%")
    public List<User> searchByAadhar(String keyword);
}
