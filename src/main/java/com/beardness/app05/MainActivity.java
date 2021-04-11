package com.beardness.app05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
  
  Intent intent;
  
  EditText theme, message;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }
  
  public void sendMessage(View view) {
    theme = findViewById(R.id.line_one);
    message = findViewById(R.id.line_two);
    
    intent = new Intent(Intent.ACTION_SEND);
    intent.setType("text/plain");
    
    intent.putExtra(Intent.EXTRA_SUBJECT, getStringFromET(theme));
    intent.putExtra(Intent.EXTRA_TEXT, getStringFromET(message));
    
    startActivity(Intent.createChooser(intent, "Choose..."));
  }
  
  private String getStringFromET(EditText et) {
    return et.getText().toString();
  }
}