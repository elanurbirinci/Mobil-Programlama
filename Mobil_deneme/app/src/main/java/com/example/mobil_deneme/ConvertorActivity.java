package com.example.mobil_deneme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.text.TextWatcher;
public class ConvertorActivity extends AppCompatActivity {

    private EditText inputEditText,inputEditText2,inputCelsius;
    private TextView resultTextView,resultTextView2,resultTextView3;
    private Spinner conversionSpinner,conversionSpinner2;
    private RadioGroup conversionTypeGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convertor);

        inputEditText = findViewById(R.id.inputEditText);
        resultTextView = findViewById(R.id.resultTextView);
        conversionSpinner = findViewById(R.id.conversionSpinner);

        inputEditText2 = findViewById(R.id.inputEditText2);
        resultTextView2 = findViewById(R.id.resultTextView2);
        conversionSpinner2 = findViewById(R.id.conversionSpinner2);

        inputCelsius = findViewById(R.id.inputCelsius);
        resultTextView3 = findViewById(R.id.resultTextView3);
        conversionTypeGroup = findViewById(R.id.conversionTypeGroup);


        inputCelsius.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                performConversion3();
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        conversionTypeGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                performConversion3();
            }
        });


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.conversion_types,
                android.R.layout.simple_spinner_item
        );


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        conversionSpinner.setAdapter(adapter);

        conversionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                performConversion();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing here
            }
        });

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
                this,
                R.array.conversion_bytes,
                android.R.layout.simple_spinner_item
        );

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        conversionSpinner2.setAdapter(adapter2);

        conversionSpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                performConversion2();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing here
            }
        });


    }


    private void performConversion() {
        try {
            String inputStr = inputEditText.getText().toString().trim();
            if (!inputStr.isEmpty()) {
                double inputValue = Double.parseDouble(inputStr);
                String conversionType = conversionSpinner.getSelectedItem().toString();

                switch (conversionType) {
                    case "Decimal to Binary":
                        // Decimal to Binary conversion
                        resultTextView.setText(Integer.toBinaryString((int) inputValue));
                        break;
                    case "Decimal to Octal":
                        // Decimal to Octal conversion
                        resultTextView.setText(Integer.toOctalString((int) inputValue));
                        break;
                    case "Decimal to Hexadecimal":
                        // Decimal to Hexadecimal conversion
                        resultTextView.setText(Integer.toHexString((int) inputValue));
                        break;
                    default:
                        // Bilinmeyen bir dönüşüm türü durumunda genel bir hata mesajı
                        resultTextView.setText("An error occurred. Please try again.");
                        break;


                }
            }
        } catch (Exception e) {
            // Diğer olası hataları ele alabilirsiniz
            resultTextView2.setText("An error occurred. Please try again.");
        }

    }

    private void performConversion2() {
        String inputStr2 = inputEditText2.getText().toString().trim();
        if (!inputStr2.isEmpty()) {
            double inputValue = Double.parseDouble(inputStr2);
            String conversionType2 = conversionSpinner2.getSelectedItem().toString();

            switch (conversionType2) {
                case "Mega Byte to Kilo Byte":
                    double kiloBytes = inputValue * 1024;
                    resultTextView2.setText(String.valueOf(kiloBytes));
                    break;
                case "Mega Byte to Byte":
                    double bytes = inputValue * 1024 * 1024;
                    resultTextView2.setText(String.valueOf(bytes));
                    break;
                case "Mega Byte to Kibi Byte":
                    double kibiBytes = inputValue * 8 * 1024;
                    resultTextView2.setText(String.valueOf(kibiBytes));
                    break;
                case "Mega Byte to Bit":
                    double bits = inputValue * 8 * 1024 * 1024;
                    resultTextView2.setText(String.valueOf(bits));
                    break;
                default:
                    // Bilinmeyen bir dönüşüm türü durumunda genel bir hata mesajı
                    resultTextView2.setText("An error occurred. Please try again.");
                    break;

            }
        }
    }

    private void performConversion3() {
        String inputStr3 = inputCelsius.getText().toString().trim();
        if (!inputStr3.isEmpty()) {
            double celsius = Double.parseDouble(inputStr3);
            double result;

            RadioButton radioButtonFahrenheit = findViewById(R.id.radioButtonFahrenheit);
            RadioButton radioButtonKelvin = findViewById(R.id.radioButtonKelvin);

            if (radioButtonFahrenheit.isChecked()) {
                result = (celsius * 9 / 5) + 32;
                resultTextView3.setText("Result: " + String.valueOf(result));
            } else if (radioButtonKelvin.isChecked()) {
                result = celsius + 273.15;
                resultTextView3.setText("Result: " + String.valueOf(result));
            } else {
                // Eğer hiçbir RadioButton seçili değilse bir hata durumu ele alabilirsiniz.
                resultTextView3.setText("Select a conversion type");
            }
        }
    }
}










