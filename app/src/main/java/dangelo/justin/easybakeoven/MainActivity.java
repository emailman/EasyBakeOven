package dangelo.justin.easybakeoven;


/**
 * OVEN APP
 * CANNOT GET TIMER TO WORK PROPERLY
 */

import android.content.pm.ActivityInfo;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity
    {
        private static final String TAG = "JUSTIN";
        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }

        int timerZ = 0; int timerY = 0;
        int timerX = 0; int timerW = 0;
        int finalTime = 0;

        public int timeSet(int a)
        {
            if (timerW == 0)
            {
                timerW = timerX;
                timerX = timerY;
                timerY = timerZ;
                timerZ = a;
            }
            return a;
        }

        public void ClickEvent(View v) throws InterruptedException
        {

            final ImageView imgCookie = (ImageView) findViewById(R.id.imageCookie);

            switch(v.getId())
            {
                case R.id.btn1: timeSet(1);
                    Log.d(TAG,"Button 1 pressed");
                    break;
                case R.id.btn2: timeSet(2);
                    Log.d(TAG,"Button 2 pressed");
                    break;
                case R.id.btn3: timeSet(3);
                    Log.d(TAG,"Button 3 pressed");
                    break;
                case R.id.btn4: timeSet(4);
                    Log.d(TAG,"Button 4 pressed");
                    break;
                case R.id.btn5: timeSet(5);
                    Log.d(TAG,"Button 5 pressed");
                    break;
                case R.id.btn6: timeSet(6);
                    Log.d(TAG,"Button 6 pressed");
                    break;
                case R.id.btn7: timeSet(7);
                    Log.d(TAG,"Button 7 pressed");
                    break;
                case R.id.btn8: timeSet(8);
                    Log.d(TAG,"Button 8 pressed");
                    break;
                case R.id.btn9: timeSet(9);
                    Log.d(TAG,"Button 9 pressed");
                    break;
                case R.id.btn0: timeSet(0);
                    Log.d(TAG,"Button 0 pressed");
                    break;

            }

            String time = (timerX + "" + timerW);
            int timeMinutes = Integer.parseInt(time);

            finalTime = (timeMinutes * 60) + timerY + timerZ;
            int timeInMilli = finalTime * 1000;

            switch(v.getId())
            {

                case R.id.btnStart:
                    Log.d(TAG,"Button Start pressed");
                   while (timeInMilli > 0)
                    {
                        Thread.sleep(1000);
                        timeInMilli -= 1000;
                    }
                    timerZ = 0; timerY = 0; timerW = 0; timerX = 0;
                    imgCookie.setImageResource(R.drawable.cookie);
                    Toast toast = Toast.makeText(this,"Ding!",Toast.LENGTH_LONG);
                    toast.show();


                    //SHOULD CAUSE THE TIME TO COUNTDOWN BUT DOES NOT
                   /** new CountDownTimer(timeInMilli,1000){
                        @Override
                        public void onTick(long millisUntilFinished) {
                            int seconds = (timeInMilli / 1000) % 60 ;
                            int minutes = ((timeInMilli / (1000*60)) % 60);
                            ((TextView)findViewById(R.id.txtTimer)).setText(""+String.format("%d min, %d sec",
                                    TimeUnit.MILLISECONDS.toMinutes( millisUntilFinished),
                                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
                        }

                        @Override
                        public void onFinish() {
                            timerZ = 0; timerY = 0; timerW = 0; timerX = 0;
                            imgCookie.setImageResource(R.drawable.cookie);
                        }

                    };*/
                    break;

                case R.id.btnReset:
                    Log.d(TAG,"Button Reset pressed");
                    timerZ = 0; timerY = 0; timerW = 0; timerX = 0;
                    break;
                case R.id.imageCookie:
                    Log.d(TAG,"Cookie Removed");
                    imgCookie.setImageResource(R.drawable.cookiedough);
                    break;
            }

            ((TextView)findViewById(R.id.txtTimer)).setText
                   (timerW + "" + timerX + ":" + timerY + "" + timerZ);
        }
    }

//}