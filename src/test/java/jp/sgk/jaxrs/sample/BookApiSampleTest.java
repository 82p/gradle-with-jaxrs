package jp.sgk.jaxrs.sample;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.grizzly.GrizzlyTestContainerFactory;
import org.glassfish.jersey.test.spi.TestContainerFactory;
import org.junit.Assert;
import org.junit.Test;

import jp.sgk.jaxrs.sample.bean.Book;

public class BookApiSampleTest extends JerseyTest {

	public static List<Book> books = new ArrayList<Book>() {
		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		{
			add(new Book("数の悪魔", "978-4794964540", "晶文社"));
		}
	};

	@Override
	protected Application configure() {
		return new SimpleApplication();
	}

	@Override
	protected TestContainerFactory getTestContainerFactory() {
		return new GrizzlyTestContainerFactory();
	}

	@Test
	public void testGet() {
		WebTarget target = target("book/id/0");
		Book actual = target.request().get(Book.class);
		Book expected = books.get(0);
		Assert.assertEquals(expected, actual);
	}


	@Test
	public void テスト順番を気にするテストはダメって言うんで丸ごと書いちゃう() {

		//TODO 分離
		WebTarget target = target("book");
		Response serviceResponse = target.request(MediaType.APPLICATION_JSON).get(Response.class);
		List<Book> actual = serviceResponse.readEntity(new GenericType<List<Book>>() {});
		int index = 0;
		for (Book book : actual) {
			assertThat(book, is(books.get(index)));
			index++;
		}

		//TODO ここからPOSTテストなので分離したい
		String postdata = "{\r\n" + " \"name\":\"マッキンゼ―流 最高の社風の作り方\",\r\n" + " \"isbn\":\"978-4-8222-5166-6\",\r\n"
				+ " \"publisher\":\"日経BP社\"\r\n" + "}";

		// have to set charset! TODO dry!
		Entity<String> entity = Entity.entity(postdata, MediaType.APPLICATION_JSON_TYPE + "; charset=utf8");

		Response res = target.request(MediaType.APPLICATION_JSON).post(entity);
		assertThat("200 OK", res.getStatusInfo().getStatusCode(), is(200));
		assertThat("response", res.readEntity(String.class), is(
				"[{\"name\":\"数の悪魔\",\"isbn\":\"978-4794964540\",\"publisher\":\"晶文社\"},{\"name\":\"マッキンゼ―流 最高の社風の作り方\",\"isbn\":\"978-4-8222-5166-6\",\"publisher\":\"日経BP社\"}]"));

		 WebTarget deltarget = target("book/id/0");
		 Response res2 = deltarget.request().delete();

		 assertThat("200 OK", res2.getStatusInfo().getStatusCode(), is(200));
		 assertThat("response", res2.readEntity(String.class), is(
		 		"[{\"name\":\"マッキンゼ―流 最高の社風の作り方\",\"isbn\":\"978-4-8222-5166-6\",\"publisher\":\"日経BP社\"}]"));

	}
}
