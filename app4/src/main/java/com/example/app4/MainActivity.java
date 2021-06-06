package com.example.app4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private EditText edt1;
private TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout LL=(LinearLayout) this.findViewById(R.id.mainLL);
        this.edt1=new EditText(this);
        this.edt1.setText("Type the text");
        LL.addView(this.edt1);
        Button B=new Button(this);
        B.setText("Button");
        LL.addView(B);
        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=MainActivity.this.edt1.getText().toString();
                MainActivity.this.tv1.setText(txt);
            }
        });
        this.tv1=new TextView(this);
        this.tv1.setText("Hello World");
        LL.addView(this.tv1);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}