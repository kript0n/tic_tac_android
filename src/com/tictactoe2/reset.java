package com.tictactoe2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class reset extends MainActivity implements OnClickListener{
	
	Button yes, no;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reset);
		
		yes = (Button)findViewById(R.id.button1); //������ ��
		no = (Button)findViewById(R.id.button2); //������ ���
		yes.setOnClickListener(this); 
		no.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		Intent intent = new Intent();
		Button btnCheck = (Button)v;
		if(btnCheck.getId() == R.id.button1) {
			intent.putExtra("newGame", true); //���� ������ "��", �� ���������� true
		}
		else if(btnCheck.getId() == R.id.button2) {
			intent.putExtra("newGame", false); //���� ���, �� false
		}
		setResult(RESULT_OK, intent); //���������� ��������� ��� Activity Main
		finish();
	}
	
}
