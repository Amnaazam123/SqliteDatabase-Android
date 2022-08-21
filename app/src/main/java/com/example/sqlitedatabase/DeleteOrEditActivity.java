package com.example.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class DeleteOrEditActivity extends AppCompatActivity {

    Button editBtn, delBtn, backBtn;
    EditText editName,editRollNo;
    Switch s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_or_edit);

        editBtn = findViewById(R.id.edit);
        delBtn = findViewById(R.id.delete);
        backBtn = findViewById(R.id.back);
        
        editName = findViewById(R.id.studentName);
        editRollNo = findViewById(R.id.studentRollNo);
         s = findViewById(R.id.enroll);
        Intent intent = getIntent();
        editName.setText(intent.getStringExtra("name"));
        editRollNo.setText(intent.getStringExtra("rollno"));
        String en = (intent.getStringExtra("enrolled"));
        String id = intent.getStringExtra("id");
        if(en=="Enrolled"){
            s.setChecked(true);
        }
        else{
            s.setChecked(false);
        }



        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = intent.getStringExtra("id");
                //int r = Integer.parseInt(intent.getStringExtra("rollNumber"));
                DBHelper dbHelper = new DBHelper(DeleteOrEditActivity.this);

                dbHelper.deleteStudent(Integer.parseInt(id));
                Toast t = Toast.makeText(DeleteOrEditActivity.this,"Record Deleted",Toast.LENGTH_SHORT);
                Intent back = new Intent(DeleteOrEditActivity.this, MainActivity.class);
                t.show();
                startActivity(back);
            }
        });

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper db = new DBHelper(DeleteOrEditActivity.this);
                String en = s.isChecked() ? "Enrolled" : "Not Enrolled";
                StudentModel s = new StudentModel(editName.getText().toString(),
                        editRollNo.getText().toString()
                        ,en);
                s.setID(Integer.parseInt(id));
                db.updateStudent(s);
                Toast t = Toast.makeText(DeleteOrEditActivity.this,"Record updated",Toast.LENGTH_SHORT);
                Intent back = new Intent(DeleteOrEditActivity.this, MainActivity.class);
                t.show();
                startActivity(back);

            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(DeleteOrEditActivity.this, MainActivity.class);
                startActivity(back);
            }
        });


    }


}