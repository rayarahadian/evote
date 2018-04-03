package com.example.evliveraya.evote;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.EnumMap;


public class FragmentMyAccount extends Fragment {

    private EditText nama, email, nik;
    private DBHandler dbHandler;
    private User user;
    private String emailFromActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_my_account, container, false);
        nama = (EditText) view.findViewById(R.id.fragment_my_account_nama);
        email = (EditText) view.findViewById(R.id.fragment_my_account_email);
        nik = (EditText) view.findViewById(R.id.fragment_my_account_NIK);
        dbHandler = new DBHandler(getContext());
        emailFromActivity = "";
        if (getArguments() != null) {
            emailFromActivity = this.getArguments().getString("email");
        }
        user = new User();
        user = dbHandler.getUser(emailFromActivity);

        nama.setInputType(InputType.TYPE_NULL);
        email.setInputType(InputType.TYPE_NULL);
        nik.setInputType(InputType.TYPE_NULL);

        nama.setText(user.getNama());
        email.setText(user.getEmail());
        nik.setText(user.getNik());

        return view;
    }
}
