package com.example.evliveraya.evote;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class FragmentVote extends Fragment {

    private ImageView voteCandidate1, voteCandidate2, voteCandidate3, voteCandidate4;
    private TextView candidate1nama1, candidate1nama2, candidate2nama1, candidate2nama2;
    private TextView candidate3nama1, candidate3nama2, candidate4nama1, candidate4nama2;
    private String emailFromActivity;
    private Bundle dataToFragment;
    private DBHandler dbHandler;
    private User user;
    private Candidate candidate;
    private List<Candidate> listCandidate;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragment_vote, container, false);;
        voteCandidate1 = (ImageView) view.findViewById(R.id.vote_candidate_1_img);
        voteCandidate2 = (ImageView) view.findViewById(R.id.vote_candidate_2_img);
        voteCandidate3 = (ImageView) view.findViewById(R.id.vote_candidate_3_img);
        voteCandidate4 = (ImageView) view.findViewById(R.id.vote_candidate_4_img);
        candidate1nama1 = (TextView) view.findViewById(R.id.vote_candidate_1_nama1);
        candidate1nama2 = (TextView) view.findViewById(R.id.vote_candidate_1_nama2);
        candidate2nama1 = (TextView) view.findViewById(R.id.vote_candidate_2_nama1);
        candidate2nama2 = (TextView) view.findViewById(R.id.vote_candidate_2_nama2);
        candidate3nama1 = (TextView) view.findViewById(R.id.vote_candidate_3_nama1);
        candidate3nama2 = (TextView) view.findViewById(R.id.vote_candidate_3_nama2);
        candidate4nama1 = (TextView) view.findViewById(R.id.vote_candidate_4_nama1);
        candidate4nama2 = (TextView) view.findViewById(R.id.vote_candidate_4_nama2);


        dbHandler = new DBHandler(getContext());
        dataToFragment = new Bundle();

        if (getArguments() != null) {
            emailFromActivity = getArguments().getString("email");
        }

        listCandidate = new ArrayList<Candidate>();
        listCandidate = dbHandler.getAllCandidate();
        for (Candidate candidate1 : listCandidate) {
            if (candidate1.getNomor() == 1) {
                candidate1nama1.setText(candidate1.getNama1());
                candidate1nama2.setText(candidate1.getNama2());
            } else if (candidate1.getNomor() == 2) {
                candidate2nama1.setText(candidate1.getNama1());
                candidate2nama2.setText(candidate1.getNama2());
            } else if (candidate1.getNomor() == 3) {
                candidate3nama1.setText(candidate1.getNama1());
                candidate3nama2.setText(candidate1.getNama2());
            } else if (candidate1.getNomor() == 4) {
                candidate4nama1.setText(candidate1.getNama1());
                candidate4nama2.setText(candidate1.getNama2());
            }
        }

        voteCandidate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user = dbHandler.getUser(emailFromActivity);
                if (user.getVote() == 0) {
                    candidate = dbHandler.getCandidate(1);
                    candidate.setJml_vote(candidate.getJml_vote()+1);
                    dbHandler.updateCandidate(candidate);
                    user.setVote(1);
                    dbHandler.updateUser(user);
                    Toast toast = Toast.makeText(getContext(), "Vote berhasil", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    Toast toast = Toast.makeText(getContext(), "Maaf anda sudah melakukan vote", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        voteCandidate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user = dbHandler.getUser(emailFromActivity);
                if (user.getVote() == 0) {
                    candidate = dbHandler.getCandidate(2);
                    int currentCountNUmber = candidate.getJml_vote();
                    candidate.setJml_vote(candidate.getJml_vote()+1);
                    dbHandler.updateCandidate(candidate);
                    user.setVote(1);
                    dbHandler.updateUser(user);
                    Toast toast = Toast.makeText(getContext(), "Vote berhasil", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    Toast toast = Toast.makeText(getContext(), "Maaf anda sudah melakukan vote", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        voteCandidate3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user = dbHandler.getUser(emailFromActivity);
                if (user.getVote() == 0) {
                    candidate = dbHandler.getCandidate(3);
                    int currentCountNUmber = candidate.getJml_vote();
                    candidate.setJml_vote(candidate.getJml_vote()+1);
                    dbHandler.updateCandidate(candidate);
                    user.setVote(1);
                    dbHandler.updateUser(user);
                    Toast toast = Toast.makeText(getContext(), "Vote berhasil", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    Toast toast = Toast.makeText(getContext(), "Maaf anda sudah melakukan vote", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        voteCandidate4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user = dbHandler.getUser(emailFromActivity);
                if (user.getVote() == 0) {
                    candidate = dbHandler.getCandidate(4);
                    candidate.setJml_vote(candidate.getJml_vote()+1);
                    dbHandler.updateCandidate(candidate);
                    user.setVote(1);
                    dbHandler.updateUser(user);
                    Toast toast = Toast.makeText(getContext(), "Vote berhasil", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    Toast toast = Toast.makeText(getContext(), "Maaf anda sudah melakukan vote", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        return view;
    }
}
