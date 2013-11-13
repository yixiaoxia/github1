package activity.sipserver_2;

import java.util.HashMap;
import java.util.LinkedList;

import database.DataBaseHelper;
import android.os.Bundle;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

public class User_Authentication extends Activity {
	DataBaseHelper databasehelper;
//	LinkedList<String> mDeleteUserId;
	HashMap<Integer,String> mDeleteUserId;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user__authentication);
		Button bNew=(Button)this.findViewById(R.id.new_user);
		Button bDelete=(Button)this.findViewById(R.id.delete_user);
		bNew.setOnClickListener(btnlistener);
		bDelete.setOnClickListener(btnlistener);
		databasehelper=new DataBaseHelper(this);
		mDeleteUserId=new HashMap<Integer,String>();
	}
	

	@Override
	protected void onStart() {
		super.onStart();
		ListView list=(ListView)this.findViewById(R.id.listView1);
		Cursor cursor=databasehelper.select(DataBaseHelper.TABLE_NAME);
		UserAdapter Adapter=new UserAdapter(cursor,this,mDeleteUserId);
		list.setAdapter(Adapter);
	}


	OnClickListener btnlistener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
		  switch(v.getId()){
		  case R.id.new_user:
			  Intent intent=new Intent(User_Authentication.this,Act_newUser.class);
			  User_Authentication.this.startActivity(intent);
			  break;
		  case R.id.delete_user:
			  break;
		  }
		}
	};
}
