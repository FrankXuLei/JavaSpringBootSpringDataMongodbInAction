package com.frankxulei.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.frankxulei.models.User;
/**
 * @Package com.frankxulei 
 * @ClassName: UsersRepository  
 * @Description: Spring Data 《Mongodb实战》第2版本例子代码 
 * @author Frank Xu Lei  
*/
public interface UsersRepository extends MongoRepository<User, String> {

    public List<User> findByName(String name);
    public List<User> findByEmail(String email);
    public List<User> findAll();
}
