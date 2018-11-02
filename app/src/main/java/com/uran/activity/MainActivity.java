package com.uran.activity;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.uran.company.R;
import com.uran.company.adapter.ExhibitAdapter;
import com.uran.company.fileexhibitsloader.ExhibitsLoaderImpl;
import com.uran.company.viewmodel.ExhibitViewModel;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AssetManager manager = getAssets();
        RecyclerView rv = findViewById(R.id.rv_exhibits);
        rv.setHasFixedSize(true);
        ExhibitViewModel model = ViewModelProviders.of(this).get(ExhibitViewModel.class);
        LiveData<ExhibitsLoaderImpl> exhibitLiveData = model.getExhibits(manager);
        exhibitLiveData.observe(this, exhibit -> {
            Log.i(TAG, exhibit.getExhibitList().toString());
            rv.setAdapter(new ExhibitAdapter(exhibit.getExhibitList()));
        });
    }
}
