package io.discordia.tab.service;

import android.app.Activity;
import io.discordia.tab.TabApplication;
/**import io.discordia.tab.model.pojo.ChargeCall;
import io.discordia.tab.model.pojo.ChargeCall.Factory;

public class GooglePayChargeClient {
  private final ChargeCall.Factory chargeCallFactory;

  public GooglePayChargeClient(Factory chargeCallFactory) {
    this.chargeCallFactory = chargeCallFactory;
  }


  public static GooglePayChargeClient createGooglePayChargeClient(Activity activity) {
    TabApplication application = (TabApplication) activity.getApplication();
    return new GooglePayChargeClient(application.getChargeCallFactory());
  }
}
 */