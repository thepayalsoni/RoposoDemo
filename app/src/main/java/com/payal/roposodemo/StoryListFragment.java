package com.payal.roposodemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.payal.roposodemo.fragment.StoryItemAdapter;
import com.payal.roposodemo.parsing.StoryDetails;

import java.util.ArrayList;

/**
 * Created by payal on 21/3/16.
 */


public class StoryListFragment extends Fragment {

    RecyclerView mRecyclerView;
    StoryItemAdapter adapter;
    ArrayList<StoryDetails> deals;

    public static StoryListFragment newInstance(ArrayList<StoryDetails> data) {
        StoryListFragment fragment = new StoryListFragment();
        Bundle args = new Bundle();
        args.putSerializable("story",data);
        fragment.setArguments(args);

        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (container != null) {
            container.removeAllViews();
        }

        View v = inflater.inflate(R.layout.fragment_main, container, false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        deals =(ArrayList<StoryDetails>)getArguments().getSerializable("story");

        adapter = new StoryItemAdapter(getActivity().getApplicationContext(), deals);
        mRecyclerView.setAdapter(adapter);




        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new StoryItemAdapter(getActivity().getApplicationContext(), deals);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());




        adapter.SetOnItemClickListener(new StoryItemAdapter.OnItemClickListener() {




            @Override
            public void onItemClick(View v, int position) {

                StoryDetails selected = new StoryDetails();

                for(int i =0; i<deals.size();i++)
                {
                    if(deals.get(position).getDb()!=null)
                    {
                        if(deals.get(position).getDb().equals(deals.get(i).getId()))
                        {
                            deals.get(position).setUsername(deals.get(i).getUsername());

                            deals.get(position).setAbout(deals.get(i).getAbout());

                            deals.get(position).setImage(deals.get(i).getImage());

                            deals.get(position).setFollowers(deals.get(i).getFollowers());

                            deals.get(position).setFollowing(deals.get(i).getFollowing());

                            deals.get(position).setIs_following(deals.get(i).getIs_following());

                            selected = deals.get(position);

                        }
                    }
                    else
                    {
                        selected = deals.get(position);
                    }


                }

                getFragmentManager().beginTransaction().addToBackStack("detail")
                        .replace(R.id.content_frame, StoryDetailFragment.newInstance(selected)).commit();


            }
        });
    }




}
