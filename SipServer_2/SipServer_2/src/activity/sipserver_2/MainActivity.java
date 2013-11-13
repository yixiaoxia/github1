package activity.sipserver_2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button btn1=(Button)this.findViewById(R.id.btn_userAct);
		btn1.setOnClickListener(listener);
		Button btn2=(Button)this.findViewById(R.id.btn_server);
		btn2.setOnClickListener(listener);
		Button btn3=(Button)this.findViewById(R.id.btn_test);
		btn3.setOnClickListener(listener);
	}
	OnClickListener listener=new OnClickListener(){
		Intent intent;
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.btn_userAct:
				intent=new Intent(MainActivity.this,User_Authentication.class);
				MainActivity.this.startActivity(intent);
				break;
			case R.id.btn_server:
				intent=new Intent(MainActivity.this,ServerActivity.class);
				MainActivity.this.startActivity(intent);
				break;
			case R.id.btn_test:
				intent=new Intent(MainActivity.this,TestActiviy.class);
				MainActivity.this.startActivity(intent);
				break;
			}
		}
		
	};

}
