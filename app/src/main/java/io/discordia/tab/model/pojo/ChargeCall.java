package io.discordia.tab.model.pojo;
/**
import android.util.Log;
import androidx.annotation.NonNull;
import io.discordia.tab.BuildConfig;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ChargeCall implements Call<ChargeResult> {

  private final ChargeCall.Factory factory;
  private final String nonce;
  private final retrofit2.Call<Void> call;

  private ChargeCall(ChargeCall.Factory factory, String nonce) {
    this.factory = factory;
    this.nonce = nonce;
    call = factory.service.charge(new UserService.ChargeRequest(nonce));
  }

  public static class Factory {

    private final UserService service;
    private final Converter<ResponseBody, ChargeErrorResponse> errorConverter;

    public Factory(Retrofit retrofit) {
      service = retrofit.create(UserService.class);
      Annotation[] noAnnotations = {};
      Type errorResponseType = UserService.ChargeErrorResponse.class;
      errorConverter = retrofit.responseBodyConverter(errorResponseType, noAnnotations);
    }

    public Call<ChargeResult> create(String nonce) {
      return new ChargeCall(this, nonce);
    }
  }


  @Override
  public Response<ChargeResult> execute() throws IOException {
    Response<Void> response;
    try {
      response = call.execute();
    } catch (IOException e) {
      return ChargeResult.networkError();
    }
    return responseToResult(response);
  }

  @Override
  public void enqueue(Callback<ChargeResult> callback) {
    call.enqueue(new Callback<Void>() {
      @Override
      public void onResponse(@NonNull retrofit2.Call<Void> call, @NonNull Response<Void> response) {
        callback.onResult(responseToResult(response));
      }
      /**@Override public void onFailure(@NonNull retrofit2.Call<Void> call, Throwable throwable){
      if (throwable.instanceOf IOException){
      callback.onResult(ChargeResult.networkError());
      }else{
      throw new RuntimeException("Unexpected exception", throwable);
      }
      }
      });
      }
       */
      /**private ChargeResult responseToResult(Response<Void> response){
       if (response.isSuccessful()){
       return ChargeResult.succss();
       }
       try{
       ResponseBody errorBody = response.errorBody();
       UserService.ChargeErrorResponse errorResponse = factory.errorConverter.convert(errorBody);
       return ChargeResult.error(errorResponse.errorMessage);
       }catch(IOException exception){
       if(BuildConfig.DEBUT){
       Log.d("ChargeCall", "Error while parsing error response: "+response.toString()), exception);
       }
       return ChargeResult.networkError();
       }
       }
       */
/**
      @Override
      public boolean isExecuted() {
        return call.isExecuted();
      }

      @Override
      public void cancel() {
        call.cancel();
      }

      @Override
      public boolean isCanceled() {
        return call.isCanceled();
      }

      @NonNull
      @Override
      public Call<ChargeResult> clone() {
        return factory.create(nonce);
      }

      @Override
      public Request request() {
        return null;
      }
    });
  }
}

*/