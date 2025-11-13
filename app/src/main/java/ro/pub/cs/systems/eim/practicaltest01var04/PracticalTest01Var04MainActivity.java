package ro.pub.cs.systems.eim.practicaltest01var04;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PracticalTest01Var04MainActivity extends AppCompatActivity {

    private Button second_act_btn, display_btn;
    private TextView text_view;

    private CheckBox checkBox1, checkBox2;

    private EditText name_text, group_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_practical_test01_var04_main);

        display_btn = findViewById(R.id.button2);

        name_text = findViewById(R.id.editText1);
        group_text = findViewById(R.id.editText2);
        text_view = findViewById(R.id.textView);

        display_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if (checkBox1.isChecked() && name_text.getText().toString() == "") {
                    text_view.setText("error");
                } else if (checkBox2.isChecked() && group_text.getText().toString() == "") {
                    text_view.setText("error");
                } else if (checkBox1.isChecked() && checkBox2.isChecked()) {
                    text_view.setText(name_text.getText().toString() + " " + group_text.getText().toString());
                } else if (checkBox1.isChecked()) {
                    text_view.setText(name_text.getText().toString());
                } else if (checkBox2.isChecked()) {
                    text_view.setText(group_text.getText().toString());
                }
            }
        });

        checkBox1 = findViewById(R.id.checkBox1);

        checkBox1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            updateStatus(isChecked);
        });

        checkBox2 = findViewById(R.id.checkBox2);

        checkBox2.setOnCheckedChangeListener((buttonView, isChecked) -> {
            updateStatus(isChecked);
        });

    }

    private void updateStatus(boolean isChecked) {
        String status = isChecked ? "Checked" : "Unchecked";
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putCharSequence("KEY_FIRST_TEXT", name_text.getText().toString());
        savedInstanceState.putCharSequence("KEY_SECOND_TEXT", group_text.getText().toString());
        savedInstanceState.putCharSequence("KEY_DISPLAY_TEXT", text_view.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        CharSequence key1 = savedInstanceState.getCharSequence("KEY_FIRST_TEXT");
        CharSequence key2 = savedInstanceState.getCharSequence("KEY_SECOND_TEXT");
        CharSequence key3 = savedInstanceState.getCharSequence("KEY_DISPLAY_TEXT");
        name_text.setText(key1);
        group_text.setText(key2);
        text_view.setText(key3);
    }
}


