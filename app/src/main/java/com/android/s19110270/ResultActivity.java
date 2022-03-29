package com.android.s19110270;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE = 1;
    private double tienLai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        double tienGui = Double.parseDouble(intent.getStringExtra("TIEN_GUI"));
        double laisuat = Double.parseDouble(intent.getStringExtra("LAI_SUAT")) ;
        double kyhan = Double.parseDouble(intent.getStringExtra("KY_HAN"));
        this.tienLai =  (tienGui*(laisuat/100)*(kyhan*30))/360;
        tienLai = Math.round(tienLai*100.0)/100.0;
        TextView tienLaiView = findViewById(R.id.tienlai);
        tienLaiView.setText(String.valueOf(tienLai) + " đ");
        TextView tongtienView = findViewById(R.id.tongtien);
        tongtienView.setText(String.valueOf(tienLai + tienGui)+ " đ");
    }
    public void takeAPicture(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        } catch (ActivityNotFoundException e) {
            // display error state to the user
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            finish();
        }
    }
}