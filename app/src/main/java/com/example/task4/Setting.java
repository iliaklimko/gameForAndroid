package com.example.task4;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Setting extends AppCompatActivity {

    private Button Addmove, reduce, buttonCreate, buttonSave, buttonStandart;
    private TextView textView;
    private int count = 3;
    private int move;
    private EditText editText;
    private String changeText;
    private LinearLayout linearLayout;
    private ArrayList<String> listEditTextId = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Addmove = findViewById(R.id.move);
        reduce = findViewById(R.id.reduce);
        buttonCreate = findViewById(R.id.buttonCreate);
        buttonSave = findViewById(R.id.buttonSave);
        textView = findViewById(R.id.textView);
        linearLayout = findViewById(R.id.layout_edit_text);
        ArrayList<String> oldSettings =  new MainActivity().getArrayList();

        if (oldSettings.size() != 0) {
            for (int i = 0; i < oldSettings.size(); i++) {
                final EditText editText = new EditText(Setting.this);
                LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                editText.setLayoutParams(p);
                final String str = (i + 1) + "";
                editText.setText(oldSettings.get(i));
                editText.setId(i + 1);
                linearLayout.addView(editText);
                listEditTextId.add(str);
                editText.setOnKeyListener(new View.OnKeyListener() {
                                              public boolean onKey(View v, int keyCode, KeyEvent event) {
                                                  if (event.getAction() == KeyEvent.ACTION_DOWN &&
                                                          (keyCode == KeyEvent.KEYCODE_ENTER)) {
                                                      int index = listEditTextId.indexOf(str);
                                                      listEditTextId.set(index, editText.getText().toString());
                                                      return true;
                                                  }
                                                  return false;
                                              }
                                          }
                );

            }
        }





        Addmove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                count += 2;

                textView.setText(String.valueOf(count));

            }
        });
        reduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count == 3){
                    reduce.setEnabled(true);
                }else {
                    count -= 2;

                    textView.setText(String.valueOf(count));
                }

            }
        });
        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                move = count;
                linearLayout.removeAllViews();
                listEditTextId = new ArrayList<>();
                ArrayList<String> arr = null;
                new MainActivity().setArrayList(arr);

                for (int i = 0; i < move; i++) {
                    final EditText editText = new EditText(Setting.this);
                    LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    editText.setLayoutParams(p);
                    final String str = (i + 1) + "";
                    editText.setText(str);
                    editText.setId(i + 1000);
                    linearLayout.addView(editText);
                    listEditTextId.add(str);
                    editText.setOnKeyListener(new View.OnKeyListener() {
                                                  public boolean onKey(View v, int keyCode, KeyEvent event) {
                                                      if (event.getAction() == KeyEvent.ACTION_DOWN &&
                                                              (keyCode == KeyEvent.KEYCODE_ENTER)) {
                                                          int index = listEditTextId.indexOf(str);
                                                          listEditTextId.set(index, editText.getText().toString());
                                                          return true;
                                                      }
                                                      return false;
                                                  }
                                              }
                    );

                }
            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> arr = null;
                new MainActivity().setArrayList(arr);
                new MainActivity().setArrayList(listEditTextId);
                Intent intent = new Intent(Setting.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
