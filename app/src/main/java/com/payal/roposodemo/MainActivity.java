package com.payal.roposodemo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.payal.roposodemo.parsing.StoryDetails;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by payal on 21/3/16.
 */
public class MainActivity extends AppCompatActivity {

    private String data;
    ArrayList<StoryDetails> storyDetailsArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        data = loadJSONFromAsset();

        new JSONParser().execute(data);


    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getApplicationContext().getAssets().open("storyData.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }


    class JSONParser extends AsyncTask<String,String,ArrayList<StoryDetails>>
    {


        @Override
        protected ArrayList<StoryDetails> doInBackground(String... params) {

            Type typeCategoryItemDetails = new TypeToken<ArrayList<StoryDetails>>() {
            }.getType();

            storyDetailsArrayList = new Gson().fromJson(params[0], typeCategoryItemDetails);

            return storyDetailsArrayList;
        }


        @Override
        protected void onPostExecute(ArrayList<StoryDetails> result) {

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame, StoryListFragment.newInstance(result)).commit();


        }

        @Override
        protected void onPreExecute() {

        }
    }



}
