package com.example.communicationtest;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText inputText;
    private TextView outputText;
    private Button buttonStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.inputText);
        outputText = findViewById(R.id.outputTextView);
        buttonStart = findViewById(R.id.button);



        buttonStart.setOnClickListener(view -> {
            SortArray sort = new SortArray();
            String orderedMar = sort.sortArray(Integer.parseInt(inputText.getText().toString()));
            Log.d("serverI", "-------------cklicked----------------"+orderedMar);
            TCPClient task = new TCPClient(outputText,inputText.getText().toString());
            Thread thread = new Thread(task);
            thread.start();

            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


    }
}