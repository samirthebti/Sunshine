package com.example.android.sunshine.app;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.android.sunshine.app.R.id.list_item_forecast_textview;
import static com.example.android.sunshine.app.R.id.listview_forcast;
import static com.example.android.sunshine.app.R.layout.list_item_forecast;
import static java.util.Arrays.asList;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            String[] forcastArray = {
                    "today - Sunny - 44/15",
                    "tommoro - Sunny - 44/15", "today - Sunny - 44/15", "today - Sunny - 44/15", "today - Sunny - 44/15",
                    "tommoro - Sunny - 44/15", "today - Sunny - 44/15", "today - Sunny - 44/15", "today - Sunny - 44/15",
                    "tommoro - Sunny - 44/15", "today - Sunny - 44/15", "today - Sunny - 44/15", "today - Sunny - 44/15",
                    "tommoro - Sunny - 44/15", "today - Sunny - 44/15", "today - Sunny - 44/15", "today - Sunny - 44/15",
                    "today - Sunny - 44/15", "today - Sunny - 44/15", "today - Sunny - 44/15"
            };
            List<String> weekforcast = new ArrayList<String>(asList(forcastArray));

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                    getActivity(),
                    list_item_forecast,
                    list_item_forecast_textview,
                    weekforcast);
            ListView listView = (ListView) rootView.findViewById(listview_forcast);
            listView.setAdapter(arrayAdapter);
            //Log.d(String.valueOf(getActivity()),"JOB TERMINED :D");
            return rootView;
        }
    }
}
