package net.cxf.ws.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import net.cxf.ws.dto.Book;

@WebService
public interface BookSelfService {
	
	@WebMethod
	public Book getBookDetails(String id);

}
