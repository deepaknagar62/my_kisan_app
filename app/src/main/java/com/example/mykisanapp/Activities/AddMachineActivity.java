package com.example.mykisanapp.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.mykisanapp.Model.UserEntry;
import com.example.mykisanapp.Model.UserEntryApi;
import com.example.mykisanapp.R;
import com.example.mykisanapp.Retrofit.RetrofitService;
import com.example.mykisanapp.SharedPrefManager;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddMachineActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private static final int STORAGE_PERMISSION_CODE = 1;

    private EditText textid, textphone, textvillage, textabout, texttype, tprice;
    private ImageView imageView , buttonChooseImage;
    private Button buttonCreatePerson;
    private  Uri imageUri;
    private SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_machine);


        textphone = findViewById(R.id.editTextPhone2mm);
        textvillage = findViewById(R.id.editTextVillage2mm);
        textabout = findViewById(R.id.editTextAboutmm);
        tprice = findViewById(R.id.editTextPricemm);
        imageView = findViewById(R.id.imageView23);
        buttonChooseImage = findViewById(R.id.buttonChooseImage2);
        buttonCreatePerson = findViewById(R.id.buttonCreatePerson2mm);

        sharedPrefManager = new SharedPrefManager(AddMachineActivity.this);

        buttonChooseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isReadStorageAllowed()) {
                    openImagePicker();
                } else {
                    requestStoragePermission();
                }
            }
        });


        buttonCreatePerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPerson();
            }
        });

    }

    private void openImagePicker() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Image"), PICK_IMAGE_REQUEST);
    }

    private boolean isReadStorageAllowed() {
        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        return result == PackageManager.PERMISSION_GRANTED;
    }

    private void requestStoragePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            // Show an explanation to the user
            Toast.makeText(this, "Read permission is required to select an image", Toast.LENGTH_SHORT).show();
        }
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openImagePicker();
            } else {
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            imageUri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void createPerson() {
        String phonemm = textphone.getText().toString().trim();
        String villagemm = textvillage.getText().toString().trim();
        String about_sell = textabout.getText().toString().trim();
        String price = tprice.getText().toString().trim();
        String userId =  Integer.toString(sharedPrefManager.getUser().getUserId()) ;
        String type_crop = "machines";
        DateFormat dfrom = new SimpleDateFormat("dd/MM/yyyy");
        Date obj = new Date();
        String date = (dfrom.format(obj)).toString();


        if ( price.isEmpty() || userId.isEmpty() || type_crop.isEmpty()  || phonemm.isEmpty() || about_sell.isEmpty()  || villagemm.isEmpty() || imageUri == null) {
            Toast.makeText(this, "Please fill all the fields and select an image", Toast.LENGTH_SHORT).show();
            return;
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 70, baos);
        } catch (IOException e) {
            e.printStackTrace();
        }



        RequestBody requestFile = RequestBody.create(MediaType.parse("image/jpeg"), baos.toByteArray());
        MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", "image.jpg", requestFile);
        RequestBody phonePart = RequestBody.create(MediaType.parse("text/plain"), phonemm);
        RequestBody villagePart = RequestBody.create(MediaType.parse("text/plain"), villagemm);
        RequestBody aboutPart = RequestBody.create(MediaType.parse("text/plain"), about_sell);
        RequestBody typePart = RequestBody.create(MediaType.parse("text/plain"), type_crop);
        RequestBody pricePart = RequestBody.create(MediaType.parse("text/plain"), price);
        RequestBody datePart = RequestBody.create(MediaType.parse("text/plain"), date);
        RequestBody useridPart = RequestBody.create(MediaType.parse("text/plain"), userId);

        RetrofitService retrofitService = new RetrofitService();
        UserEntryApi userEntryApi = retrofitService.getRetrofit().create(UserEntryApi.class);

        Call<UserEntry> call = userEntryApi.saveUserData(phonePart, villagePart, filePart, typePart,pricePart,aboutPart,datePart,useridPart);
        call.enqueue(new Callback<UserEntry>() {
            @Override
            public void onResponse(Call<UserEntry> call, Response<UserEntry> response) {


                if(response.isSuccessful()){
                    Toast.makeText(AddMachineActivity.this, "Succefully Uploaded..", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(AddMachineActivity.this, "Failed to upload.." + response.code(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<UserEntry> call, Throwable t) {
                Toast.makeText(AddMachineActivity.this, "Submitted successfully..", Toast.LENGTH_SHORT).show();
            }
        });



    }


    }