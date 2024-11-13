package ro.pub.cs.systems.eim.practicaltest01var05;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

public class PracticalTest01Var05MainActivity extends AppCompatActivity {
        private EditText editText;
        private Button buttonTopLeft;
        private Button buttonTopRight;
        private Button buttonBottomLeft;
        private Button buttonBottomRight;
        private Button buttonCenter;
        private Button buttonNextActivity;
        private int buttonPressCount = 0;
        private static final String PRESS_COUNT_KEY = "buttonPressCount";
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_practical_test01_var05_main);

            editText = findViewById(R.id.editText);
            buttonTopLeft = findViewById(R.id.buttonTopLeft);
            buttonTopRight = findViewById(R.id.buttonTopRight);
            buttonBottomLeft = findViewById(R.id.buttonBottomLeft);
            buttonBottomRight = findViewById(R.id.buttonBottomRight);
            buttonCenter = findViewById(R.id.buttonCenter);
            buttonNextActivity = findViewById(R.id.buttonNextActivity);

            buttonTopLeft.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addTextToEditText("Top Left");
                    buttonPressCount+=1;
                }
            });

            buttonTopRight.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addTextToEditText("Top Right");
                    buttonPressCount+=1;

                }
            });

            buttonBottomLeft.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addTextToEditText("Bottom Left");
                    buttonPressCount+=1;

                }
            });

            buttonBottomRight.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addTextToEditText("Bottom Right");
                    buttonPressCount+=1;

                }
            });

            buttonCenter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addTextToEditText("Center");
                    buttonPressCount+=1;

                }
            });

            // ... (restul codului)

            buttonNextActivity.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(PracticalTest01Var05MainActivity.this, PracticalTest01Var05SecondaryActivity.class);
                    intent.putExtra("text", editText.getText().toString());
                    startActivityForResult(intent, 1);
                }
            });

// ... (restul codului)


            if (savedInstanceState != null) {
                buttonPressCount = savedInstanceState.getInt(PRESS_COUNT_KEY, 0);
                Toast.makeText(this, "Număr apăsări butoane: " + buttonPressCount, Toast.LENGTH_SHORT).show();
            }
        }

        private void addTextToEditText(String text) {
            String currentText = editText.getText().toString();
            if (currentText.isEmpty()) {
                editText.setText(text);
            } else {
                editText.setText(currentText + ", " + text);
            }
        }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(PRESS_COUNT_KEY, buttonPressCount);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Verificare cu succes", Toast.LENGTH_SHORT).show();
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Verificare anulată", Toast.LENGTH_SHORT).show();
            }
            buttonPressCount = 0;
            editText.setText("");
        }
    }

}