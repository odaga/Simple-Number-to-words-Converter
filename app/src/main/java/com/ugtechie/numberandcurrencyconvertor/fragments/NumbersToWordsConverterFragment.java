package com.ugtechie.numberandcurrencyconvertor.fragments;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
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

import java.util.Locale;

public class NumbersToWordsConverterFragment extends Fragment {

    private EditText editTextNumber;
    private TextView textViewWord;
    private Button buttonConvert;
    private long limit =  999999999999L;
    private TextToSpeech mTTS;
    private Button speakButton;

    private String result;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_number_to_words, container, false);
        //Setting up widgets
        editTextNumber = v.findViewById(R.id.enter_number);
        textViewWord = v.findViewById(R.id.converted_words);
        buttonConvert = v.findViewById(R.id.button_convert);
        speakButton = v.findViewById(R.id.button_speak);

        mTTS = new TextToSpeech(getContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = mTTS.setLanguage(Locale.US);

                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    }
                    else {
                        speakButton.setEnabled(true);
                    }
                }
                else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });

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
                         result =  NumbersToWords.convert(numberToConvert);
                        textViewWord.setText(result);
                    }
                    else {
                        editTextNumber.setError("Number is too large");
                    }
                }
            }
        });

        speakButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak(result);
            }
        });
        return v;
    }

    private void speak(String result) {
        //float pitch = 1;
        /*
        float pitch = (float) mSeekBarPitch.getProgress() / 50;
        if (pitch < 0.1) pitch = 0.1f;
        float speed = (float) mSeekBarSpeed.getProgress() / 50;
        if (speed < 0.1) speed = 0.1f;
        */
        mTTS.setPitch(1);
        mTTS.setSpeechRate(1);
        mTTS.speak(result, TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    public void onDestroy() {
        if (mTTS != null) {
            mTTS.stop();
            mTTS.shutdown();
        }
        super.onDestroy();
    }
}
