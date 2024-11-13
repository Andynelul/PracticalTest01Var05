package ro.pub.cs.systems.eim.practicaltest01var05;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PracticalTest01Var05SecondaryActivity extends AppCompatActivity {

    private TextView textView;
    private Button verifyButton;
    private Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var05_secondary);

        textView = findViewById(R.id.textView);
        verifyButton = findViewById(R.id.verifyButton);
        cancelButton = findViewById(R.id.cancelButton);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("text")) {
            String text = intent.getStringExtra("text");
            textView.setText(text);
        }

        verifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK, null);
                finish();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED, null);
                finish();
            }
        });
    }
}