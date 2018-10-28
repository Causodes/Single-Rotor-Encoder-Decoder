package com.example.ming.simpleenigma;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.inputmethod.InputMethodManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.content.Context;

public class TopSectionFragment extends Fragment {

    private static EditText message;
    private static EditText key;

    TopSectionListenerClick activityCommander;

    public interface TopSectionListenerClick{
        public void createCode(String top, String bottom);
        public void decryptCode(String top, String bottom);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            activityCommander = (TopSectionListenerClick) activity;
        }catch(ClassCastException e){
            throw new ClassCastException(activity.toString());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_layout_fragment, container, false);
        message = (EditText) view.findViewById(R.id.topTextInput);
        key = (EditText) view.findViewById(R.id.bottomTextInput);
        final Button button = (Button) view.findViewById(R.id.button);
        final Button button2 = (Button) view.findViewById(R.id.button2);

        button.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        buttonClicked(v);
                    }
                }
        );

        button2.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        buttonDecryptClicked(v);
                    }
                }
        );

        return view;

    }

    public void buttonClicked(View view){
        activityCommander.createCode(message.getText().toString(), key.getText().toString());

    }

    public void buttonDecryptClicked(View view) {
        activityCommander.decryptCode(message.getText().toString(), key.getText().toString());
    }

}

