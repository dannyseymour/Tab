package io.discordia.tab.viewmodel;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import io.discordia.tab.R;

public class EmptyActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_empty);
  }
}
