package app.ply.rundomnums;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;

import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("ShowToast")
public class MainActivity extends Activity {
	private String[] list = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
	private ArrayList<String> listNow = new ArrayList<String>(Arrays.asList(list));
	private Random runNumber = new Random();
	private String name;
	private int runNum;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		Button btn = (Button) findViewById(R.id.btn_run);
		Button btnReset = (Button)findViewById(R.id.btn_reset);
		Button btnSummit = (Button) findViewById(R.id.btn_sumit);
		
		btn.setOnClickListener(new View.OnClickListener() {
		
			@Override
			public void onClick(View v) {
				if(listNow.size()==0){
					name = "end";
				} else {
					runNum = runNumber.nextInt(listNow.size());
					name = listNow.get(runNum);
					
				}
				TextView txtNum = (TextView) findViewById(R.id.txt_run);
				txtNum.setText(name);
				
			}
		});
		
		btnReset.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				listNow = new ArrayList<String>(Arrays.asList(list));
				TextView txtNum = (TextView) findViewById(R.id.txt_run);
				txtNum.setText("start");
			}
		});
		
		btnSummit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				listNow.remove(runNum);
				Toast.makeText(MainActivity.this, name+"ได้เลือกแล้ว", 3000)
				.setGravity(Gravity.CENTER_VERTICAL, 0, 0);

			}
		});
		
	}

}
