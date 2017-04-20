package jp.sgk.jaxrs.sample.filter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

/**
 * JSONのレスポンスに UTF8 の charset を追加するフィルタ
 *
 * @author HANIYAMA
 *
 */
@Provider
public class UTF8Filter implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {

		if (responseContext != null) {
			MediaType contentType = responseContext.getMediaType();
			// see http://kamegu.hateblo.jp/entry/jaxrs/jersey-mvc-charset
			if (contentType != null) {
				if (contentType.equals(MediaType.APPLICATION_JSON_TYPE)) {
					responseContext.getHeaders().putSingle("Content-Type", new MediaType(contentType.getType(),
							contentType.getSubtype(), StandardCharsets.UTF_8.toString()));
				}
			}
		}

	}
}