package com.example.quizapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {

    TextView tv1,tv2,tv3;
    Button btnRestart;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tv1 = findViewById(R.id.tvres);
        tv2 = findViewById(R.id.tvres2);
        tv3 = findViewById(R.id.tvres3);
        result = findViewById(R.id.tvres4);

        btnRestart = (Button) findViewById(R.id.btnRestart);

        StringBuffer sb = new StringBuffer();
        sb.append("Correct Answer" + questionActivity.correct+ "\n");

        StringBuffer sb2 = new StringBuffer();
        sb2.append("Wrong Answer" + questionActivity.wrong +"\n");

        StringBuffer sb3 = new StringBuffer();
        sb3.append("Score " + questionActivity.correct + "\n");

        StringBuffer sb4 = new StringBuffer();
        sb4.append(questionActivity.correct + "/" + "5");

        tv1.setText(sb);
        tv2.setText(sb2);
        tv3.setText(sb3);
        result.setText(sb4);

        questionActivity.correct =0;
        questionActivity.wrong =0;

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });







    }
}