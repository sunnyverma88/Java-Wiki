package org.techieonthenet.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.techieonthenet.jba.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{

	User findByName(String name);
	User findByEmail(String email);

}
