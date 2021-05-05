package com.example.tabbdedactivty.ui.main;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tabbdedactivty.R;


public class firsFragment extends Fragment
{
    PageViewModel viewModel;

    public static firsFragment newInstace()
    {
        System.out.println("FristFRagmat constratır");
        return new firsFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        //Toast.makeText(getActivity().getApplicationContext(),"toast Notu",Toast.LENGTH_LONG).show();
        System.out.println("FristFRagmat onCreate");
        super.onCreate(savedInstanceState);

        viewModel = ViewModelProviders.of(requireActivity()).get(PageViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        System.out.println("FristFRagmat onCreateView");
        return inflater.inflate(R.layout.fragment_firs,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {//görünüm oluştulurduktan sonra yapılack olan bazı işlemler
        System.out.println("FristFRagmat onViewCreated");
        super.onViewCreated(view, savedInstanceState);
        EditText editText = view.findViewById(R.id.editTextBirseyYaz);

        //metini dinleme işlemi
        //metin değişmeden önce
        //metin değiştiği gibi
        //metin değiştikten sonra

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {//CharSequence s metini alıp view model içirine atmaktır
                System.out.println("firstFrament onTextChanged ");
                try {

                    viewModel.setNameInput(s.toString());

                }catch (Exception e)
                {
                    System.out.println("Hata : " + e);
                }


            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });

    }

}
