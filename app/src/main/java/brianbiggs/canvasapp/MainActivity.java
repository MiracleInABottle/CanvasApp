package brianbiggs.canvasapp;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements SurfaceHolder.Callback{
    SurfaceView surfaceView;

    Paint white = new Paint();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        surfaceView = (SurfaceView)findViewById(R.id.surfaceView);
        surfaceView.getHolder().addCallback(this);
        Button entBtn = (Button)findViewById(R.id.enterBtn);
        final EditText xc = (EditText)findViewById(R.id.xVar);
        final EditText yc = (EditText)findViewById(R.id.yVar);

        entBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String xx = xc.getText().toString();
                Float x1 = Float.parseFloat(xx);
                String yy = yc.getText().toString();
                Float y1 = Float.parseFloat(yy);
                //drawDots(x1, y1);

            }
        });

    }

    public void drawLines(SurfaceHolder holder){

        float bl[] = new float[] {50, 0, 50, 850, 50, 850, 1000, 850};

        Paint baseLine = new Paint ();
        final Canvas c = holder.lockCanvas();
        white.setColor(Color.WHITE);
        white.setStrokeWidth(3);
        baseLine.setColor(Color.WHITE);
        baseLine.setStrokeWidth(10);
        c.drawLines(bl, 0, 8, baseLine);
        holder.unlockCanvasAndPost(c);
        final EditText xc = (EditText)findViewById(R.id.xVar);
        final EditText yc = (EditText)findViewById(R.id.yVar);
        Button entBtn = (Button)findViewById(R.id.enterBtn);
        entBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String xx = xc.getText().toString();
                Float x1 = Float.parseFloat(xx);
                String yy = yc.getText().toString();
                Float y1 = Float.parseFloat(yy);
                c.drawCircle(x1, y1, 5, white);
            }
        });

    }


    public void surfaceCreated(SurfaceHolder holder){
        drawLines(holder);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        drawLines(holder);
    }

    public void surfaceDestroyed(SurfaceHolder holder){
        drawLines(holder);
    }



}
