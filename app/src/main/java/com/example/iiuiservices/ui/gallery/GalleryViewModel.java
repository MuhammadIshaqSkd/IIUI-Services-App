package com.example.iiuiservices.ui.gallery;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.iiuiservices.ui.home.HomeViewModel;

public class GalleryViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GalleryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Abouts fragment");



    }


    public LiveData<String> getText() {
        return mText;
    }
}