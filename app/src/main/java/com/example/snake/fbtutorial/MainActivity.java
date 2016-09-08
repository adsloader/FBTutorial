package com.example.snake.fbtutorial;

/*
*    Tutorial 따라하기
*    https://www.firebase.com/docs/android/quickstart.html
* */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    Firebase myFirebaseRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setUpUi();
    }

    private void setUpUi() {
        Firebase.setAndroidContext(this);

        // 내 주소를 저장한다.
        myFirebaseRef = new Firebase("https://testandroid-d79e4.firebaseio.com/");
        myFirebaseRef.child("message").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                System.out.println(snapshot.getValue());  //prints "Do you have data? You'll love Firebase."
            }
            @Override public void onCancelled(FirebaseError error) { }
        });
        myFirebaseRef.child("message").setValue("Do you have data? You'll love Firebase.");

    }
}
