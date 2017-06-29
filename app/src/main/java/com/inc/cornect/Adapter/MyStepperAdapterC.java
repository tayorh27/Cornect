package com.inc.cornect.Adapter;

import android.content.Context;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;

import com.inc.cornect.Fragments.CorporateOne;
import com.inc.cornect.Fragments.CorporateTwo;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter;
import com.stepstone.stepper.viewmodel.StepViewModel;

/**
 * Created by sanniAdewale on 23/06/2017.
 */

public class MyStepperAdapterC extends AbstractFragmentStepAdapter {


    public MyStepperAdapterC(@NonNull FragmentManager fm, @NonNull Context context) {
        super(fm, context);
    }

    @Override
    public Step createStep(@IntRange(from = 0L) int position) {
        switch (position) {
            case 0:
                return new CorporateOne();
            case 1:
                return new CorporateTwo();
            default:
                throw new IllegalArgumentException("Unsupported position: " + position);
        }
    }

    @Override
    public int getCount() {
        return 2;
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
                        .setTitle("Company Profile");
                break;
            case 1:
                builder
                        .setTitle("Company Details");
                break;
            default:
                throw new IllegalArgumentException("Unsupported position: " + position);
        }
        return builder.create();
    }
}
