package com.zubairmuddasir12fyp.work_at_home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import com.google.firebase.auth.FacebookAuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 4000;
    public static final String SHARED_PREFS ="sharedPrefs";
    public static  final String TEXT="text";
 String value ;
 FirebaseAuth auth;
    FirebaseUser firebaseUser;
    FacebookAuthCredential user;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth=FirebaseAuth.getInstance();
        firebaseUser = auth.getCurrentUser();
tv=findViewById(R.id.tgh);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (firebaseUser != null ) {
                    if(firebaseUser.isAnonymous()){
                        guests();
                    }else {
                        loggs();
                    }
                } else if (user != null){
                   loggs();
                }else {
                    els();
                }
            }
        }, SPLASH_TIME_OUT);
        }

public void loggs(){
    SharedPreferences sharedPreferences = getSharedPreferences("beta",MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putString("alpha",tv.getText().toString());
    editor.apply();
    startActivity(new Intent(MainActivity.this, HomeActivity2.class));
    Animatoo.animateZoom(this);
    finish();
    }
    public void guests(){
        startActivity(new Intent(MainActivity.this, Guest_Home.class));
        Animatoo.animateZoom(this);
        finish();

    }

public void els() {
    SharedPreferences sharedPreferences = getSharedPreferences("DATA",MODE_PRIVATE);
    value = sharedPreferences.getString("key","LOL");

    if(value=="LOL") {
        startActivity(new Intent(MainActivity.this, Main2Activity.class));
        finish();
        Animatoo.animateFade(this);
    }else {
        startActivity(new Intent(MainActivity.this, Guest_Home.class));
        Animatoo.animateFade(this);

    }
}
}

