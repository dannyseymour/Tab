package io.discordia.tab;

import android.app.Activity;
import android.app.Application;
import com.facebook.stetho.Stetho;
import com.squareup.picasso.Picasso;
//import io.discordia.tab.model.pojo.CardEntryBackgroundHandler;
import io.discordia.tab.service.ConfigHelper;
import io.discordia.tab.service.GoogleSignInService;
import io.discordia.tab.service.TabDatabase;
import retrofit2.Retrofit;
import sqip.CardEntry;

public class TabApplication extends Application {



  @Override
  public void onCreate() {
    super.onCreate();
    GoogleSignInService.setApplicationContext(this);
    Stetho.initializeWithDefaults(this);
    TabDatabase.setApplicationContext(this);
    final TabDatabase database = TabDatabase.getInstance();
    new Thread(() -> database.getUserDao().delete()).start();
   /**
    Retrofit retrofit = ConfigHelper.createRetrofitInstance();
    chargeCallFactory = new ChargeCall.Factory(retrofit);
    CardEntryBackgroundHandler cardHandler =
        new CardEntryBackgroundHandler(chargeCallFactory, getResources());
    CardEntry.setCardNonceBackgroundHandler(cardHandler);
  }

  private ChargeCall.Factory chargeCallFactory;

  public Factory getChargeCallFactory() {
    return chargeCallFactory;
  }

  public void setChargeCallFactory(Factory chargeCallFactory) {
    this.chargeCallFactory = chargeCallFactory;
  }
    */
}
}