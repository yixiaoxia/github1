package tools;

import java.lang.reflect.Field;

import activity.sipserver_2.R;




public class StaticClass {
	public static int Error_id=100;
	
	public static int getResourdIdByResourdName(String ResName) {
		int resourceId = 0;
		try {

			Field field = R.id.class.getField(ResName);
			field.setAccessible(true);
			resourceId = field.getInt(null);
		} catch (Exception e) {
			e.printStackTrace();
			resourceId = 0;
		}
		return resourceId;
	}
	public static int getError_id(){
		
		return Error_id++;
	}
}
