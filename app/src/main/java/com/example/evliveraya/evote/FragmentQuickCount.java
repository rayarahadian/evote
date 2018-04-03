package com.example.evliveraya.evote;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class FragmentQuickCount extends Fragment {

    private TextView countCandidate1, countCandidate2, countCandidate3, countCandidate4;
    private String emailFromActivity;
    private Bundle dataToFragment;
    private DBHandler dbHandler;
    private List<Candidate> listCandidate;
    private Button refresh;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_quick_count, container, false);
        countCandidate1 = (TextView) view.findViewById(R.id.quick_count_candidate_1_count);
        countCandidate2 = (TextView) view.findViewById(R.id.quick_count_candidate_2_count);
        countCandidate3 = (TextView) view.findViewById(R.id.quick_count_candidate_3_count);
        countCandidate4 = (TextView) view.findViewById(R.id.quick_count_candidate_4_count);
        refresh = (Button) view.findViewById(R.id.quick_count_refresh);

        dbHandler = new DBHandler(getContext());
        listCandidate = new ArrayList<Candidate>();
        listCandidate = dbHandler.getAllCandidate();
        for (Candidate candidate : listCandidate) {
            if (candidate.getNomor() == 1) {
                countCandidate1.setText(Integer.toString(candidate.getJml_vote()));
            } else if (candidate.getNomor() == 2) {
                countCandidate2.setText(Integer.toString(candidate.getJml_vote()));
            } else if (candidate.getNomor() == 3) {
                countCandidate3.setText(Integer.toString(candidate.getJml_vote()));
            } else if (candidate.getNomor() == 4) {
                countCandidate4.setText(Integer.toString(candidate.getJml_vote()));
            }
        }

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listCandidate = new ArrayList<Candidate>();
                listCandidate = dbHandler.getAllCandidate();
                for (Candidate candidate : listCandidate) {
                    if (candidate.getNomor() == 1) {
                        countCandidate1.setText(Integer.toString(candidate.getJml_vote()));
                    } else if (candidate.getNomor() == 2) {
                        countCandidate2.setText(Integer.toString(candidate.getJml_vote()));
                    } else if (candidate.getNomor() == 3) {
                        countCandidate3.setText(Integer.toString(candidate.getJml_vote()));
                    } else if (candidate.getNomor() == 4) {
                        countCandidate4.setText(Integer.toString(candidate.getJml_vote()));
                    }
                }
            }
        });

        return view;
    }
}
