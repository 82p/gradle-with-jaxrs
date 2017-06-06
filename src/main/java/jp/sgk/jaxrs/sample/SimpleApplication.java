package jp.sgk.jaxrs.sample;

import org.glassfish.jersey.moxy.internal.MoxyFilteringFeature;
import org.glassfish.jersey.server.ResourceConfig;

import jp.sgk.jaxrs.sample.filter.UTF8Filter;


/**
 *
 * Apiアプリケーションの設定クラス
 *
 * @author HANIYAMA
 *
 */
public class SimpleApplication extends ResourceConfig{
    /**
     * デフォルトコンストラクタ
     */
    public SimpleApplication() {
    	//読み込むAPIソースパッケージ
        packages("jp.sgk.jaxrs.sample.api");
        //JSON変換クラスの登録
        this.register(MoxyFilteringFeature.class);
        //this.register(JacksonFeature.class);
        //UTF8に変換するフィルターを登録
        this.register(UTF8Filter.class);
    }
}
