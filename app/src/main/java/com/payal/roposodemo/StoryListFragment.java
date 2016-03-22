package com.payal.roposodemo;

import android.content.Intent;
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

        //if(adapter!=null)
        /*adapter.SetOnItemClickListener(new StoryItemAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent(getActivity().getApplicationContext(), DetailActivity.class);
                intent.putExtra(getString(R.string.CONSTANT_DEAL_ITEM), deals.get(position));
                startActivity(intent);

            }
        });*/
    }




}
