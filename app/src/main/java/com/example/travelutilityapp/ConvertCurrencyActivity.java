package com.example.travelutilityapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ConvertCurrencyActivity extends AppCompatActivity implements OnItemSelectedListener {
    EditText convertFrom;
    TextView convertTo;
    Button button;
    Spinner spinnerFrom;
    Spinner spinnerTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert_currentcy);

        setTitle("Converter Currency");

        convertFrom = findViewById(R.id.convertFrom);
        convertTo = findViewById(R.id.textView);
        button = findViewById(R.id.convert);
        spinnerFrom = findViewById(R.id.spinnerFrom);
        spinnerTo = findViewById(R.id.spinnerTo);

        List<String> currentcy = new ArrayList<>();
        currentcy.add("USD");
        currentcy.add("VND");
        currentcy.add("EUR");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, currentcy);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinnerFrom.setAdapter(arrayAdapter);
        spinnerTo.setAdapter(arrayAdapter);
//        spinnerFrom.setOnItemSelectedListener(this);
    }

    public void onClick(View view) {
        String getFrom = spinnerFrom.getSelectedItem().toString();
        String getTo = spinnerTo.getSelectedItem().toString();
        String from1 = convertFrom.getText().toString();

        if (TextUtils.isEmpty(from1)) {
            convertTo.setText("Input must not be null!");
        } else {
            if (!from1.matches("[0-9]+")) {
                convertTo.setText("input number bigger than 0!");
            } else {
                double from;
                from = Double.parseDouble(from1);
                double to = 0;
                Locale localeVN = new Locale("vi","VN");
                NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
                Locale localeUS = new Locale("en","US");
                NumberFormat currencyUS = NumberFormat.getCurrencyInstance(localeUS);
                Locale localeEN = new Locale("en","EN");
                NumberFormat currencyEN = NumberFormat.getCurrencyInstance(localeEN);
                DecimalFormat dfUS = new DecimalFormat("$#.####");
                DecimalFormat dfEN = new DecimalFormat("€#.####");
//                currencyUS.format(df);
//                currencyEN.format(df);
//                String to1 = currencyVN.format(to);
                DecimalFormat df2 = new DecimalFormat("##.#");
//                to = Double.parseDouble(df.format(to));
                if (getFrom == "USD" && getTo == "VND") {
                    to = from * 23176;
                    convertTo.setText("" + currencyVN.format(to));
                } else if (getFrom == "USD" && getTo == "EUR") {
                    to = from * 0.85;
                    convertTo.setText("" + dfEN.format(to));
                } else if (getFrom == "VND" && getTo == "USD") {
                    to = from / 23176;
                    convertTo.setText("" + dfUS.format(to));
                } else if (getFrom == "VND" && getTo == "EUR") {
                    to = from / 27266;
                    convertTo.setText("" + dfEN.format(to));
                } else if (getFrom == "EUR" && getTo == "USD") {
                    to = from / 0.85;
                    convertTo.setText("" + currencyUS.format(to));
                } else if (getFrom == "EUR" && getTo == "VND") {
                    to = from * 27266;
                    convertTo.setText("" + currencyVN.format(to));
                } else if (getFrom == getTo) {
                    convertTo.setText("" + df2.format(from) + " " + getFrom);
                }

            }
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        String item = parent.getItemAtPosition(position).toString();
//        Toast.makeText(parent.getContext(), "selected: "+ item, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}