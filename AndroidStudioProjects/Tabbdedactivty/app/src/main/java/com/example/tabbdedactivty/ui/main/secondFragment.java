package com.example.tabbdedactivty.ui.main;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tabbdedactivty.R;


public class secondFragment extends Fragment
{
    PageViewModel viewModel;



    public static secondFragment newInstance()
    {
        System.out.println("2 fargamn constraktır");
        return new secondFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = ViewModelProviders.of(requireActivity()).get(PageViewModel.class);
        System.out.println("2 faragnan OnCREate");


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        System.out.println("2 fragman OnCReateView");
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        System.out.println("2 fragman OnViewCreated");
        super.onViewCreated(view, savedInstanceState);
        final TextView textView = view.findViewById(R.id.textView);

        viewModel.getNameInput().observe(requireActivity(), new Observer<String>()
        {//değişim oldukça burada işlem olur .observe ile

            @Override
            public void onChanged(String s)
            {
                System.out.println("2 fragman OnViewCreated onChaged");
                textView.setText(s);
            }
        });
    }
}
