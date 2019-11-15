package com.example.projectphase1.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a17l_4343_ui_design.JobsClass;
import com.example.a17l_4343_ui_design.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    View view;
    private RecyclerView myRecyclerView;
    private List<JobsClass> myList;
    public HomeFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=  inflater.inflate(R.layout.home_fragment_layout,container,false);
        myRecyclerView = view.findViewById(R.id.jobview);
        JobAdopter recyclerViewAdopter = new JobAdopter(getContext(),myList);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(recyclerViewAdopter);
        return  view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myList=new ArrayList<JobsClass>();
        for (int i=0;i<9;i++)
             myList.add(new JobsClass(i+1,"ELECTRICIAN"+i,R.drawable.job_electrician));
    }
}
