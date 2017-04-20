package jp.sgk.jaxrs.sample.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * 本のBeanクラス
 *
 * @author HANIYAMA
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Book {
	private String name;
	private String isbn;
	private String publisher;

	public Book(String name, String isbn, String publicsher) {
		this.name = name;
		this.isbn = isbn;
		this.publisher = publicsher;
	}
	public Book(){

	}
	/**
	 * nameを取得します。
	 *
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * nameを設定します。
	 *
	 * @param name
	 *            name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * isbnを取得します。
	 *
	 * @return isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * isbnを設定します。
	 *
	 * @param isbn
	 *            isbn
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * publisherを取得します。
	 *
	 * @return publisher
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * publisherを設定します。
	 *
	 * @param publisher
	 *            publisher
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	/* (非 Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
		return result;
	}
	/* (非 Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		return true;
	}
}
