package com.example.logindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ActivityRegister extends AppCompatActivity {

    final Calendar myCalender = Calendar.getInstance();
    private EditText edtDOB;

    public void updateLabel() {
        String myFormat = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.CHINA);
        edtDOB.setText(sdf.format(myCalender.getTime()));
    }

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            myCalender.set(Calendar.YEAR, year);
            myCalender.set(Calendar.MONTH, month);
            myCalender.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edtDOB = findViewById(R.id.edtInputDOB);
        edtDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(ActivityRegister.this
                        , date
                        , myCalender.get(Calendar.YEAR)
                        , myCalender.get(Calendar.MONTH)
                        , myCalender.get(Calendar.DAY_OF_MONTH)).show();

                String dateString = edtDOB.getText().toString();
                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                df.setLenient(false); // set false để kiểm tra tính hợp lệ của date. VD: tháng 2 phải có 28-29 ngày, năm có 12 tháng,....
                try {
                    df.parse(dateString); // parse dateString thành kiểu Date
                    edtDOB.setText(dateString);
                } catch (ParseException e) { // quăng lỗi nếu dateString ko hợp lệ
                    System.out.println("Invalid date");
                    edtDOB.setText("");
                }
            }
        });
    }

}