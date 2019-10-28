package io.discordia.tab.model.pojo;

import android.content.res.Resources;
import androidx.annotation.NonNull;
import io.discordia.tab.service.ConfigHelper;
import retrofit2.Call;
import sqip.CardDetails;
import sqip.CardEntryActivityCommand;
import sqip.CardNonceBackgroundHandler;

/**
 * Calls backend service and processes the nonce while the payment form is still open
public class CardEntryBackgroundHandler implements CardNonceBackgroundHandler {
  private final ChargeCall.Factory chargeCallFactory;
  private final Resources resources;

  @NonNull
  @Override
  public CardEntryActivityCommand handleEnteredCardInBackground(@NonNull CardDetails cardDetails) {
    /**try{
      //TODO CALL BACKEND SERVICE
      //MyBackendServiceResponse response =
      if (response.isSuccessful()){
        return new CardEntryActivityCommand.Finish() {
        } else {
          return new CardEntryActivityCommand.ShowError(response.errorMessage);
        }
      }
    }catch(IOException exception){
      return new CardEntryActivityCommand.ShowError(
     resources.getString(R.string.network_failutre));
    }*/
/**
    if (!ConfigHelper.serverHostSet()){
      ConfigHelper.printCurlCommand(cardDetails.getNonce());
      return new CardEntryActivityCommand.Finish();
    }
    Call<ChargeResult> chargeCall = chargeCallFactory.create(cardDetails.getNonce());
    ChargeResult chargeResult = chargeCall.execute();

    if (chargeResult.success){
      return new CardEntryActivityCommand.Finish();
    }else if (chargeResult.networkError){
      return new CardEntryActivityCommand.ShowError("Sorry, there was an error in processing your payment. Please try again.");
    }else{
      return new CardEntryActivityCommand.ShowError(chargeResult.errorMessage);
    }
  }
  public CardEntryBackgroundHandler(ChargeCall.Factory chargeCallFactory, Resources resources){
    this.chargeCallFactory = chargeCallFactory;
    this.resources= resources;
  }
}
*/