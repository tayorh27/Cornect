package com.inc.cornect.Fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.inc.cornect.Database.AppData;
import com.inc.cornect.Information.Personal;
import com.inc.cornect.R;
import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

/**
 * Created by sanniAdewale on 23/06/2017.
 */

public class PersonalTwo extends Fragment implements BlockingStep {

    EditText etLocation, etCountry, etCitizen, etEmail, etUser, etPass, etRPass;

    String lc, cn, ci, em, us, pass, rpass;

    AppData data;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personal_two, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        data = new AppData(getActivity());
        etLocation = (EditText) view.findViewById(R.id.loc);
        etCountry = (EditText) view.findViewById(R.id.country);
        etCitizen = (EditText) view.findViewById(R.id.citizen);
        etEmail = (EditText) view.findViewById(R.id.email);
        etUser = (EditText) view.findViewById(R.id.username);
        etPass = (EditText) view.findViewById(R.id.password);
        etRPass = (EditText) view.findViewById(R.id.rpassword);

        Personal personal = data.getPersonalInfo();
        etLocation.setText(personal.location);
        etCountry.setText(personal.country);
        etCitizen.setText(personal.citizenship);
        etEmail.setText(personal.email);
        etUser.setText(personal.username);
    }

    private boolean setInfo() {

        lc = etLocation.getText().toString();
        cn = etCountry.getText().toString();
        ci = etCitizen.getText().toString();
        em = etEmail.getText().toString();
        us = etUser.getText().toString();
        pass = etPass.getText().toString();
        rpass = etRPass.getText().toString();
        if (lc.isEmpty() || cn.isEmpty() || ci.isEmpty() || em.isEmpty() || us.isEmpty() || pass.isEmpty() || rpass.isEmpty()) {
            return false;
        }
        if (!pass.contentEquals(rpass)) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onNextClicked(final StepperLayout.OnNextClickedCallback callback) {
        if (setInfo()) {
            Personal personal = new Personal(lc, cn, ci, em, us, pass, rpass);
            data.SetPersonalInfo_two(personal);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    callback.goToNextStep();
                }
            }, 200L);
        } else {
            Toast.makeText(getActivity(), "All fields must be filled and passwords must match", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onCompleteClicked(final StepperLayout.OnCompleteClickedCallback callback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                callback.complete();
            }
        }, 200L);
    }

    @Override
    public void onBackClicked(StepperLayout.OnBackClickedCallback callback) {
        callback.goToPrevStep();
    }

    @Override
    public VerificationError verifyStep() {
        return null;
    }

    @Override
    public void onSelected() {

    }

    @Override
    public void onError(@NonNull VerificationError error) {

    }
}
