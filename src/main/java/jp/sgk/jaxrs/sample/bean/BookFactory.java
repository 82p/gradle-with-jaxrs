package jp.sgk.jaxrs.sample.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 *
 * Book BEANファクトリークラス
 *
 * @author HANIYAMA
 *
 */
public class BookFactory {
	private static BookFactory instance = null;

	private List<Book> booklist;

	private BookFactory() {
		this.booklist = new ArrayList<>();
		booklist.add(new Book("数の悪魔", "978-4794964540", "晶文社"));
	}

	public static BookFactory getInstance() {
		if(instance == null){
			instance = new BookFactory();
		}
		return instance;
	}

	public Book getById(int id) {
		if (booklist.size() > id) {
			return booklist.get(id);
		}
		return null;
	}

	public List<Book> findBookByName(String name){
		Pattern p = Pattern.compile(name);
		return booklist.stream()
				.filter(book-> p.matcher(book.getName()).find())
				.collect(Collectors.toList());
	}

	public void addBook(Book book){
		booklist.add(book);
	}

	public List<Book> getList() {
		return this.booklist;
	}
}
