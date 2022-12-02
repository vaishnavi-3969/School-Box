package com.myschool.myschoolbox.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {
    CardView uploadNotice, uploadImage, addEBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        uploadNotice =(CardView) findViewById(R.id.addNotice);
        uploadNotice.setOnClickListener(this);
        uploadImage = (CardView) findViewById(R.id.uploadImage);
        uploadImage.setOnClickListener(this);
        addEBook =(CardView) findViewById(R.id.uploadEbook);
        addEBook.setOnClickListener(this);

    }

    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            case R.id.addNotice:
                intent = new Intent(ThirdActivity.this, UploadNotice.class);
                startActivity(intent);
                break;
            case R.id.uploadImage:
                intent = new Intent( ThirdActivity.this, UploadImage.class);
                startActivity(intent);
                break;
            case R.id.uploadEbook:
                intent = new Intent( ThirdActivity.this, UploadPdfActivity.class);
                startActivity(intent);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }
}
