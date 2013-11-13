package database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

@SuppressLint("NewApi")
public class DataBaseHelper extends SQLiteOpenHelper {
	private final static String DATABASE_NAME = "SipUsers.db";
	private final static int DATABASE_VERSION = 1;
	// table1 Authentication
	public final static String TABLE_NAME = "Users_table";
	public final static String USER_ID = "User";
	public final static String USER_NAME = "Name";
	public final static String USER_PASSWORD = "Password";
	public final static String USER_EMAIL = "Email";
	public final static String USER_DESCRIPTION = "Description";
	public final static String USER_REGISTER = "isRegister";
	public final static String USER_STATE = "State";

	public final static String TABLE_NAME1 = "Registrar_table";
	public final static String Reg_NAME = "Name";
	public final static String Reg_STR = "Contacts";

	public DataBaseHelper(Context context, String name, CursorFactory factory,
			int version, DatabaseErrorHandler errorHandler) {
		super(context, name, factory, version, errorHandler);

	}

	public DataBaseHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	public DataBaseHelper(Context context) {
		this(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		Log.e("song", "onCreate");
		String sql = "CREATE TABLE " + TABLE_NAME1 + " (" + USER_ID
				+ " text primary key, " + USER_NAME + " text, " + USER_EMAIL
				+ " text, " + USER_DESCRIPTION + " text, " + USER_PASSWORD
				+ " text, " + USER_REGISTER + " boolean, " + USER_STATE
				+ " text " + ");";
		String sql1 = "CREATE TABLE " + TABLE_NAME + " (" + Reg_NAME
				+ " text primary key, " + Reg_STR + " text " + ");";
		db.execSQL(sql);
		db.execSQL(sql1);

	}

	/** get table size */
	public int getsize(String tablename){
		int size=0;
		if(tablename==null)return size;
		SQLiteDatabase db = null;
		Cursor cursor = null;
		try {
			db = this.getWritableDatabase();
			cursor = db.query(tablename, null, null, null, null, null, null);
			size=cursor.getCount();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (db != null)
				db.close();
		}
		
		return size;
	}

	
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		Log.e("song", "onUpgrade");
	}

	public Cursor select(String table_name) {
		SQLiteDatabase db = null;
		Cursor cursor = null;
		long row = -1;
		try {
			db = this.getWritableDatabase();
			cursor = db.query(table_name, null, null, null, null, null, null);
			cursor.moveToFirst();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (db != null)
				db.close();
		}
		return cursor;
	}

	DatabaseErrorHandler errorHandler = new DatabaseErrorHandler() {

		@Override
		public void onCorruption(SQLiteDatabase dbObj) {
			// TODO Auto-generated method stub
			Log.e("song", "error database name: " + dbObj.getPath());
		}
	};

	/** add data to database */
	public long insert(String id, String name, String password, String email,
			String description, boolean register, String state) {
		SQLiteDatabase db = null;
		long row = -1;
		try {
			db = this.getWritableDatabase();
			/* ContentValues */
			ContentValues cv = new ContentValues();
			cv.put(USER_ID, id);
			cv.put(USER_NAME, name);
			cv.put(USER_PASSWORD, password);
			cv.put(USER_EMAIL, description);
			cv.put(USER_REGISTER, register);
			cv.put(USER_STATE, state);
			row = db.insert(TABLE_NAME, null, cv);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (db != null)
				db.close();
		}
		return row;
	}

	/** delete data to database for Reg */
	public long insert(String TableName, ContentValues cv) {
		SQLiteDatabase db = null;
		long row = -1;
		try {
			db = this.getWritableDatabase();
			/* ContentValues */
			row = db.insert(TableName, null, cv);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (db != null)
				db.close();
		}
		return row;
	}

	/** delete data to database for User */
	public void delete(String id, String TableName) {
		SQLiteDatabase db = null;
		try {
			db = this.getWritableDatabase();
			String where = USER_ID + " = ?";
			String[] whereValue = { id };
			db.delete(TableName, where, whereValue);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (db != null)
				db.close();
		}
	}

	/** update data */
	public void update(String id, String name, String password, String email,
			String description, boolean register, String state) {
		SQLiteDatabase db = null;
		try {
			db = this.getWritableDatabase();
			String where = USER_ID + " = ?";
			String[] whereValue = { id };

			ContentValues cv = new ContentValues();
			cv.put(USER_ID, id);
			cv.put(USER_NAME, name);
			cv.put(USER_PASSWORD, password);
			cv.put(USER_EMAIL, description);
			cv.put(USER_REGISTER, register);
			cv.put(USER_STATE, state);
			db.update(TABLE_NAME, cv, where, whereValue);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (db != null)
				db.close();
		}

	}

}
