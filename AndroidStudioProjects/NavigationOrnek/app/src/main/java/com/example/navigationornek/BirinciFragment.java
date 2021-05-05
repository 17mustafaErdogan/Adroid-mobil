package com.example.navigationornek;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class BirinciFragment extends Fragment
{
    public BirinciFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_birinci, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button button = view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                goTo2fragmet(v);
            }
        });
    }

    public void goTo2fragmet(View v)
    {//aksiyonları kullanma
        //NavDirections aksiyon = BirinciFragmentDirections.actionBirinciFragmentToİkiciFragment();
        BirinciFragmentDirections.ActionBirinciFragmentToİkiciFragment aksiyon = BirinciFragmentDirections.actionBirinciFragmentToİkiciFragment();
        aksiyon.setBirSey("ikinci fragmeta giden veri");
        Navigation.findNavController(v).navigate(aksiyon);

    }

}
