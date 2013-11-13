package activity.sipserver_2;

import tools.StaticClass;
import database.DataBaseHelper;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Act_newUser extends Activity {
	ContentValues cv;
	String Stredit = "editText";
	String[] DATAKEY = { "",DataBaseHelper.USER_ID, DataBaseHelper.USER_PASSWORD,"",
			DataBaseHelper.USER_NAME, DataBaseHelper.USER_EMAIL,
			DataBaseHelper.USER_DESCRIPTION };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_user);
		cv = new ContentValues();
		
		Button btn1 = (Button) this.findViewById(R.id.button1);
		Button btn2 = (Button) this.findViewById(R.id.button2);
		btn1.setOnClickListener(listener);
		btn2.setOnClickListener(listener);
	}

	OnClickListener listener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.button1:
				saveDataBase();
				break;
			case R.id.button2:
				finish();
				break;
			}
		}
	};

	void saveDataBase() {
		EditText useredit=(EditText)this.findViewById(R.id.editText1);
		if(useredit.getText().toString()==null){
			Toast.makeText(this,
					"Invalid characters were entered. (User Name)",
					Toast.LENGTH_SHORT).show();
			return;
		}
		EditText passwordedit=(EditText)this.findViewById(R.id.editText2);
		EditText confirm=(EditText)this.findViewById(R.id.editText3);
		if(!passwordedit.getText().toString().equals(confirm.getText().toString())){
			Toast.makeText(this,
					"The passwords you typed did not match.",
					Toast.LENGTH_SHORT).show();
			return;
		}
		
		for (int i = 1; i < 7; i++) {
			int id = StaticClass.getResourdIdByResourdName(Stredit + i);
			EditText edit = (EditText) this.findViewById(id);
			String s = edit.getText().toString();
			if(i==2||s.equals("")){continue;}
			cv.put(DATAKEY[i], s);
		}
		DataBaseHelper databasehelper=new DataBaseHelper(this);
		databasehelper.insert(DataBaseHelper.TABLE_NAME,cv);
		finish();
		
	}
}
