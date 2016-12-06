package org.techieonthenet.jba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.techieonthenet.jba.entity.Blog;
import org.techieonthenet.jba.entity.XmlUrl;
import org.techieonthenet.jba.entity.XmlUrlSet;
import org.techieonthenet.jba.service.BlogService;

@Controller
	public class SitemapController {

	
	@Autowired
	private BlogService bs;
	
	
	    @RequestMapping(value = "/sitemap.xml", method = RequestMethod.GET)
	    @ResponseBody
	    public XmlUrlSet main() {
	        XmlUrlSet xmlUrlSet = new XmlUrlSet();
	        create(xmlUrlSet, "", XmlUrl.Priority.HIGH);
	        create(xmlUrlSet, "/register", XmlUrl.Priority.HIGH);
	        create(xmlUrlSet, "/index", XmlUrl.Priority.HIGH);
	        create(xmlUrlSet, "/login", XmlUrl.Priority.HIGH);
	        create(xmlUrlSet, "/user/forgotpwd", XmlUrl.Priority.HIGH);
            
	        // for loop to generate all the links by querying against database
	       List<Blog> blogList=bs.getBlogs();
	       
	       for(Blog blog:blogList)
	       {
	    	   create(xmlUrlSet, "/blog/"+blog.getBlogId(), XmlUrl.Priority.HIGH);  
	       }

	        return xmlUrlSet;
	    }

	    private void create(XmlUrlSet xmlUrlSet, String link, XmlUrl.Priority priority) {
	        xmlUrlSet.addUrl(new XmlUrl("http://www.techieonthenet.com" + link, priority));
	    }

	}

