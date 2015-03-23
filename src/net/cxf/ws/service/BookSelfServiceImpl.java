package net.cxf.ws.service;

import javax.jws.WebService;

import net.cxf.ws.dto.Book;

@WebService(endpointInterface="net.cxf.ws.service.BookSelfService",portName="bookPort", targetNamespace="http://ws.cxf.net/", serviceName="bookShelfService")
public class BookSelfServiceImpl implements BookSelfService {

	@Override
	public Book getBookDetails(Book book) {
		System.out.println("### Service Invoked ###");
		//Book book = new Book();
//		book.setAuther("biswa");
//		book.setId(id);
//		book.setName("java");
		
		return book;
	}

}
