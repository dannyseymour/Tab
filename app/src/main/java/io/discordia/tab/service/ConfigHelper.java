package io.discordia.tab.service;

import android.util.Log;
import java.util.UUID;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class ConfigHelper {
  public static final String GOOGLE_PAY_MERCHANT_ID = "0YAN9RJW28RV3";
  private static final String CHARGE_SERVER_HOST = "tabbackend.herokuapp.com";
  private static final String CHARGE_SERVER_URL = "https://" + CHARGE_SERVER_HOST + "/";

  public static boolean serverHostSet(){
    return !CHARGE_SERVER_HOST.equals("tabbackend.herokuapp.com");
  }
  public static boolean merchantIdSet(){
    return !GOOGLE_PAY_MERCHANT_ID.equals("");//TODO GET GOOGLE PAY MERCHANT
  }

  public static void printCurlCommand(String nonce){
    String uuid = UUID.randomUUID().toString();
    Log.i("Tab", "Run this curl command to charge the nonce\n"
    + "curl --request POST https://connect.squareupsandbox.com/v2/payments\\\n"//TODO get charge directory address
    + "--header\"Content-Type: application/json\"\\\n"
    +"--header \"Authorization: Bearer EAAAEPEZdwdc4WHryHOezpHh1ReFxN4-V90lIgTNX_udIou61dg_GNPHz9SkY2kV\"\\\n"
    +"--header \"Accept: application/json\" \\\n"
    +"--data \'{\n"
        +"\"idempotency_key\": \"" + uuid+ "\",\n"
        +"\"amount_money\": {\n"
        +"\"amount\":100,\n"
        +"\"currency\": \"USD\"},\n"
        +"\"source_id\": \"" +nonce+ "\""
        +"}\'");
  }

  public static Retrofit createRetrofitInstance(){
    return new Retrofit.Builder()
        .baseUrl(ConfigHelper.CHARGE_SERVER_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build();
  }
}
