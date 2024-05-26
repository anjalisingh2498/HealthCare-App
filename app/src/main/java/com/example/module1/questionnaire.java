package com.example.module1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class questionnaire extends AppCompatActivity {

    private FrameLayout fragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire2);

        fragmentContainer = findViewById(R.id.fragment_container);
        RadioGroup languageRadioGroup = findViewById(R.id.language_radio_group);

        languageRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioenglish) {
                    showEnglishQuestionnaire();
                } else if (checkedId == R.id.radiokannada) {
                    showKannadaQuestionnaire();
                }
            }
        });

    }
    public void showEnglishQuestionnaire() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new QuestionnaireFragmentEnglish())
                .addToBackStack(null)
                .commit();
    }

    private void showKannadaQuestionnaire() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new QuestionnaireFragmentKannada())
                .addToBackStack(null)
                .commit();
    }
}
