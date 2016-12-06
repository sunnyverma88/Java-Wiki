package org.techieonthenet.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.techieonthenet.jba.entity.Role;

public interface RoleRepository extends JpaRepository<Role,Integer> {

	Role findByName(String string);

}
