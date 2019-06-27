package com.example.fragmenttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BookListActivity extends AppCompatActivity
    implements BookListFragment.Callbacks {

    private boolean mTowPane;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);
//        setContentView(R.layout.activity_main);

        if (findViewById(R.id.book_detail_container) != null) {
            mTowPane = true;
            ((BookListFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.book_list))
                    .setActivateOnItemClick(true);
        }
    }

    @Override
    public void onItemSelected(Integer id) {
        if (mTowPane) {
            Bundle arguments = new Bundle();
            arguments.putInt(BookDetailFragment.ITEM_ID, id);
            BookDetailFragment fragment = new BookDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.book_detail_container, fragment)
                    .commit();
        } else {
            Intent detailIntent = new Intent(this, BookDetailActivity.class);
            detailIntent.putExtra(BookDetailFragment.ITEM_ID, id);
            startActivity(detailIntent);
        }
    }
}
