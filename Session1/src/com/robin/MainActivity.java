package com.robin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		findViewById(R.id.button1).setOnClickListener(this);
		findViewById(R.id.button2).setOnClickListener(this);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
         switch(requestCode){
         case 1001:
        	 if(resultCode == RESULT_OK){
        		 Bundle bundle = data.getExtras();
        		 String msg = bundle.getString("ReturnVal");
        		 TextView tv = (TextView)findViewById(R.id.textView1);
        		 tv.setText(msg);
        	 }
        	 break;
         }
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = null;
		switch (v.getId()) {
		case R.id.button1:
			intent = new Intent(MainActivity.this, SubActivity.class);
			intent.putExtra("Msg", "from MainActivity!");
			startActivity(intent);
			break;
		case R.id.button2:
			intent = new Intent(MainActivity.this, SubActivity.class);
			intent.putExtra("Msg", "from MainActivity!");
			startActivityForResult(intent, 1001);
			break;
		}
	}
}