package org.techieonthenet.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.techieonthenet.jba.entity.Article;
import org.techieonthenet.jba.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact,Integer>{

}
