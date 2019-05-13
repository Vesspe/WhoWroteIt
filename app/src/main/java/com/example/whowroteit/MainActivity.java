package com.example.whowroteit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText bookInput;
    private TextView authorTextView, titleTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bookInput = (EditText)findViewById(R.id.bookInput);
        authorTextView = (TextView)findViewById(R.id.authorText);
        titleTextView = (TextView)findViewById(R.id.titleText);

    }

    public void searchBooks(View view) {
        String queryString = bookInput.getText().toString();
        new FetchBook(authorTextView, titleTextView).execute(queryString);
    }
}
