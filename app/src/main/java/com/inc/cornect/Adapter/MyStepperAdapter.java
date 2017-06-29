package com.inc.cornect.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;

import com.inc.cornect.Fragments.PersonalFour;
import com.inc.cornect.Fragments.PersonalOne;
import com.inc.cornect.Fragments.PersonalThree;
import com.inc.cornect.Fragments.PersonalTwo;
import com.inc.cornect.R;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter;
import com.stepstone.stepper.viewmodel.StepViewModel;

/**
 * Created by sanniAdewale on 23/06/2017.
 */

public class MyStepperAdapter extends AbstractFragmentStepAdapter {

    private static final String CURRENT_STEP_POSITION_KEY = "my_position";

    public MyStepperAdapter(@NonNull FragmentManager fm, @NonNull Context context) {
        super(fm, context);
    }

    @Override
    public Step createStep(@IntRange(from = 0L) int position) {
        switch (position) {
            case 0:
                return new PersonalOne();
            case 1:
                return new PersonalTwo();
            case 2:
                return new PersonalThree();
            case 3:
                return new PersonalFour();
            default:
                throw new IllegalArgumentException("Unsupported position: " + position);
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @NonNull
    @Override
    public StepViewModel getViewModel(@IntRange(from = 0L) int position) {
        //Override this method to set Step title for the Tabs, not necessary for other stepper types
        StepViewModel.Builder builder = new StepViewModel.Builder(context)
                .setTitle("Personal Account");
        switch (position) {
            case 0:
                builder
                        .setTitle("Personal Information");
                break;
            case 1:
                builder
                        .setTitle("Personal Details");
                break;
            case 2:
                builder.setTitle("School Details");
                break;
            case 3:
                builder.setTitle("Profile");
                break;
            default:
                throw new IllegalArgumentException("Unsupported position: " + position);
        }
        return builder.create();
    }
}
