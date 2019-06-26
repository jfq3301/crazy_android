package com.example.fragmenttest;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookDetailFragment extends Fragment {

    public static final String ITEM_ID = "item_id";
    BookContent.Book book;

    public BookDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey(ITEM_ID)) {
            book = BookContent.ITEM_MAP.get(getArguments().getInt(ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_book_details,
                container, false);

        if (rootView != null) {
            ((TextView)rootView.findViewById(R.id.book_title))
                    .setText(book.title);
            ((TextView)rootView.findViewById(R.id.book_desc))
                    .setText(book.desc);
        }

        return rootView;
    }

}
