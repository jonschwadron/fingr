package net.schwadron.fingr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
  
public class Splash extends Activity {
 
        private final int SPLASH_DISPLAY_LENGTH = 3000;

        /** Called when the activity is first created. */
 
        @Override
        public void onCreate(Bundle icicle) {
                 super.onCreate(icicle);
                 setContentView(R.layout.splash);
              
                 /* New Handler to start the Menu-Activity
                  * and close this Splash-Screen after some seconds.*/
                 new Handler().postDelayed(new Runnable(){
 
                        @Override
                         public void run() {
                                 /* Create an Intent that will start the Menu-Activity. */
                                 Intent mainIntent = new Intent(Splash.this,Main.class);
                                 Splash.this.startActivity(mainIntent);
                                 overridePendingTransition(R.anim.mainfadein, R.anim.splashfadeout);
                                 Splash.this.finish();
                         }
                 }, SPLASH_DISPLAY_LENGTH);
         }
 }

//Jonathan Schwadron
//Mobile Application Development
//Final Project Fall 2013