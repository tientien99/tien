package com.example.logindemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class ForgotPassword extends AppCompatActivity {

    private Button buttonConfirm;
    private EditText editTextUser;
    private EditText editTextPhone;
    private EditText editTextEmail;
    private MyDataBase myDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        buttonConfirm = findViewById(R.id.buttonConfirm);
        editTextUser = findViewById(R.id.edtForgotUser);
        editTextEmail = findViewById(R.id.edtForEmail);
        editTextPhone = findViewById(R.id.edtForPhone);
        confirm();
    }

    public void confirm() {
        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkUser()) {
                    Intent intent = new Intent(ForgotPassword.this, ChangePassword.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("user_name", editTextUser.getText().toString());
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Thông tin không đúng", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean checkUser() {
        String user = editTextUser.getText().toString().trim();
        String phone = editTextPhone.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();

        myDataBase = Room.databaseBuilder(getApplicationContext(), MyDataBase.class, "project.db").allowMainThreadQueries().build();
        UserDAO userDAO = myDataBase.createUserDAO();
        List<User> lstUser = userDAO.getAllUser();
        for (User u : lstUser) {
            if (u.getUsername().equals(user) && u.getEmail().equals(email) && u.getPhone().equals(phone)) {
                return true;
            }
        }
        return false;
    }
}