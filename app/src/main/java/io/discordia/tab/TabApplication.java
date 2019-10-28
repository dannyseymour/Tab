package io.discordia.tab;

import android.app.Activity;
import android.app.Application;
import io.discordia.tab.model.pojo.CardEntryBackgroundHandler;
import io.discordia.tab.model.pojo.ChargeCall;
import io.discordia.tab.model.pojo.GooglePayChargeClient;
import io.discordia.tab.service.ConfigHelper;
import retrofit2.Retrofit;
import sqip.CardEntry;

public class TabApplication extends Application {

  public static GooglePayChargeClient createGooglePayChargeClient(Activity activity){
    TabApplication application = (TabApplication) activity.getApplication();
    return new GooglePayChargeClient(application.chargeCallFactory);
  }

  private ChargeCall.Factory chargeCallFactory;

  @Override
  public void onCreate() {
    super.onCreate();

    Retrofit retrofit = ConfigHelper.createRetrofitInstance();
    chargeCallFactory = new ChargeCall.Factory(retrofit);

    CardEntryBackgroundHandler cardHandler =
        new CardEntryBackgroundHandler(chargeCallFactory, getResources());
    CardEntry.setCardNonceBackgroundHandler(cardHandler);
  }
}
