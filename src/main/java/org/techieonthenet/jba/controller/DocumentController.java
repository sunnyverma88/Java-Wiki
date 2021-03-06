package org.techieonthenet.jba.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Principal;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import javax.validation.Valid;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.techieonthenet.jba.entity.Blog;
import org.techieonthenet.jba.entity.Document;
import org.techieonthenet.jba.entity.User;
import org.techieonthenet.jba.service.BlogService;
import org.techieonthenet.jba.service.DocumentService;
import org.techieonthenet.jba.service.UserService;



@Controller
public class DocumentController {

	@Autowired
	private UserService us;
	
	@Autowired
	private BlogService bs;
	
	@Autowired
	private DocumentService ds;
	
	@ModelAttribute
	public User constructUser()
	{
		return new User();
	}
	@ModelAttribute
	public Blog constructBlog()
	{
		return new Blog();
	}
	@ModelAttribute
	public Document constructDocument()
	{
		return new Document();
	}
	
	
	
	@RequestMapping(value="/blog/{id}",method=RequestMethod.POST)
	public String doAddDocument(@Valid @ModelAttribute("document")Document document,Principal principal,BindingResult result,Model model,RedirectAttributes rdr,@PathVariable("id") int blogId,@RequestParam("file") MultipartFile file) throws IOException, SerialException, SQLException
	{   
		if(result.hasErrors())
		{   
		    System.out.println("Isnide Error "+result.getAllErrors().toString());
			return "redirect:/blog/"+blogId;
			
		}
		String email=principal.getName();
		System.out.println("inside save Document");
		InputStream is=file.getInputStream();
		byte[] bytes = IOUtils.toByteArray(is);
		

		document.setFilename(file.getOriginalFilename());
		document.setContent(bytes);
		document.setContentType(file.getContentType());
		
		ds.save(document, email, blogId);
		rdr.addFlashAttribute("message", "Thanks for submitting the Document.");
		return "redirect:/blog/"+blogId; 
		
	}
	
	@RequestMapping("/download/{id}/{documentId}")
	public String download(@PathVariable("documentId")
			Integer documentId, @PathVariable("id") int blogId,HttpServletResponse response) {
		
		Document doc = ds.findById(documentId);
		try {
			response.setHeader("Content-Disposition", "inline;filename=\"" +doc.getFilename()+ "\"");
			OutputStream out = response.getOutputStream();
			response.setContentType(doc.getContentType());
			out.write(doc.getContent());
			out.flush();
			out.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return "redirect:/blog/"+blogId; 
	}
}
