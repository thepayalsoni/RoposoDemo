package com.payal.roposodemo.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.payal.roposodemo.R;
import com.payal.roposodemo.parsing.StoryDetails;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by payal on 21/3/16.
 */
public class StoryItemAdapter extends RecyclerView.Adapter<StoryItemAdapter.ViewHolder> {

    LayoutInflater inflater;
    Context context;
    Bitmap bm;
    ImageLoader imloader;
    static ArrayList<StoryDetails> stories;


    OnItemClickListener mItemClickListener;
    public StoryItemAdapter(Context context,ArrayList<StoryDetails> stories) {
        this.context = context;
        this.stories = stories;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        imloader = ImageLoader.getInstance();
        imloader.init(ImageLoaderConfiguration.createDefault(context));


    }

    @Override
    public long getItemId(int position) {

        return 0;
    }

    @Override
    public int getItemCount() {

        return stories != null ? stories.size() : 0;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        if(stories.get(position).getType()==null) {
            holder.user_handle.setText(stories.get(position).getUsername() + "( " + stories.get(position).getHandle() + " )");

            File file = imloader.getDiscCache().get(stories.get(position).getImage());
            if (!file.exists()) {
                DisplayImageOptions options = new DisplayImageOptions.Builder()
                        .cacheOnDisc()
                        .build();
                imloader.displayImage(stories.get(position).getImage(), holder.image, options);
            } else {
                holder.image.setImageURI(Uri.parse(file.getAbsolutePath()));
            }

            holder.about.setText(stories.get(position).getAbout());
            holder.followers.setText("Followers\n\r" + stories.get(position).getFollowers());
            holder.following.setText("Following\n\r" + stories.get(position).getFollowing());
        }
        else
        {
            holder.user_handle.setText(stories.get(position).getTitle());

            File file = imloader.getDiscCache().get(stories.get(position).getSi());
            if (!file.exists()) {
                DisplayImageOptions options = new DisplayImageOptions.Builder()
                        .cacheOnDisc()
                        .build();
                imloader.displayImage(stories.get(position).getSi(), holder.image, options);
            } else {
                holder.image.setImageURI(Uri.parse(file.getAbsolutePath()));
            }

            holder.about.setText(stories.get(position).getDescription());
            holder.followers.setText("Likes \n\r" + stories.get(position).getLikes_count());
            holder.following.setText("Comments \n\r" + stories.get(position).getComment_count());


        }

        if(stories.get(position).getIs_following())
        {
            holder.follow.setText("Following");
        }
        else
            holder.follow.setText("Follow");

        final int  p = position;
        final ViewHolder h = holder;

        holder.follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(stories.get(p).getIs_following())
                {
                    stories.get(p).setIs_following(false);
                    h.follow.setText("Follow");


                }
                else {
                    stories.get(p).setIs_following(true);
                    h.follow.setText("Following");
                }


                for(int i =0;i <stories.size();i++) {
                    if (stories.get(p).getDb() != null) {

                        if(stories.get(p).getDb().equals(stories.get(i).getId()))
                        {
                            stories.get(p).setIs_following(stories.get(i).getIs_following());

                        }


                    }
                }


            }
        });


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.story_adapter, viewGroup,
                false);
        return new ViewHolder(itemView);

    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView image;
        TextView user_handle, about, followers,following,userSince;
        Button follow;


        public ViewHolder(View itemView) {
            super(itemView);
            user_handle = (TextView) itemView.findViewById(R.id.user_handle);
            about = (TextView) itemView.findViewById(R.id.about);
            followers = (TextView) itemView.findViewById(R.id.followers);
            following = (TextView) itemView.findViewById(R.id.following);
           // userSince = (TextView) itemView.findViewById(R.id.user_since);
            image = (ImageView) itemView.findViewById(R.id.user_image);
            follow =(Button) itemView.findViewById(R.id.follow);



            RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);

            image.setLayoutParams(rlp);
            image.setAdjustViewBounds(true);
            image.setScaleType(ImageView.ScaleType.FIT_CENTER);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {



            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(v, getPosition());
            }
        }

    }

    public interface OnItemClickListener {
        public void onItemClick(View view , int position);
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }
}