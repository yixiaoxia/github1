package activity.sipserver_2;

import java.util.HashMap;
import java.util.LinkedList;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class UserAdapter extends BaseAdapter {
	int mCount = 0;
	Context mContext;
	Cursor mCursor;
	Activity mAct;
	LayoutInflater mInflater;
	HashMap<Integer,String> mDeleteUserId;
	private final int CHECKBOXIDINIT=100;
	private final int USERIDINIT=10000000;
	public UserAdapter(Cursor cursor, Activity act,HashMap<Integer,String> listuser) {
		mCursor = cursor;
		mCount = cursor.getCount();
		mDeleteUserId=listuser;
		mAct=act;
		mContext=mAct;
		mInflater = LayoutInflater.from(mContext);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mCount;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Log.e("song","position =" +position);
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item, null);
			setConvertView(convertView, mCursor, position);
		} else {
			convertView = mInflater.inflate(R.layout.item, null);
			setConvertView(convertView, mCursor, position);
		}
		return convertView;
	}

	void setConvertView(View convertView, Cursor cursor, int position) {
		RelativeLayout layout = (RelativeLayout) convertView;
		CheckBox checkbox= (CheckBox) convertView.findViewById(R.id.checkbox);
		TextView user = (TextView) convertView.findViewById(R.id.TextView_0);
		TextView name = (TextView) convertView.findViewById(R.id.TextView_1);
		TextView email = (TextView) convertView.findViewById(R.id.TextView_2);
		TextView description = (TextView) convertView
				.findViewById(R.id.TextView_3);
		TextView[] view={user,name,email,description};
		checkbox.setId(CHECKBOXIDINIT+position);
		checkbox.setOnCheckedChangeListener(listener);
		user.setId(USERIDINIT+position);
		cursor.moveToPosition(position);
		for (int i = 0; i < 4; i++) {
			String s=cursor.getString(i);
			view[i].setText(s);
		}
	}
	OnCheckedChangeListener listener=new OnCheckedChangeListener(){

		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			// TODO Auto-generated method stub
			int id=buttonView.getId();
			int strid=id-CHECKBOXIDINIT+USERIDINIT;
			 Log.e("song","buttonview id= "+buttonView.getId());
			if(isChecked){
			}else{
				mDeleteUserId.remove(id);
			}
		}

	
	};
	
	
}
