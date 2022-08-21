package com.example.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;

import java.util.List;

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
        switchIsActive = findViewById(R.id.enroll);
        listViewStudent = findViewById(R.id.listView);

        AddButton.setOnClickListener(new View.OnClickListener() {
            StudentModel studentModel;
            @Override
            public void onClick(View view) {
                try{
                    String en = switchIsActive.isChecked() ? "Enrolled" : "Not Enrolled";
                    studentModel = new StudentModel(editName.getText().toString(),editRollNo.getText().toString(),en);
                    Log.d("ok","run");
                }catch (Exception e){
                    Log.d("error","not run");
                }
                DBHelper dbHelper  = new DBHelper(MainActivity.this);
                dbHelper.addStudent(studentModel);
            }
        });

        ViewAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbHelper = new DBHelper(MainActivity.this);
                List<StudentModel> list = dbHelper.getAllStudents();
                ArrayAdapter arrayAdapter = new ArrayAdapter<StudentModel>
                        (MainActivity.this, android.R.layout.simple_list_item_1,list);
                listViewStudent.setAdapter(arrayAdapter);
            }
        });
        listViewStudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,DeleteOrEditActivity.class);
                StudentModel s = (StudentModel)listViewStudent.getItemAtPosition(i);
                intent.putExtra("name",s.getName());
                intent.putExtra("rollno",s.getRollNo());
                intent.putExtra("enrolled",s.isEnroll());
                String id = Integer.toString(s.getID());
                Log.i("id",id);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });

    }
}