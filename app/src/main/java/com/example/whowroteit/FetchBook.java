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
        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONArray itemsArray = jsonObject.getJSONArray("items");

            //lets iterate throught results

            for (int i=0; i<itemsArray.length();i++)
            {
                JSONObject book = itemsArray.getJSONObject(i); // current item
                String title = null;
                String authors = null;
                JSONObject volumeInfo = book.getJSONObject("volumeInfo");

                try{
                    title = volumeInfo.getString("title");
                    authors = volumeInfo.getString("authors");
                }catch (Exception e)
                {
                    e.printStackTrace();
                }

                if (title != null && authors != null)
                {
                    titleTextView.setText(title);
                    authorTextView.setText(authors);
                    return;
                }
            }
            titleTextView.setText("No Results Found");
            authorTextView.setText("");

        } catch (Exception e) {
            titleTextView.setText("No Results Found");
            authorTextView.setText("");
            e.printStackTrace();
        }
    }
}
