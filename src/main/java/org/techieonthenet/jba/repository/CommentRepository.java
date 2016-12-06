package org.techieonthenet.jba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.techieonthenet.jba.entity.Blog;
import org.techieonthenet.jba.entity.Comment;
import org.techieonthenet.jba.entity.User;


	
	public interface CommentRepository extends JpaRepository<Comment, Integer>{
		
		List<Comment> findByBlog(Blog blog);
}
