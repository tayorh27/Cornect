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

public class PersonalThree extends Fragment implements BlockingStep {

    EditText etHigh, etCPU, etDis, etFac, etUni, etUniLoc, etLevel;

    String lc, cn, ci, em, us, pass, rpass;

    AppData data;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personal_three, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        data = new AppData(getActivity());
        etHigh = (EditText) view.findViewById(R.id.high);
        etCPU = (EditText) view.findViewById(R.id.cpu);
        etDis = (EditText) view.findViewById(R.id.dis);
        etFac = (EditText) view.findViewById(R.id.college);
        etUni = (EditText) view.findViewById(R.id.uni);
        etUniLoc = (EditText) view.findViewById(R.id.uni_loc);
        etLevel = (EditText) view.findViewById(R.id.level);

        Personal personal = data.getPersonalInfo();
        etHigh.setText(personal.high_school);
        etCPU.setText(personal.cpu);
        etDis.setText(personal.discipline);
        etFac.setText(personal.college);
        etUni.setText(personal.uni);
        etUniLoc.setText(personal.uni_location);
        etLevel.setText(personal.level);
    }

    private boolean setInfo() {

        lc = etHigh.getText().toString();
        cn = etCPU.getText().toString();
        ci = etDis.getText().toString();
        em = etFac.getText().toString();
        us = etUni.getText().toString();
        pass = etUniLoc.getText().toString();
        rpass = etLevel.getText().toString();
        if (lc.isEmpty() || cn.isEmpty() || ci.isEmpty() || em.isEmpty() || us.isEmpty() || pass.isEmpty() || rpass.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onNextClicked(final StepperLayout.OnNextClickedCallback callback) {
        if (setInfo()) {
            Personal personal = new Personal(lc, cn, ci, em, us, pass, rpass,"");
            data.SetPersonalInfo_three(personal);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    callback.goToNextStep();
                }
            }, 200L);
        } else {
            Toast.makeText(getActivity(), "All fields must be filled", Toast.LENGTH_SHORT).show();
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
