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
		
		yes = (Button)findViewById(R.id.button1); //Кнопка да
		no = (Button)findViewById(R.id.button2); //Кнопка нет
		yes.setOnClickListener(this); 
		no.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		Intent intent = new Intent();
		Button btnCheck = (Button)v;
		if(btnCheck.getId() == R.id.button1) {
			intent.putExtra("newGame", true); //Если нажали "Да", то записываем true
		}
		else if(btnCheck.getId() == R.id.button2) {
			intent.putExtra("newGame", false); //Если нет, то false
		}
		setResult(RESULT_OK, intent); //Отправляем результат для Activity Main
		finish();
	}
	
}
