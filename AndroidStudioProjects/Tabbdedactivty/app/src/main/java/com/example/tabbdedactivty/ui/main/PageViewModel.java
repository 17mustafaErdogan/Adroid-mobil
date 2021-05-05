package com.example.tabbdedactivty.ui.main;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class PageViewModel extends ViewModel
{
    private MutableLiveData <String> nameInput =new MutableLiveData<>();

    public MutableLiveData<String> getNameInput()
    {//getter
        System.out.println("getter PageViewModel");
        return nameInput;
    }

    public void setNameInput(String name)
    {//setter
        System.out.println("setter PageViewModel");
        nameInput.setValue(name);
    }
}