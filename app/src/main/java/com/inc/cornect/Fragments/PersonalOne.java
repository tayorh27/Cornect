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
import com.stepstone.stepper.internal.type.TabsStepperType;
import com.stepstone.stepper.internal.widget.StepTab;

/**
 * Created by sanniAdewale on 23/06/2017.
 */

public class PersonalOne extends Fragment implements BlockingStep {

    EditText etFirst, etMiddle, etLast, etDob, etSex, etMobile;

    String fn, mn, ln, dt, sex, mobile;

    AppData data;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personal_one, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        data = new AppData(getActivity());
        etFirst = (EditText) view.findViewById(R.id.firstName);
        etMiddle = (EditText) view.findViewById(R.id.middleName);
        etLast = (EditText) view.findViewById(R.id.lastName);
        etDob = (EditText) view.findViewById(R.id.dob);
        etSex = (EditText) view.findViewById(R.id.sex);
        etMobile = (EditText) view.findViewById(R.id.mob);

        Personal personal = data.getPersonalInfo();
        etFirst.setText(personal.first_name);
        etMiddle.setText(personal.middle_name);
        etLast.setText(personal.last_name);
        etDob.setText(personal.dob);
        etSex.setText(personal.sex);
        etMobile.setText(personal.mobile);
    }

    private boolean setInfo() {

        fn = etFirst.getText().toString();
        mn = etMiddle.getText().toString();
        ln = etLast.getText().toString();
        dt = etDob.getText().toString();
        sex = etSex.getText().toString();
        mobile = etMobile.getText().toString();
        if (fn.isEmpty() || mn.isEmpty() || ln.isEmpty() || dt.isEmpty() || sex.isEmpty() || mobile.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onNextClicked(final StepperLayout.OnNextClickedCallback callback) {
        if (setInfo()) {
            Personal personal = new Personal(fn, mn, ln, dt, sex, mobile);
            data.SetPersonalInfo_one(personal);
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
