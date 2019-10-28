package io.discordia.tab.service;

import io.discordia.tab.BuildConfig;
import io.discordia.tab.service.AccountService.InstanceHolder;
import io.reactivex.Single;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TransactionService {

  @GET("api/deck/new/shuffle/")
  Single<Shoe> newShoe(@Query("deck_count") int count);

  @GET("api/deck/{shoeKey}/draw/")
  Single<Draw> draw(@Path("shoeKey") String shoeKey,
      @Query("count") int count); //TODO Specify type parameter

  @GET("api/deck/{shoeKey}/shuffle/")
  Single<Shoe> shuffle(@Path("shoeKey") String shoeKey);


  static String getImageUrl(Card card) {
    String baseUrl = BuildConfig.BASE_URL;
    String imagePattern = BuildConfig.STATIC_IMAGE_PATTERN;
    String abbreviation = card.getAbbreviation();
    return String.format(imagePattern, baseUrl, abbreviation);
  }

  static io.discordia.tab.service.AccountService getInstance() {
    return io.discordia.tab.service.AccountService.InstanceHolder.INSTANCE;
  }

  class InstanceHolder {

    private static final io.discordia.tab.service.AccountService INSTANCE;

    static {
      HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
      interceptor.setLevel(Level.BODY);
      OkHttpClient client = new OkHttpClient.Builder()
          .addInterceptor(interceptor)
          .build();
      Retrofit retrofit = new Retrofit.Builder()
          .baseUrl(BuildConfig.BASE_URL)
          .client(client)
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .addConverterFactory(GsonConverterFactory.create())
          .build();
      INSTANCE = retrofit.create(io.discordia.tab.service.AccountService.class);
    }

  }

}

