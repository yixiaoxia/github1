package activity.sipserver_2;

import database.DataBaseHelper;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TestActiviy extends Activity {
	DataBaseHelper dbhelper;
	Button b1,b2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test_activiy);
		dbhelper=new DataBaseHelper(this);
		b1=(Button)this.findViewById(R.id.button1);
		b2=(Button)this.findViewById(R.id.button2);
		b1.setOnClickListener(l);
		b2.setOnClickListener(l);
	}
	OnClickListener l=new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.button1:
				   String name="song";
				   String att="111111";
				   ContentValues cv = new ContentValues();
				   cv.put(DataBaseHelper.Reg_NAME, name);
				   cv.put(DataBaseHelper.Reg_STR, att);
				   dbhelper.insert(DataBaseHelper.TABLE_NAME1, cv);
				break;
			case R.id.button2:
				break;
			}
		}
		
	};


}
