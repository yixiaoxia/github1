package activity.sipserver_2;




import local.server.ServerProfile;
import local.server.StatefulProxy;

import org.zoolu.sip.provider.SipProvider;
import org.zoolu.sip.provider.SipStack;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ServerActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_server);
		Button b=(Button)this.findViewById(R.id.button1);
		b.setOnClickListener(listener);
		
		
	}
	
	OnClickListener listener=new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.button1:
				StartServer();
				break;
			case R.id.button2:
				
			
			}
		}
	};
	void StartServer(){
		SipStack.init(null);
		SipProvider sip_provider = new SipProvider(null);
		ServerProfile server_profile = new ServerProfile(null);

		StatefulProxy sproxy = new StatefulProxy(sip_provider, server_profile);
		
	}
	
}
