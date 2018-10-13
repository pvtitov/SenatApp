package ru.github.pvtitov.senatapp.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.github.pvtitov.senatapp.http_service.AddCookiesInterceptor;
import ru.github.pvtitov.senatapp.http_service.HttpClientRetrofitImpl;
import ru.github.pvtitov.senatapp.http_service.LoginService;
import ru.github.pvtitov.senatapp.http_service.MainService;
import ru.github.pvtitov.senatapp.http_service.ReceivedCookiesInterceptor;

@Module
public class NetworkModule {

    private String baseUrl;

    public NetworkModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Provides
    @Singleton
    public HttpClientRetrofitImpl provideHttpClient() {
        return new HttpClientRetrofitImpl();
    }

    @Provides
    @Singleton
    public LoginService provideLoginService(ReceivedCookiesInterceptor interceptor) {

        return createRetrofit(interceptor).create(LoginService.class);
    }

    @Provides
    @Singleton
    public MainService provideMainService(AddCookiesInterceptor interceptor) {

        return createRetrofit(interceptor).create(MainService.class);
    }

    @Provides
    @Singleton
    public Retrofit provideMainRetrofit(AddCookiesInterceptor interceptor) {
        return createRetrofit(interceptor);
    }

    private Retrofit createRetrofit(Interceptor interceptor) {

        OkHttpClient client = createOkHttpClient(interceptor);
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private OkHttpClient createOkHttpClient(Interceptor interceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
    }


    @Provides
    @Singleton
    public AddCookiesInterceptor provideAddCookiesInterceptor() {
        return new AddCookiesInterceptor();
    }

    @Provides
    @Singleton
    public ReceivedCookiesInterceptor provideReceivedCookiesInterceptor() {
        return new ReceivedCookiesInterceptor();
    }
}
