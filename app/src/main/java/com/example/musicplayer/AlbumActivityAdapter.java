package com.example.musicplayer;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class AlbumActivityAdapter extends RecyclerView.Adapter<AlbumActivityAdapter.MyViewHolder> {

    Context mContext;
    List<Album> mData;

    public AlbumActivityAdapter(Context mContext, List<Album> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.activity_albumlist, viewGroup, false);
        MyViewHolder vHolder = new MyViewHolder(v);

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int i) {

        holder.tv_album_name.setText(mData.get(i).getAlbumName());
        holder.img_album.setImageResource(mData.get(i).getAlbumPhoto());



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tv_album_name;
        private ImageView img_album;
        private LinearLayout layout;


        public MyViewHolder(View itemView){
            super(itemView);

            itemView.setOnClickListener(this);

            tv_album_name = itemView.findViewById(R.id.album_name_list);
            img_album = itemView.findViewById(R.id.album_img_list);
            layout = itemView.findViewById( R.id.album_list);


        }


        @Override
        public void onClick(View v) {
            Context mContext = v.getContext();
            Intent intent = new Intent(mContext,SongActivity.class );
            mContext.startActivity(intent);
        }


    }
}
