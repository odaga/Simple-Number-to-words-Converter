package com.ugtechie.numberandcurrencyconvertor.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ugtechie.numberandcurrencyconvertor.R;

import java.util.ArrayList;
import java.util.List;

public class CurrencyConvertorFragment extends Fragment {
    private Spinner spinner1, spinner2;
    private EditText from;
    private TextView to;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_currency_converter, container, false);

        Button btnSubmit = v.findViewById(R.id.btnSubmit);
        from = v.findViewById(R.id.InputEditText);
        to = v.findViewById(R.id.OutputTextView);
        spinner1 = v.findViewById(R.id.spinner1);

        List<String> list1 = new ArrayList<String>();
        list1.add("United States Dollar");
        list1.add("Armenian Dram");
        list1.add("Bitcoin");
        list1.add("Chinese Yuan");
        list1.add("Indian Rupee");
        list1.add("Kuwaiti Dinar");
        list1.add("Mexican Peso");
        list1.add("Omani Rial");
        list1.add("Bangladeshi Taka");

        return v;
    }
}
