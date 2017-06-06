package jp.sgk.jaxrs.sample.bean;

import java.util.List;

/**
 * Interface of BookFactory
 *
 * @author HANIYAMA
 *
 */
public interface IBookFactory {
	/**
	 * get book by id
	 * @param id book id
	 * @return {@link Book}
	 */
	Book getById(int id);
	/**
	 * add book to booklist
	 * @param book book to add
	 */
	void addBook(Book book);
	/**
	 * get book list that matched argument name
	 * @param name search string
	 * @return list of {@link Book}
	 */
	List<Book> findByName(String name);
	/**
	 * get all book list
	 *
	 * @return list of {@link Book}
	 */
	List<Book> getList();
	/**
	 * delete book by id
	 * @param id book id will delete
	 */
	void deleteById(int id);
	/**
	 * get book by isbn
	 * @param isbn isbn of book
	 * @return {@link Book}
	 */
	Book getByIsbn(String isbn);
}
