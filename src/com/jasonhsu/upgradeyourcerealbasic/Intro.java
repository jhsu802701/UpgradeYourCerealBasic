// This script controls the Introduction screen, which introduces you
// to the app and provides a Continue button.

package com.jasonhsu.upgradeyourcerealbasic;

// Added by pressing Shift-Ctrl-o
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Intro extends Activity {

	Button ButtonCont; // Initializes button
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro); // Uses the setup from res/layout/intro.xml
        addContinueButton(); // Adds the continue button
    }

	public void addContinueButton() { 
		final Context context = this;
		// button = ButtonCont (Continue button) from res/layout/main.xml
		ButtonCont = (Button) findViewById(R.id.button1);
		
		// Defines what happens when the Continue button is clicked
		ButtonCont.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// Run src/com.jasonhsu.upgradeyourcereal/SelectCereal.java 
			    Intent intent = new Intent(context, SelectCereal.class);
                startActivity(intent);   
			}
 
		});
 
	}

}