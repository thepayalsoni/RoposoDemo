package com.payal.roposodemo;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.payal.roposodemo.fragment.StoryItemAdapter;
import com.payal.roposodemo.parsing.StoryDetails;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.ServiceConfigurationError;

/**
 * Created by payal on 22/3/16.
 */
public class StoryDetailFragment extends Fragment {

    ImageView userImage, storyImage;
    TextView userHandle, about,followers,following,likes,comments,description,verb;
    Button follow;
    ImageLoader imloader;
    StoryDetails detail;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (container != null) {
            container.removeAllViews();
        }


        imloader = ImageLoader.getInstance();
        imloader.init(ImageLoaderConfiguration.createDefault(getActivity().getApplicationContext()));

        detail =(StoryDetails)getArguments().getSerializable("storydata");

        View v = inflater.inflate(R.layout.story_detail, container, false);

        userImage =(ImageView) v.findViewById(R.id.detail_user_image);
        storyImage =(ImageView) v.findViewById(R.id.story_image);
        userHandle =(TextView) v.findViewById(R.id.detail_user_handle);
        about =(TextView) v.findViewById(R.id.description_about);
        followers=(TextView) v.findViewById(R.id.followers);
        following = (TextView)v.findViewById(R.id.following);
        verb = (TextView)v.findViewById(R.id.verb);

        likes=(TextView) v.findViewById(R.id.likes);
        comments = (TextView)v.findViewById(R.id.comments);
        description=(TextView) v.findViewById(R.id.description);

        follow = (Button)v.findViewById(R.id.follow);

        if(detail.getImage()!=null) {
            File file = imloader.getDiscCache().get(detail.getImage());
            if (!file.exists()) {
                DisplayImageOptions options = new DisplayImageOptions.Builder()
                        .cacheOnDisc()
                        .build();
                imloader.displayImage(detail.getImage(), userImage, options);
            } else {
                userImage.setImageURI(Uri.parse(file.getAbsolutePath()));
            }
        }

        if(detail.getSi()!=null) {

            File file2 = imloader.getDiscCache().get(detail.getSi());
            if (!file2.exists()) {
                DisplayImageOptions options = new DisplayImageOptions.Builder()
                        .cacheOnDisc()
                        .build();
                imloader.displayImage(detail.getSi(), storyImage, options);
            } else {
                storyImage.setImageURI(Uri.parse(file2.getAbsolutePath()));
            }
        }

        if(detail.getUsername()!=null)
        userHandle.setText(detail.getUsername());
        if(detail.getVerb()!=null)
        verb.setText(detail.getVerb());
        if(detail.getDescription()!=null)
        description.setText(detail.getDescription());
        if(detail.getAbout()!=null)
        about.setText(detail.getAbout());
        if(detail.getFollowers()!=null)
        followers.setText("Followers\n\r" + detail.getFollowers());
        if(detail.getFollowing()!=null)
        following.setText("Following\n\r" + detail.getFollowing());

        if(detail.getLikes_count()!=null)
        likes.setText("Liked by " + detail.getLikes_count());
        if(detail.getComment_count()!=null)
        comments.setText(detail.getComment_count()+" Comments");

        return v;
    }

    public static StoryDetailFragment newInstance(StoryDetails data) {
        StoryDetailFragment fragment = new StoryDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable("storydata",data);
        fragment.setArguments(args);

        return fragment;
    }
}
