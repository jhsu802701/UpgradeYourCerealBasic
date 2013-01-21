package com.jasonhsu.upgradeyourcerealbasic;

import java.util.Random;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;

public class SelectCereal extends Activity {
	
    String[] slogan_array; // Initialize slogan_array (string array)
	String slogan;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set up layout from /res/layout/select.xml
        setContentView(R.layout.select);
        
        // Initialize buttons
        Button ButtonAppleJacks;
        Button ButtonCocoaPuffs;
        Button ButtonFrankenberry;
        Button ButtonFrostedFlakes;
        Button ButtonGoldenCrisp;
        Button ButtonHoneycombs;
        Button ButtonLuckyCharms;
        Button ButtonSpecialK;
        Button ButtonTotal;
        Button ButtonTrix;
        
        // Define buttons with definitions from /res/layout/select.xml
        ButtonAppleJacks = (Button) findViewById(R.id.buttonAppleJacks);
        ButtonCocoaPuffs = (Button) findViewById(R.id.buttonCocoaPuffs);
        ButtonFrankenberry = (Button) findViewById(R.id.buttonFrankenberry);
        ButtonFrostedFlakes = (Button) findViewById(R.id.buttonFrostedFlakes);
        ButtonGoldenCrisp = (Button) findViewById(R.id.buttonGoldenCrisp);
        ButtonHoneycombs = (Button) findViewById(R.id.buttonHoneycombs);
        ButtonLuckyCharms = (Button) findViewById(R.id.buttonLuckyCharms);
        ButtonSpecialK = (Button) findViewById(R.id.buttonSpecialK);
        ButtonTotal = (Button) findViewById(R.id.buttonTotal);
        ButtonTrix = (Button) findViewById(R.id.buttonTrix);

        // What happens when a button is clicked
        ButtonAppleJacks.setOnClickListener (new View.OnClickListener() {
        	
        	@Override
            public void onClick(View v) {
        		Resources res = getResources();
        		slogan_array = res.getStringArray(R.array.slogans_applejacks);
        		slogan = StringFromArray(slogan_array);
        		PrintResult (slogan);
        	}
        });
        
        ButtonCocoaPuffs.setOnClickListener (new View.OnClickListener() {
        	@Override
            public void onClick(View v) {
        		Resources res = getResources();
        		slogan_array = res.getStringArray(R.array.slogans_cocoapuffs);
        		slogan = StringFromArray(slogan_array);
        		PrintResult (slogan);        		
        	}
        });
        
        ButtonFrankenberry.setOnClickListener (new View.OnClickListener() {
        	@Override
            public void onClick(View v) {
        		Resources res = getResources();
        		slogan_array = res.getStringArray(R.array.slogans_frankenberry);
        		slogan = StringFromArray(slogan_array);
        		PrintResult (slogan);        		        		
        	}
        });
        
        ButtonFrostedFlakes.setOnClickListener (new View.OnClickListener() {
        	@Override
            public void onClick(View v) {
        		Resources res = getResources();
        		slogan_array = res.getStringArray(R.array.slogans_frostedflakes);
        		slogan = StringFromArray(slogan_array);
        		PrintResult (slogan);        		        		        		
        	}
        });
        
        ButtonGoldenCrisp.setOnClickListener (new View.OnClickListener() {
        	@Override
            public void onClick(View v) {
        		Resources res = getResources();
        		slogan_array = res.getStringArray(R.array.slogans_goldencrisp);
        		slogan = StringFromArray(slogan_array);
        		PrintResult (slogan);        		        		        		        		
        	}
        });
        
        ButtonHoneycombs.setOnClickListener (new View.OnClickListener() {
        	@Override
            public void onClick(View v) {
        		Resources res = getResources();
        		slogan_array = res.getStringArray(R.array.slogans_honeycombs);
        		slogan = StringFromArray(slogan_array);
        		PrintResult (slogan);        		        		        		        		        		
        	}
        });
        
        ButtonLuckyCharms.setOnClickListener (new View.OnClickListener() {
        	@Override
            public void onClick(View v) {
        		Resources res = getResources();
        		slogan_array = res.getStringArray(R.array.slogans_luckycharms);
        		slogan = StringFromArray(slogan_array);
        		PrintResult (slogan);        		        		        		        		
        	}
        });
        
        ButtonSpecialK.setOnClickListener (new View.OnClickListener() {
        	@Override
            public void onClick(View v) {
        		Resources res = getResources();
        		slogan_array = res.getStringArray(R.array.slogans_specialk);
        		slogan = StringFromArray(slogan_array);
        		PrintResult (slogan);        		        		        		        		        		
        	}
        });
        
        ButtonTotal.setOnClickListener (new View.OnClickListener() {
        	@Override
            public void onClick(View v) {
        		Resources res = getResources();
        		slogan_array = res.getStringArray(R.array.slogans_total);
        		slogan = StringFromArray(slogan_array);
        		PrintResult (slogan);        		        		        		        		        		        		
        	}
        });
        
        ButtonTrix.setOnClickListener (new View.OnClickListener() {
        	@Override
            public void onClick(View v) {
        		Resources res = getResources();
        		slogan_array = res.getStringArray(R.array.slogans_trix);
        		slogan = StringFromArray(slogan_array);
        		PrintResult (slogan);        		        		        		        		        		        		        		
        	}
        });
       
    }
    
    private void PrintResult (String string_local) {
    	// Create popup window
    	LayoutInflater ResultsInflater = (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
    	View PopupResults = ResultsInflater.inflate(R.layout.result, null);
    	final PopupWindow Popup = new PopupWindow(PopupResults, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    	
    	// Display the result in the popup window
    	((TextView)Popup.getContentView().findViewById(R.id.textViewResult)).setText(string_local);
    	
    	// The Close button
    	Button ButtonDismiss = (Button) PopupResults.findViewById (R.id.buttonDismiss);
    	ButtonDismiss.setOnClickListener (new Button.OnClickListener () {
    		@Override
    		public void onClick(View v) {
    			Popup.dismiss();
    		}
    	});
    	
    	Popup.showAtLocation(ButtonDismiss, Gravity.FILL, 0, 0);

    }
    
    private String StringFromArray (String[] array_local) {
    	// If there is more than one possible slogan,
        // one of them is chosen at random.
    	Random generator = new Random();
    	int n_slogan = array_local.length;
        int n_chosen = generator.nextInt(n_slogan);
        
        String slogan_chosen = array_local[n_chosen];
        return slogan_chosen;
    }
        		
}