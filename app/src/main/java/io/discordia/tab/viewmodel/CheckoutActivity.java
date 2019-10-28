package io.discordia.tab.viewmodel;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import io.discordia.tab.R;
import sqip.CardEntry;

public class CheckoutActivity extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    sheetView.findViewById(R.id.addCardButton)
        .setOnClickListener((v)->CardEntry.startCardEntryActivity(CheckoutActivity.this);
  }


}
