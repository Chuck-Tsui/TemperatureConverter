package hk.edu.hkmu.temperatureconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //task 1
    private TextView resultTextView;
    private EditText inputText;
    private Button button;
    private RadioButton celsius;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Task 2
        resultTextView = findViewById(R.id.result);
        inputText = findViewById(R.id.input);
        button = findViewById(R.id.convertbutton);
        celsius = findViewById(R.id.celsius);

        // Task 3
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String input = inputText.getText().toString();
                if (input.length() == 0) {
                    Toast.makeText(MainActivity.this, "Please enter a valid number", Toast.LENGTH_LONG).show();
                    return;
                }
                double temperature = Double.parseDouble(input);
                boolean toCelsius = celsius.isChecked();
                double convertedTemperature;
                if (toCelsius) {
                    convertedTemperature = ConverterUtil.convertFahrenheitToCelsius(temperature);
                }
                else {
                    convertedTemperature = ConverterUtil.convertCelsiusToFahrenheit(temperature);
                }
                resultTextView.setText(String.valueOf(convertedTemperature));
            }
        });

    }
}