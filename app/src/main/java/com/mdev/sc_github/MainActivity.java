package com.mdev.sc_github;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import eu.chainfire.libsuperuser.Shell;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private List<String> dataSet;
    private int iFocus = 0;
    private String JSON_DATAs = "[\n" +
            "{\n" +
            "day: \"11-02-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"12-02-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"13-02-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"18-02-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"19-02-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"20-02-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"24-02-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"25-02-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"26-02-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"27-02-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"04-03-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"05-03-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"06-03-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"08-03-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"11-03-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"12-03-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"13-03-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"18-03-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"19-03-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"20-03-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"25-03-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"26-03-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"27-03-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"01-04-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"02-04-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"03-04-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"05-04-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"08-04-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"09-04-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"10-04-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"19-04-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"22-04-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"23-04-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"26-04-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"29-04-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"30-04-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"01-05-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"03-05-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"06-05-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"07-05-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"08-05-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"10-05-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"13-05-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"14-05-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"15-05-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"17-05-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"20-05-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"21-05-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"22-05-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"27-05-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"28-05-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"29-05-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"31-05-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"03-06-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"04-06-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"05-06-2017\",\n" +
            "state: \"1\"\n" +
            "},\n" +
            "{\n" +
            "day: \"16-06-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"17-06-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"18-06-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"19-06-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"21-06-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"24-06-2017\",\n" +
            "state: \"0\"\n" +
            "},\n" +
            "{\n" +
            "day: \"25-06-2017\",\n" +
            "state: \"0\"\n" +
            "}\n" +
            "]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataSet = new ArrayList<>();
        try {
            JSONObject jObject;
            JSONArray jArray = new JSONArray(JSON_DATAs);
            for (int i = 0; i < jArray.length(); i++) {
                jObject = jArray.getJSONObject(i);
                if (jObject.getString("state").toString().trim().equals("1")) {
                    iFocus = i;
                }
                dataSet.add(jObject.getString("day"));
            }
        } catch (Exception e) {
        }
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new MyPageAdapter(getSupportFragmentManager()));
        viewPager.setCurrentItem(iFocus);


    }

    private class MyPageAdapter extends FragmentStatePagerAdapter {
        public MyPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return OneFragment.newInstance(dataSet.get(position));
        }

        @Override
        public int getCount() {
            return dataSet.size();
        }
    }

}
