package com.example.practice1_1;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

public class ListFragment extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    View view;

    SearchView searchView;

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView = view.findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);


        myAdapter = new SongAdapter(this.getActivity(),Application.listStudent);
        recyclerView.setAdapter(myAdapter);

//        searchView.
    }

    public void setChangeNotify(){
//        myAdapter.notifyAll();
        myAdapter.notifyDataSetChanged();
    }

    public void setChangeUpdate(){
        myAdapter = new SongAdapter(this.getActivity(),Application.listStudent);
        recyclerView.setAdapter(myAdapter);

    }

}