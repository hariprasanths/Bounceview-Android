package hari.bounceviewsample;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hari on 8/6/18.
 */

public class FragmentRecyclerView extends Fragment {

    Context context;
    TextView titleView;
    RecyclerView recyclerView;
    List<String> list;

    RecyclerViewAdapter adapter;

    public FragmentRecyclerView() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.recycler_view_fragment, container, false);
        String title = "Fragment";
        if (getArguments() != null) {
            title = getArguments().getString("title");
        }
        titleView = view.findViewById(R.id.fragmentTitle);
        recyclerView = view.findViewById(R.id.recyclerView);
        titleView.setText(title);

        list = new ArrayList<>();
        list.add("Item 1");
        list.add("Item 2");
        list.add("Item 3");
        list.add("Item 4");

        adapter = new RecyclerViewAdapter(getContext(), list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        return view;
    }

    public static FragmentRecyclerView newInstance(String title) {

        Bundle args = new Bundle();
        args.putString("title", title);
        FragmentRecyclerView fragment = new FragmentRecyclerView();
        fragment.setArguments(args);
        return fragment;
    }

}
