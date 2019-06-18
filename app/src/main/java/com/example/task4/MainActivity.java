package com.example.task4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button play, settings,playFriend;
    private static ArrayList<String> listEditTextId = new ArrayList<>();

    public ArrayList<String> getArrayList() {
        return listEditTextId;
    }

    public void setArrayList(ArrayList<String> listEditTextId) {
        this.listEditTextId = listEditTextId;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play =  findViewById(R.id.play);
        settings =  findViewById(R.id.settings);
        playFriend = findViewById(R.id.playFriend);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(".PlayField");
                startActivity(intent);
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(".Setting");
                startActivity(intent);
            }
        });
        playFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(".playFriend");
                startActivity(intent);
            }
        });

    }


}