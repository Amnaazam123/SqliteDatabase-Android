package com.example.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    Button AddButton, ViewAllButton;
    EditText editName, editRollNo;
    Switch switchIsActive;
    ListView listViewStudent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AddButton = findViewById(R.id.button3);
        ViewAllButton = findViewById((R.id.button4));
        editName = findViewById(R.id.editTextTextPersonName3);
        editRollNo = findViewById(R.id.editTextNumber);
        switchIsActive = findViewById(R.id.switch1);
        listViewStudent = findViewById(R.id.listView);

        AddButton.setOnClickListener(new View.OnClickListener() {
            StudentModel studentModel;
            @Override
            public void onClick(View view) {
                try{
                    studentModel = new StudentModel(editName.getText().toString(),Integer.parseInt(editRollNo.getText().toString()),switchIsActive.isChecked());
                    Log.d("ok","run");
                }catch (Exception e){
                    Log.d("error","not run");
                }
            }
        });

        ViewAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });

    }
}