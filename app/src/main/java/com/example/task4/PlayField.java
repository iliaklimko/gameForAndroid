package com.example.task4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

public class PlayField extends AppCompatActivity {
    private Button start, one, two, three, newGame, exit;
    private TextView selectDigit, result, you, computer, resultYou, resultComputer, resultPlay,hmac,key;
    private LinearLayout buttonsLayout;
    private int myNumber;
    private int computerNumber;
    private final String DRAW = "Ничья";
    private final String WINUSER = "Вы победили";
    private final String WINCOMPUTER = "Победил компьютер";



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_field);
        start = findViewById(R.id.ButtonStart);
        buttonsLayout = findViewById(R.id.buttonsLayout);
        buttonsLayout.setEnabled(false);
        newGame = findViewById(R.id.buttonNewGame);
        newGame.setEnabled(false);
        exit = findViewById(R.id.buttonExit);
        selectDigit = findViewById(R.id.SelectDigit);
        result = findViewById(R.id.result);
        computer = findViewById(R.id.computer);
        resultYou = findViewById(R.id.resultYou);
        resultComputer = findViewById(R.id.resultComputer);
        resultPlay = findViewById(R.id.resultPlay);
        you = findViewById(R.id.you);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> listEditTextId = new MainActivity().getArrayList();
                final int count = listEditTextId.size();


                computerNumber = new Random().nextInt(count) + 1;
                start.setEnabled(false);
                buttonsLayout.setEnabled(true);
                for (int i = 0; i < listEditTextId.size(); i++) {
                    final Button button = new Button(PlayField.this);
                    button.setText((String)listEditTextId.get(i));
                    button.setId(i + 1);
                    button.setLayoutParams(new LinearLayout.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT));
                    buttonsLayout.addView(button);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            myNumber = button.getId();
                            resultYou.setText(button.getText() + "");
                            resultComputer.setText(computerNumber + "");
                            int summ = count/2;
                            if (myNumber == computerNumber) {
                                resultPlay.setText(DRAW);
                            } else {
                                if((myNumber < computerNumber) && (myNumber + summ >= computerNumber)){
                                    resultPlay.setText(WINUSER );
                                }  else if((computerNumber < myNumber) && (computerNumber + summ >= myNumber)){
                                    resultPlay.setText(WINCOMPUTER);
                                } else if(myNumber<computerNumber) {
                                    resultPlay.setText(WINCOMPUTER);
                                }


                                else {
                                    resultPlay.setText(WINUSER);
                                }

                            }

                            buttonsLayout.setVisibility(View.INVISIBLE);
                            newGame.setEnabled(true);
                        }
                    });
                }
            }
        });

        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start.setEnabled(false);
                ArrayList<String> listEditTextId = new MainActivity().getArrayList();
                int count = listEditTextId.size();
                computerNumber = new Random().nextInt(count) + 1;
                myNumber = 0;
                resultYou.setText("");
                resultComputer.setText("");
                resultPlay.setText("");
                buttonsLayout.setVisibility(View.VISIBLE);
                newGame.setEnabled(false);
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlayField.this, MainActivity.class);
                startActivity(intent);
                start.setEnabled(true);
                computerNumber = 0;
                myNumber = 0;
                resultPlay.setText("");
                newGame.setEnabled(false);


            }
        });

    }


}
