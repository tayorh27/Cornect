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
import com.inc.cornect.Information.Corporate;
import com.inc.cornect.R;
import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

/**
 * Created by sanniAdewale on 23/06/2017.
 */

public class CorporateTwo extends Fragment implements BlockingStep {

    EditText etType, etLoc, etMob;

    String org, em, us;

    AppData data;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_corporate_two, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        data = new AppData(getActivity());
        etType = (EditText) view.findViewById(R.id.type);
        etMob = (EditText) view.findViewById(R.id.c_mob);
        etLoc = (EditText) view.findViewById(R.id.c_loc);

        Corporate personal = data.getCorporateInfo();
        etType.setText(personal.organisation);
        etLoc.setText(personal.email);
        etMob.setText(personal.username);
    }

    private boolean setInfo() {
        org = etType.getText().toString();
        em = etLoc.getText().toString();
        us = etMob.getText().toString();
        if (org.isEmpty() || em.isEmpty() || us.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onNextClicked(final StepperLayout.OnNextClickedCallback callback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                callback.goToNextStep();
            }
        }, 200L);
    }

    @Override
    public void onCompleteClicked(final StepperLayout.OnCompleteClickedCallback callback) {
        if (setInfo()) {
            Corporate personal = new Corporate(org, em, us);
            data.setCorporateInfo_two(personal);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    callback.complete();
                }
            }, 200L);
        } else {
            Toast.makeText(getActivity(), "All fields must be filled and passwords must match", Toast.LENGTH_LONG).show();
        }
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

