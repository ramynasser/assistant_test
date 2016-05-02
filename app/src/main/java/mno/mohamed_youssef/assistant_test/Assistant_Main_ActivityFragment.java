package mno.mohamed_youssef.assistant_test;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;
import com.linearlistview.LinearListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A placeholder fragment containing a simple view.
 */
public class Assistant_Main_ActivityFragment extends Fragment {

    Firebase ref;
    TaskListAdapter taskListAdapter;
    NonScrollListView listViewPast;
    NonScrollListView listViewNow;
    NonScrollListView listViewNext;
    ArrayList<Schedule_Assistant> schedule_assistants;
   // ImageView listBackground;

    public Assistant_Main_ActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_assistant__main_, container, false);


       // listBackground = new ImageView(getActivity());

        //listBackground.setBackground(R.drawable.fci_logo);
        //view.setBackground();

        Glide.with(getActivity()).load(R.drawable.fci_logo).into((ImageView)view.findViewById(R.id.b));

        schedule_assistants = new ArrayList<>();
        listViewPast = (NonScrollListView)view.findViewById(R.id.listViewPast);
        listViewNow = (NonScrollListView)view.findViewById(R.id.listViewNow);
        listViewNext = (NonScrollListView)view.findViewById(R.id.listViewNext);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        updateList();
    }

    public void updateList()
    {

        ref =new Firebase("https://torrid-torch-3608.firebaseio.com");

        ref.child("schedule_assistant").orderByChild("day").equalTo("sunday").getRef()
                .orderByChild("doctor").equalTo("israa").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot d : dataSnapshot.getChildren()) {

                    schedule_assistants.add(d.getValue(Schedule_Assistant.class));
                }


                // past

                taskListAdapter = new TaskListAdapter(getActivity(), schedule_assistants);
                listViewPast.setAdapter(taskListAdapter);

                //now

                taskListAdapter = new TaskListAdapter(getActivity(), schedule_assistants);
                listViewNow.setAdapter(taskListAdapter);

                //next

                taskListAdapter = new TaskListAdapter(getActivity(), schedule_assistants);

                listViewNext.setAdapter(taskListAdapter);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });




    }


}
