package com.example.whowroteit;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class FetchBook extends AsyncTask<String, Void, String> {

    private TextView authorTextView, titleTextView;

    public FetchBook(TextView authorTextView, TextView titleTextView) {
        this.authorTextView = authorTextView;
        this.titleTextView = titleTextView;
    }

    @Override
    protected String doInBackground(String... params)
    {

        return NetworkUtils.getBookInfo(params[0]);
    }

    @Override
    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);

    }
}
