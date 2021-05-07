package com.example.bottomactivity.ui.dashboard;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.bottomactivity.R;

import java.io.Console;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
                //Toast.makeText(getContext(),"texto en cambio dentro de onChanged", Toast.LENGTH_SHORT ).show();
            }

        });


        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(getContext(),"texto onStart", Toast.LENGTH_SHORT ).show();
       // Log.i("mensaje","Hola");
    }


    @Override
    public void onInflate(@NonNull Context context, @NonNull AttributeSet attrs, @Nullable Bundle savedInstanceState) {
        super.onInflate(context, attrs, savedInstanceState);
        Toast.makeText(getContext(),"texto onInflate", Toast.LENGTH_SHORT ).show();
    }

    public void enviarMensaje(String msg){
        Toast toast = new Toast(getActivity());
        toast.setText("HOLa");
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
    }
}