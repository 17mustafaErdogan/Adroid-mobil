package com.example.navigationornek;


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
import android.widget.TextView;


public class ikiciFragment extends Fragment {


    public ikiciFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ikici, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button button = view.findViewById(R.id.button2);
        TextView text = view.findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                goTo1fagment(v);
            }
        });

        if(getArguments() != null)
        {//birici fragmandaki bilgi boğçası bilgi alınır yani 1. frametta yazılan veri çeklir
            String s = ikiciFragmentArgs.fromBundle(getArguments()).getBirSey();
            text.setText(s);
        }
    }

    public void goTo1fagment(View view)
    {
        NavDirections aksiyon = ikiciFragmentDirections.actionİkiciFragmentToBirinciFragment();
        Navigation.findNavController(view).navigate(aksiyon);
    }

}
