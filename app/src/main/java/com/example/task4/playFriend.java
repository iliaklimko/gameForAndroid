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
import java.util.ArrayList;
import java.util.Random;

public class playFriend extends AppCompatActivity {

    private Button start, one, two, three, newGame, exit;
    private TextView selectDigit, result, you, computer, resultYou, resultComputer, resultPlay, hmac, key;
    private LinearLayout buttonsLayout;
    private int myNumber = 0;
    private String myNumberString = "";
    private String friendNumberString = "";
    private int friendNumber = 0;
    private int countMove;
    private final String DRAW = "Ничья";
    private final String WINUSER = "Вы победили";
    private final String WINCOMPUTER = "Победил друг";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_friend);
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


                start.setEnabled(false);
                buttonsLayout.setEnabled(true);
                for (int i = 0; i < listEditTextId.size(); i++) {
                    if (listEditTextId.size() == 3) {
                        final Button button = new Button(playFriend.this);
                        if (i == 0) {
                            button.setBackgroundResource(R.drawable.stone);
                            button.setText("Камень");
                        } else if (i == 1) {
                            button.setBackgroundResource(R.drawable.knife);
                            button.setText("Ножницы");
                        } else if (i == 2) {
                            button.setBackgroundResource(R.drawable.paper);
                            button.setText("Бумага");

                        }
                        button.setId(i + 1);
                        button.setLayoutParams(new LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT));
                        buttonsLayout.addView(button);

                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                ++countMove;
                                if (myNumber == 0) {
                                    myNumber = button.getId();
                                    myNumberString = (String) button.getText();
                                } else {
                                    friendNumber = button.getId();
                                    friendNumberString = (String) button.getText();

                                }
                                if (countMove == 2) {
                                    countMove = 0;

                                    resultYou.setText(myNumberString + "");
                                    resultComputer.setText(friendNumberString + "");
                                    int summ = count / 2;
                                    if (myNumber == friendNumber) {
                                        resultPlay.setText(DRAW);
                                    } else {
                                        if ((myNumber < friendNumber) && (myNumber + summ >= friendNumber)) {
                                            resultPlay.setText(WINUSER);
                                        } else if ((friendNumber < myNumber) && (friendNumber + summ >= myNumber)) {
                                            resultPlay.setText(WINCOMPUTER);
                                        } else if (myNumber < friendNumber) {
                                            resultPlay.setText(WINCOMPUTER);
                                        } else {
                                            resultPlay.setText(WINUSER);
                                        }

                                    }

                                    buttonsLayout.setVisibility(View.INVISIBLE);
                                    newGame.setEnabled(true);
                                }
                            }
                        });

                    } else {
                        final Button button = new Button(playFriend.this);
                        button.setText((String) listEditTextId.get(i));
                        button.setId(i + 1);
                        button.setLayoutParams(new LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT));
                        buttonsLayout.addView(button);

                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                ++countMove;
                                if (myNumber == 0) {
                                    myNumber = button.getId();
                                    myNumberString = (String) button.getText();
                                } else {
                                    friendNumber = button.getId();
                                    friendNumberString = (String) button.getText();

                                }
                                if (countMove == 2) {
                                    countMove = 0;

                                    resultYou.setText(myNumberString + "");
                                    resultComputer.setText(friendNumberString + "");
                                    int summ = count / 2;
                                    if (myNumber == friendNumber) {
                                        resultPlay.setText(DRAW);
                                    } else {
                                        if ((myNumber < friendNumber) && (myNumber + summ >= friendNumber)) {
                                            resultPlay.setText(WINUSER);
                                        } else if ((friendNumber < myNumber) && (friendNumber + summ >= myNumber)) {
                                            resultPlay.setText(WINCOMPUTER);
                                        } else if (myNumber < friendNumber) {
                                            resultPlay.setText(WINCOMPUTER);
                                        } else {
                                            resultPlay.setText(WINUSER);
                                        }

                                    }

                                    buttonsLayout.setVisibility(View.INVISIBLE);
                                    newGame.setEnabled(true);
                                }
                            }
                        });

                    }

                }
            }
        });

        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start.setEnabled(false);
                ArrayList<String> listEditTextId = new MainActivity().getArrayList();
                int count = listEditTextId.size();
                myNumberString = "";
                friendNumberString = "";
                friendNumber = 0;
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
                Intent intent = new Intent(playFriend.this, MainActivity.class);
                startActivity(intent);
                start.setEnabled(true);
                friendNumber = 0;
                myNumber = 0;
                resultPlay.setText("");
                newGame.setEnabled(false);


            }
        });

    }
}
