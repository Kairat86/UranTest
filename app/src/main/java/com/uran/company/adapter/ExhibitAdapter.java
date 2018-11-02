package com.uran.company.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uran.company.R;
import com.uran.company.model.model.Exhibit;

import java.util.List;

public class ExhibitAdapter extends RecyclerView.Adapter<ExhibitAdapter.ExhibitHolder> {

    private List<Exhibit> exhibitList;

    public ExhibitAdapter(List<Exhibit> exhibitList) {
        this.exhibitList = exhibitList;
    }

    @NonNull
    @Override
    public ExhibitHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ExhibitHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.exhibit_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ExhibitHolder exhibitHolder, int i) {
        exhibitHolder.title.setText(exhibitList.get(i).getTitle());
        exhibitHolder.rvHorizontal.setAdapter(new ImageAdapter(exhibitList.get(i).getImages()));
    }

    @Override
    public int getItemCount() {
        return exhibitList.size();
    }


    class ExhibitHolder extends RecyclerView.ViewHolder {
        TextView title;
        RecyclerView rvHorizontal;

        public ExhibitHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            rvHorizontal = itemView.findViewById(R.id.pager);
            rvHorizontal.setHasFixedSize(true);
        }


    }
}
