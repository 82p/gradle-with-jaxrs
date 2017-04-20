package jp.sgk.jaxrs.sample.bean;

import java.util.List;

public interface IBookFactory {
	public Book getById(int id);
	public Book getByIsbn(String isbn);
	public void addBook(Book book);
	public List<Book> findByName(String name);
	public List<Book> getList();
}
