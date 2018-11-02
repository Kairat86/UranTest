package com.uran.company.fileexhibitsloader;


import android.arch.lifecycle.ViewModel;

import com.uran.company.model.loader.ExhibitsLoader;
import com.uran.company.model.model.Exhibit;

import java.util.List;

public class ExhibitsLoaderImpl extends ViewModel implements ExhibitsLoader {


    private List<Exhibit> list;

    @Override
    public List<Exhibit> getExhibitList() {
        return list;
    }
}
