package ro.pub.cs.systems.eim.practicaltest01var04;

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

public class PracticalTest01Var04SecondaryActivity extends AppCompatActivity {

    private Button btnOk, btnCancel;
    private TextView text1, text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_practical_test01_var04_secondary);

        String t1 = getIntent().getStringExtra("text1");
        String t2 = getIntent().getStringExtra("text2");

        text1 = findViewById(R.id.textView3);
        text2 = findViewById(R.id.textView4);
        text1.setText(String.valueOf(t1));
        text2.setText(String.valueOf(t2));

        Intent intentToParent = new Intent();


        btnOk = findViewById(R.id.ok_button);
        btnCancel = findViewById(R.id.cancel_button);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                intentToParent.putExtra("RESULT_MSG", "OK pressed");
                setResult(RESULT_OK, intentToParent);
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                intentToParent.putExtra("RESULT_MSG", "Cancel pressed");
                setResult(RESULT_CANCELED, intentToParent);
                finish();
            }
        });
    }
}