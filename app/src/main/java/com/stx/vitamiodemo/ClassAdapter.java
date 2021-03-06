package com.stx.vitamiodemo;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.ViewHolder>{

    private Context mContext;

    private List<Class> mClassList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView classImage;
        TextView className;

        public ViewHolder(View view) {
            super(view);
            cardView = (CardView) view;
            classImage = (ImageView) view.findViewById(R.id.class_image);
            className = (TextView) view.findViewById(R.id.class_name);
        }
    }

    public ClassAdapter(List<Class> classList) {
        mClassList = classList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.class_item, parent, false);
       final ViewHolder holder = new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int position = holder.getAdapterPosition();
                //Class class=mClassList.get(position);
                Intent intent = new Intent(mContext, ClassActivity.class);

                mContext.startActivity(intent);
            }
        });
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Class fruit = mClassList.get(position);
        holder.className.setText(fruit.getName());
        Glide.with(mContext).load(fruit.getImageId()).into(holder.classImage);
    }

    @Override
    public int getItemCount() {
        return mClassList.size();
    }

}
