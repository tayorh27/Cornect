package com.inc.cornect.Fragments;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.inc.cornect.Database.AppData;
import com.inc.cornect.Information.Personal;
import com.inc.cornect.R;
import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import static android.app.Activity.RESULT_OK;

/**
 * Created by sanniAdewale on 23/06/2017.
 */

public class PersonalFour extends Fragment implements BlockingStep {

    int RESULT_LOAD_IMG = 754;
    String imgDecodableString = "";
    ImageView logo;

    EditText etHob, etLik, etDisLik, etInt;

    String lc, cn, ci, em;

    AppData data;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personal_four, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        data = new AppData(getActivity());
        logo = (ImageView) view.findViewById(R.id.img);
        etHob = (EditText) view.findViewById(R.id.hob);
        etLik = (EditText) view.findViewById(R.id.lik);
        etDisLik = (EditText) view.findViewById(R.id.dislikes);
        etInt = (EditText) view.findViewById(R.id.interest);

        Personal personal = data.getPersonalInfo();
        etHob.setText(personal.hobbies);
        etLik.setText(personal.likes);
        etDisLik.setText(personal.dislikes);
        etInt.setText(personal.interests);
        if (!personal.picture.isEmpty())
            logo.setImageBitmap(BitmapFactory.decodeFile(personal.picture));

        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectLogo();
            }
        });
    }


    private void SelectLogo() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, RESULT_LOAD_IMG);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            // When an Image is picked
            if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK
                    && null != data) {
                // Get the Image from data

                Uri selectedImage = data.getData();
                String[] filePathColumn = {MediaStore.Images.Media.DATA};

                // Get the cursor
                Cursor cursor = getActivity().getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                // Move to first row
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imgDecodableString = cursor.getString(columnIndex);
                cursor.close();
                //bitmap = general.compressedBitmapShop(imgDecodableString);
                logo.setImageBitmap(BitmapFactory.decodeFile(imgDecodableString));

            } else {
                Toast.makeText(getActivity(), "You haven't picked Image",
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Log.e("imageResult", e.toString());
        }
    }

    private boolean setInfo() {

        lc = etHob.getText().toString();
        cn = etLik.getText().toString();
        ci = etDisLik.getText().toString();
        em = etInt.getText().toString();
        if (lc.isEmpty() || cn.isEmpty() || ci.isEmpty() || em.isEmpty() || imgDecodableString.isEmpty()) {
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
            Personal personal = new Personal(imgDecodableString, lc, cn, ci, em);
            data.SetPersonalInfo_four(personal);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    callback.complete();
                }
            }, 200L);
        } else {
            Toast.makeText(getActivity(), "All fields must be filled", Toast.LENGTH_SHORT).show();
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
