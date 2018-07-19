package com.loveplusplus.update.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.loveplusplus.update.AppUtils;
import com.loveplusplus.update.UpdateChecker;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = (Button) findViewById(R.id.button1);
        Button btn2 = (Button) findViewById(R.id.button2);
        // You would use you own constants / url here and not the default url
        final String url = "https://raw.githubusercontent.com/rickpage/android-auto-update/master/extras/update.json";
        btn1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                UpdateChecker.checkForDialog(MainActivity.this, url);
            }
        });
        btn2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                UpdateChecker.checkForNotification(MainActivity.this, url);
            }
        });


        TextView textView = (TextView) findViewById(R.id.textView1);

        textView.setText("当前版本信息: versionName = " + AppUtils.getVersionName(this) + " versionCode = " + AppUtils.getVersionCode(this));
    }

}
