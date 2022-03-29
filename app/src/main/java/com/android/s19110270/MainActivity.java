package com.android.s19110270;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText soTienGui;
    private EditText laiSuatGui;
    private EditText kyHanGui;
    public static final int TEXT_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        soTienGui = findViewById(R.id.tiengoi);
        laiSuatGui = findViewById(R.id.laisuat);
        kyHanGui = findViewById(R.id.kyhan);
    }
    public void getResult(View view){
        if (soTienGui.getText().toString().length() == 0 ||laiSuatGui.getText().toString().length() == 0 ||
                kyHanGui.getText().toString().length() == 0){
            Toast.makeText(this, "All textbox is required", Toast.LENGTH_SHORT).show();
        }
        else {
            String tienGui = soTienGui.getText().toString();
            String laiSuat = laiSuatGui.getText().toString();
            String kyHan = kyHanGui.getText().toString();
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("TIEN_GUI", tienGui);
            intent.putExtra("LAI_SUAT", laiSuat);
            intent.putExtra("KY_HAN", kyHan);
            startActivityForResult(intent,TEXT_REQUEST);
        }

    }
}