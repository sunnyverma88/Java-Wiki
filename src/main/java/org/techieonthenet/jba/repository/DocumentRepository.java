package org.techieonthenet.jba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.techieonthenet.jba.entity.Blog;
import org.techieonthenet.jba.entity.Document;


	
	public interface DocumentRepository extends JpaRepository<Document, Integer>{
		
		List<Document> findByBlog(Blog blog);
		Document findById(Integer id);
}
