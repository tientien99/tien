package com.example.logindemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePassword extends AppCompatActivity {

    private EditText editTextNewPass;
    private EditText editTextConfirmNewPass;
    private Button buttonChange;
    private MyDataBase myDataBase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        editTextConfirmNewPass = findViewById(R.id.edtConfirmNewPass);
        editTextNewPass = findViewById(R.id.edtNewPass);
        buttonChange = findViewById(R.id.buttonChange);
        change();
    }

    public void change() {
        buttonChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newPass = editTextNewPass.getText().toString().trim();
                String confirmPass = editTextConfirmNewPass.getText().toString().trim();
                myDataBase = Room.databaseBuilder(getApplicationContext(), MyDataBase.class, "project.db").allowMainThreadQueries().build();
                UserDAO userDAO = myDataBase.createUserDAO();
                if (confirmPass.equals(newPass)) {
                    Intent intent1 = getIntent();
                    Bundle bundle = intent1.getExtras();
                    if (bundle != null) {
                        String userName = (String) bundle.get("user_name");
                        User user = userDAO.findUserByName(userName);
                        Toast.makeText(getApplicationContext(), "Thay đổi thành công", Toast.LENGTH_SHORT).show();
                        user.setPassword(confirmPass);
                        userDAO.update(user);
                        Intent intent = new Intent(ChangePassword.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Lỗi", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "Xác nhận mật khẩu không đúng", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}