package jp.sgk.jaxrs.sample.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import jp.sgk.jaxrs.sample.bean.Book;
import jp.sgk.jaxrs.sample.bean.BookFactory;
import jp.sgk.jaxrs.sample.bean.IBookFactory;

@Path("/book")
public class BookApi {
	private IBookFactory factory;

	public BookApi() {
		this.factory = BookFactory.getInstance();
	}

	public BookApi(IBookFactory factory){
		this.factory = factory;
	}

	@GET
	@Path("id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Book getBook(@PathParam("id") int id){
		return factory.getById(id);
	}
	@GET
	@Path("name/{name}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> getBook(@PathParam("name") String name){
		return factory.findByName(name);
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> getBooks(){
		return factory.getList();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> setBook(Book book){
		factory.addBook(book);
		return factory.getList();
	}
}
