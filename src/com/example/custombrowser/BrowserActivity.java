package com.example.custombrowser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class BrowserActivity extends Activity {
  private Button button;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    final Context context = this;
    
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_browser);

    button = (Button) findViewById(R.id.buttonUrl);

    button.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View arg0) {
        Intent intent = new Intent(context, WebViewActivity.class);
        startActivity(intent);
      }

    });
  }
  

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.browser, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();
    if (id == R.id.action_settings) {
      return true;
    }
    return super.onOptionsItemSelected(item);
  }
}
