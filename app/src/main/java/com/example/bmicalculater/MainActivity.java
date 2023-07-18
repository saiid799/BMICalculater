package com.example.bmicalculater;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private RadioButton radioMale;
    private RadioButton radioFamale;
    private EditText editTextAge;
    private EditText editTextFeet;
    private EditText editTextInches;
    private EditText editTextweight;
    private Button button;
    private TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TheViews();
        setTheButtonClick();

    }

    private void TheViews() {
        radioMale = findViewById(R.id.maleButton_id);
        radioFamale = findViewById(R.id.femaleButton_id);
        editTextAge = findViewById(R.id.AgeInp_id);
        editTextFeet = findViewById(R.id.FeetInp_id);
        editTextInches = findViewById(R.id.InchesInp_id);
        editTextweight = findViewById(R.id.WeightInp_id);
        button = findViewById(R.id.CalculateButton_id);
        result = findViewById(R.id.result_text_id);
    }

    private void setTheButtonClick() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               double totalResult =  calculaterView();
                String EditAge = editTextAge.getText().toString();
                int age = Integer.parseInt(EditAge);

                if(age > 18){
                    displayResult(totalResult);
                }else {
                    UnderAgeResult(totalResult);
                }
            }
        });
    }



    private double calculaterView() {
        // converted to string
        String EditFeet = editTextFeet.getText().toString();
        String EditInches = editTextInches.getText().toString();
        String EditWeight = editTextweight.getText().toString();

        // converted to Integer
        int feet = Integer.parseInt(EditFeet);
        int inch = Integer.parseInt(EditInches);
        int weight = Integer.parseInt(EditWeight);

        // calculate the inch
        int TotalInches = (feet * 12) + inch;
        //calculate the from inch to mater
        double HightToMater = TotalInches * 0.0254;
        //calculate the bmi
        return weight / (HightToMater * HightToMater);
    }

    private void displayResult(double bmi) {
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        String result1 = decimalFormat.format(bmi);

        String fullResult;
        if(bmi < 18.5){
            fullResult = result1 + " - You are under weight";
        }else if(bmi > 25){
            fullResult = result1 + " - You are over weight";
        }else {
            fullResult = result1 + " - You are Normal";
        }
        result.setText(fullResult);
    }

    private void UnderAgeResult(double bmi) {
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        String result1 = decimalFormat.format(bmi);

        String fullResult;
        if(radioMale.isChecked()){
            fullResult = result1 + " - You are under health age as a boy";
        } else if (radioFamale.isChecked()) {
            fullResult = result1 + " - You are under health age as a girl";
        }else {
            fullResult = result1 + " - You are under health age";
        }
        result.setText(fullResult);
    }

}