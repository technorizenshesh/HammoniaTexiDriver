package com.teximobilitydriver.activity;

import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;

import com.teximobilitydriver.R;
import com.teximobilitydriver.databinding.ActivitySplashBinding;
import com.teximobilitydriver.helper.GPSTracker;
import com.utils.Session.SessionManager;

public class SplashAct extends AppCompatActivity {
   ActivitySplashBinding binding;
    public static int SPLASH_TIME_OUT = 3000;
    public static final int RequestPermissionCode = 1;
    GPSTracker gpsTracker;
    boolean isAccepted=false;
    private LocationManager locationManager;
    private SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        gpsTracker = new GPSTracker(this);
        session= SessionManager.get(this);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash);
        requestPermission();
    }
    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{
                android.Manifest.permission.ACCESS_COARSE_LOCATION,
                android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.READ_EXTERNAL_STORAGE,
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                android.Manifest.permission.CALL_PHONE
        }, RequestPermissionCode);

    }

    private void omHandler() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (session.isUserLogin()){
                    startActivity(new Intent(SplashAct.this, HomeAct.class));
                }else {
                    startActivity(new Intent(SplashAct.this, LoginAct.class));
                }
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        for (int i:grantResults){
            isAccepted=i==0;
            if (!isAccepted){
                break;
            }
        }
        if (isAccepted){
            omHandler();
            /*if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            }else {
                gpsTracker.showSettingsAlert();
            }*/
        }else {
            requestPermission();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}