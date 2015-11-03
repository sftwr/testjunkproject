package cs.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    public ImageButton myIB;
    private int status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.myIB = (ImageButton) findViewById(R.id.imageButton);

        this.myIB.setDrawingCacheEnabled(true);
        this.myIB.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent me) {
        //on touch events
        if (me.getAction() == MotionEvent.ACTION_DOWN) {
            status = 0;
        }
        if (me.getAction() == MotionEvent.ACTION_UP) {
            status = 1;
        } else if (me.getAction() == MotionEvent.ACTION_MOVE) {
            if (status == 0) {
                //raw to the imagebuttons x y needs offset because of screen borders/padding/the actionbar I believe

                this.myIB.setX(me.getRawX() - this.myIB.getWidth()/2);
                this.myIB.setY(me.getRawY() - 330);


            }
        }
        return false;
    }
}
