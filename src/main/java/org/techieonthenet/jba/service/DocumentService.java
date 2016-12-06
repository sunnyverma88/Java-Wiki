package org.techieonthenet.jba.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.techieonthenet.jba.entity.Blog;
import org.techieonthenet.jba.entity.Document;
import org.techieonthenet.jba.entity.User;
import org.techieonthenet.jba.repository.BlogRepository;
import org.techieonthenet.jba.repository.DocumentRepository;
import org.techieonthenet.jba.repository.RoleRepository;
import org.techieonthenet.jba.repository.UserRepository;

@Service
@Transactional
public class DocumentService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired 
	private BlogRepository blogRepository;
	
	@Autowired
	private DocumentRepository documentRepository;
	
	
	public void save(Document document,String email,int blogId)
	{
		User user=userRepository.findByEmail(email);
		Blog blog=blogRepository.findOne(blogId);
		document.setUser(user);
		document.setBlog(blog);
		documentRepository.save(document);	
	}
	
	 @Transactional
	public List<Document> findByBlogId(int blogId)
	{
		Blog blog=blogRepository.findOne(blogId);
		return documentRepository.findByBlog(blog);
		
	}
	
	 @Transactional
	public Document findById(Integer Id)
	{
		return documentRepository.findById(Id);
	}

}
