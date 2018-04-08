package com.frankxulei;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.frankxulei.models.User;
import com.frankxulei.repository.UsersRepository;
/**
 * @Package com.frankxulei 
 * @ClassName: Application  
 * @Description: Spring Data 《Mongodb实战》第2版本例子代码
 * @author Frank Xu Lei  
*/
@SpringBootApplication
public class Application implements CommandLineRunner {

	/**
	 * Spring 自动装配 
	 */
	@Autowired
	private UsersRepository repository;
	/**
	 * 主函数 执行入口
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//删除数据delete users
		repository.deleteAll();
		//保存数据save users
		for (int i = 0; i < 10; i++) {
			User user = new User();
			user.setId(new ObjectId());
			user.setName("Spring Data 《Mongodb实战》第2版:"+i);
			user.setPassword("frankxulei");
			user.setEmail("frankxulei@aliyun.com");
			repository.save(user);
		}
		//更新
		User user = new User();
		user.setName("Spring Data 《Mongodb实战》第2版:8");
		user.setPassword("frankxulei12345678");
		user.setEmail("frankxulei@aliyun.com12345678");
		repository.save(user);
		// fetch all users
		System.out.println("查找所有用户");
		System.out.println("-------------------------------");
		for (User user2 : repository.findAll()) {
			System.out.println(user2.getName());
		}
		// fetch an some users
		System.out.println("条件查询用户");
		System.out.println("--------------------------------");
		for (User user3 : repository.findByName("Spring Data 《Mongodb实战》第2版:8")) {
			System.out.println(user3.getEmail());
		}
	}
}