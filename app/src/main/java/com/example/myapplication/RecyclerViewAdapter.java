package com.example.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.lang.reflect.Array;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter {
    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(ArrayList<String> mImageNames, ArrayList<String> mImages, Context mContext) {
        this.mImageNames = mImageNames;
        this.mImages = mImages;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recycler_list_items, parent, false);
        return new VoidHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called");
        VoidHolder voidHolder = (VoidHolder) holder;

        // Get the item at the specified position
        String imageName = mImageNames.get(position);
        String image = mImages.get(position);

        // Set the text and image views in the view holder
        voidHolder.imageName.setText(imageName);

        //
        voidHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + imageName);

                Toast.makeText(mContext, imageName, Toast.LENGTH_SHORT).show();
            }
        });
        // You can use an image loading library like Glide or Picasso to load the image
        // into the CircleImageView
        Glide.with(mContext).load(image).into(voidHolder.image);

    }

    @Override
    public int getItemCount() {
        return mImageNames.size();
    }

    public class VoidHolder extends RecyclerView.ViewHolder {

        CircleImageView image;
        TextView imageName;
        ConstraintLayout parentLayout;
        public VoidHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
