package com.example.quizapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class questionActivity extends AppCompatActivity {

    String question[] = {
            "Who is the father of C language?",
            "All keywords in C are in __",
            "Which of the following is not a valid C variable name?",
            "Which is valid C expression?",
            "Which of the following cannot be a variable name in C?"

    };
    String answer[] = {
            "Dennis Ritchie",
            "LowerCase letters",
            " int $main;",
            "int my_num = 100000;",
            "volatile"
    };
    String option[] = {
            "Steve Jobs", " James Gosling", "Dennis Ritchie", "Rasmus Lerdorf",
            "LowerCase letters", "UpperCase letters", "CamelCase letters", " None of the mentioned",
            "int number;", "float rate;", "int variable_count;", " int $main;",
            "int my_num = 100,000;", "int my_num = 100000;", "int my_num = 1000", "int $my_num = 10000",
            "volatile", "true", "friend", "export"
    };
    int flag = 0;

    public static int marks =0, correct =0, wrong =0;






    TextView tv;
    Button submit, quit;
    RadioGroup radiog;
    RadioButton rb1,rb2,rb3,rb4;

    private TextView questionNumber;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_question);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final TextView score = (TextView) findViewById(R.id.textview4);
        TextView textView = (TextView)findViewById(R.id.dispName);
        Intent intent = getIntent();

        questionNumber = findViewById(R.id.dispName);
        submit = (Button) findViewById(R.id.button3);
        quit = (Button) findViewById(R.id.button4);
        tv = findViewById(R.id.tvque);


        radiog = (RadioGroup) findViewById(R.id.answerGroup);
        rb1 = (RadioButton) findViewById(R.id.radiobtn);
        rb2 = (RadioButton) findViewById(R.id.radiobtn1);
        rb3 = (RadioButton) findViewById(R.id.radiobtn2);
        rb4 = (RadioButton) findViewById(R.id.radiobtn3);

        tv.setText(question[flag]);
        rb1.setText(option[0]);
        rb2.setText(option[1]);
        rb3.setText(option[2]);
        rb4.setText(option[3]);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radiog.getCheckedRadioButtonId()== -1){
                    Toast.makeText(questionActivity.this, "Please select one option", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton ans = (RadioButton) findViewById(radiog.getCheckedRadioButtonId());
                String ansText = ans.getText().toString();

                if (ansText.equals(answer[flag])){
                    correct++;
                    Toast.makeText(questionActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(questionActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;
                if(score != null){
                    score.setText(""+ correct);

                    if (flag<question.length){
                        tv.setText(question[flag]);
                        rb1.setText(option[flag*4]);
                        rb2.setText(option[flag*4+1]);
                        rb3.setText(option[flag*4+2]);
                        rb4.setText(option[flag*4+3]);
                        questionNumber.setText(flag+"/"+question.length+" Question");

                    }
                    else {
                        marks = correct;
                        Intent in = new Intent(questionActivity.this,ResultActivity.class);
                        startActivity(in);
                    }

                    radiog.clearCheck();

                }

            }
        });

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), ResultActivity.class);
                startActivity(intent1);
            }
        });

    }
}