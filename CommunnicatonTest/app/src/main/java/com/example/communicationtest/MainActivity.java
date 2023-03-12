package com.example.communicationtest;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private EditText inputText;
    private TextView outputText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.inputText);
        outputText = findViewById(R.id.outputTextView);


        inputText.setOnClickListener(view -> {
            Log.d("serverI", "-------------cklicked----------------");
            TCPClient task = new TCPClient();
            task.connect(outputText);
            try {
                task.send(inputText.getText().toString());
                Log.d("serverT", "-------------textet----------------");
            } catch (IOException e) {
                e.printStackTrace();
            }
            task.run();
        });
    }
}