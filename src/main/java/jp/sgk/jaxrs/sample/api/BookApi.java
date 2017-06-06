package jp.sgk.jaxrs.sample.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import jp.sgk.jaxrs.sample.bean.Book;
import jp.sgk.jaxrs.sample.bean.BookFactory;
import jp.sgk.jaxrs.sample.bean.IBookFactory;

/**
 * Book API
 * @author HANIYAMA
 *
 */
@Path("/book")
public class BookApi {
	private IBookFactory factory;

	/**
	 * コンストラクタ
	 */
	public BookApi() {
		this.factory = BookFactory.getInstance();
	}

	/**
	 * BookFactoryを注入するコンストラクタ
	 *
	 * @param factory {@link IBookFactory}
	 */
	public BookApi(IBookFactory factory){
		this.factory = factory;
	}

	/**
	 * Book List を取得
	 * @return Book List
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> getBookList(){
		return factory.getList();
	}

	/**
	 * id から Book を取得
	 * @param id id
	 * @return Book
	 */
	@GET
	@Path("id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Book getBook(@PathParam("id") int id){
		return factory.getById(id);
	}

	/**
	 * id から Book を削除
	 * @param id id
	 * @return BookList
	 */
	@DELETE
	@Path("id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> deleteBook(@PathParam("id") int id){
		factory.deleteById(id);
		return factory.getList();
	}

	/**
	 * 書名から Book を検索
	 * @param name 書名
	 * @return Book List
	 */
	@GET
	@Path("name/{name}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> getBook(@PathParam("name") String name){
		return factory.findByName(name);
	}

	/**
	 * Book を新規登録
	 * @param book Book
	 * @return Book List
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> setBook(Book book){
		factory.addBook(book);
		return factory.getList();
	}
}
