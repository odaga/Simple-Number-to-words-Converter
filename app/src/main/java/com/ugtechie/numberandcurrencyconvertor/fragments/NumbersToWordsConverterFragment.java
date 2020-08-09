package com.ugtechie.numberandcurrencyconvertor.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ugtechie.numberandcurrencyconvertor.R;
import com.ugtechie.numberandcurrencyconvertor.convertors.NumbersToWords;

public class NumbersToWordsConverterFragment extends Fragment {

    private EditText editTextNumber;
    private TextView textViewWord;
    private Button buttonConvert;
    private long limit =  999999999999L;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_number_to_words, container, false);
        //Setting up widgets
        editTextNumber = v.findViewById(R.id.enter_number);
        textViewWord = v.findViewById(R.id.converted_words);
        buttonConvert = v.findViewById(R.id.button_convert);

        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String digit = editTextNumber.getText().toString();

                if (digit.isEmpty()) {
                    editTextNumber.setError("Please enter a number");
                }
                 else {

                    long numberToConvert = Integer.parseInt(digit);
                    if (numberToConvert < limit) {
                        String result =  NumbersToWords.convert(numberToConvert);
                        textViewWord.setText(result);
                    }
                    else {
                        editTextNumber.setError("Number is too large");
                    }
                }
            }
        });
        return v;
    }
}
