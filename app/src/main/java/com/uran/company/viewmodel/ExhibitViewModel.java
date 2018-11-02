package com.uran.company.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.res.AssetManager;

import com.google.gson.Gson;
import com.uran.company.fileexhibitsloader.ExhibitsLoaderImpl;

import java.io.IOException;
import java.io.InputStream;

public class ExhibitViewModel extends ViewModel {

    private static final String TAG = ExhibitViewModel.class.getSimpleName();
    private MutableLiveData<ExhibitsLoaderImpl> exhibits;

    public LiveData<ExhibitsLoaderImpl> getExhibits(AssetManager manager) {
        if (exhibits == null) {
            exhibits = new MutableLiveData<>();
            loadData(manager);
        }
        return exhibits;
    }

    private void loadData(AssetManager manager) {
        byte[] buffer = null;
        try {
            InputStream file = manager.open("data.json");
            buffer = new byte[file.available()];
            file.read(buffer);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        exhibits.postValue(new Gson().fromJson(new String(buffer), ExhibitsLoaderImpl.class));
    }
}
