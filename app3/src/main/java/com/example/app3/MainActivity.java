package com.example.app3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private TextView tvClickInfo;
private TextView tvMotionInfo;
private int cntClick;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.tvClickInfo=(TextView) this.findViewById(R.id.tvClickInfo);
        this.tvMotionInfo=(TextView) this.findViewById(R.id.tvMotionInfo);
        LinearLayout LL=(LinearLayout) this.findViewById(R.id.ll1);
        LL.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action=event.getAction();
                float x=event.getX();
                float y=event.getY();
                String S="";
                switch (action){
                    case MotionEvent.ACTION_DOWN:
                        S+="Нажатие\n";
                        break;
                        case MotionEvent.ACTION_MOVE:
                            S+="Перемещение\n";
                            break;
                            case MotionEvent.ACTION_UP:
                                S+="Отпускание\nY = "+y;
                                break;
                }
                S+="X = "+x+"\nY = "+y;
                MainActivity.this.tvMotionInfo.setText(S);
                return false;
            }
        });
        LL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.cntClick++;
                MainActivity.this.tvClickInfo.setText(
                        "Количество кликов : "+MainActivity.this.cntClick
                );
            }
        });
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

        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}