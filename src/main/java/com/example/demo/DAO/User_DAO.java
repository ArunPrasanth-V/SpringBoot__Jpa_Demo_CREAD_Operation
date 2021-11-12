package com.example.demo.DAO;

import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.example.demo.model.Transfer_to_DB;

public interface User_DAO extends CrudRepository<Transfer_to_DB,Integer>
{

	//void save(Transfer_to_DB user);

}
