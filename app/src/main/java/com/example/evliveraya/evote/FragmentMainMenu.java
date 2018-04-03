package com.example.evliveraya.evote;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FragmentMainMenu extends Fragment {

    private Button myAccount, vote, quickCount, logout;
    private String emailFromActivity;
    private Bundle dataToFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_menu, container, false);
        myAccount = (Button) view.findViewById(R.id.fragment_main_menu_my_account);
        vote = (Button) view.findViewById(R.id.fragment_main_menu_vote);
        quickCount = (Button) view.findViewById(R.id.fragment_main_menu_quick_count);
        logout = (Button) view.findViewById(R.id.fragment_main_menu_logout);
        dataToFragment = new Bundle();

        if (getArguments() != null) {
            emailFromActivity = getArguments().getString("email");
        }

        myAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                Fragment fragment = new FragmentMyAccount();
                dataToFragment.putString("email", emailFromActivity);
                fragment.setArguments(dataToFragment);
                fragmentTransaction.replace(R.id.main_fragment, fragment);
                fragmentTransaction.commit();
            }
        });

        vote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                Fragment fragment = new FragmentVote();
                dataToFragment.putString("email", emailFromActivity);
                fragment.setArguments(dataToFragment);
                fragmentTransaction.replace(R.id.main_fragment, fragment);
                fragmentTransaction.commit();
            }
        });

        quickCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                Fragment fragment = new FragmentQuickCount();
                dataToFragment.putString("email", emailFromActivity);
                fragment.setArguments(dataToFragment);
                fragmentTransaction.replace(R.id.main_fragment, fragment);
                fragmentTransaction.commit();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
