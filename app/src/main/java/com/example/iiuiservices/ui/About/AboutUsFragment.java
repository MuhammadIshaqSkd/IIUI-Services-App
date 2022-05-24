package com.example.iiuiservices.ui.About;

import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.ViewModelProvider;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.iiuiservices.R;
import com.example.iiuiservices.databinding.AboutUsFragmentBinding;
import com.example.iiuiservices.databinding.FragmentHomeBinding;
import com.example.iiuiservices.ui.home.HomeViewModel;

public class AboutUsFragment extends Fragment {

    private AboutUsFragmentBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        AboutUsViewModel aboutUsViewModel = new ViewModelProvider(this).get(AboutUsViewModel.class);

        binding = AboutUsFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;

    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}