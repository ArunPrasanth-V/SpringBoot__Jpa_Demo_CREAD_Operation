package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transfer_to_DB {
   @Id
   public int id;
   public String name;
   
public String toString()
   {
	   return name+" : "+id;
   }
   
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
   
}
