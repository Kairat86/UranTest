package com.uran.company.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.uran.company.R;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageHolder> {

    private static final String TAG = ImageAdapter.class.getSimpleName();
    private List<String> images;

    public ImageAdapter(List<String> images) {
        this.images = images;
    }

    @NonNull
    @Override
    public ImageHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ImageHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.image_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ImageHolder imageHolder, int i) {
        Picasso.get().load(images.get(i)).into((ImageView) imageHolder.itemView);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    class ImageHolder extends RecyclerView.ViewHolder {
        public ImageHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
