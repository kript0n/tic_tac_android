package com.tictactoe2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity implements  OnClickListener {

	int squad[] = new int [9];
	ImageButton bt; 
	Drawable picX,picO; 
	int count=1,b=0;	
	ImageButton bt1[];
	boolean newGame = false;//Создавать ли новую игру?
	boolean EndGame = false;//Конец игры?

	
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);
	    
	    bt1 = new ImageButton[] //Задаем массив ImageButton
	    {			
	    		(ImageButton)findViewById(R.id.imageButton1),
				(ImageButton)findViewById(R.id.imageButton2),			
				(ImageButton)findViewById(R.id.imageButton3),
				(ImageButton)findViewById(R.id.imageButton4),
				(ImageButton)findViewById(R.id.imageButton5),
				(ImageButton)findViewById(R.id.imageButton6),
				(ImageButton)findViewById(R.id.imageButton7),
				(ImageButton)findViewById(R.id.imageButton8),
				(ImageButton)findViewById(R.id.imageButton9)
		};
	    
	    for(int i = 0; i < 9; i++) {
	    	bt1[i].setOnClickListener(this); //Для каждой кнопки задаем онклик листенер
	    	
	    	squad[i] = 0; //Обнуляем массив, потому что сначала в нем хранится мусор, и вполне возможно,
	    	//что какая то из ячеек будет равна 1 или -1, из-за чего будут баги 
	    }
	}
	
/*-------------------------------Функция рисования------------------------------------*/	
	
	private void draw() {
		for(int i=0;i<9;i++) {
			if(squad[i] == 1) {//Если в массиве 1, то рисуем крест
				bt1[i].setImageResource(R.drawable.crest);
				bt1[i].setClickable(false);
			}
			else if(squad[i] == -1) { //Если минус 1, то ноль
				bt1[i].setImageResource(R.drawable.zero); 
				bt1[i].setClickable(false);
			}
			if(EndGame) bt1[i].setClickable(false);//Если игра закончена, блокируем все кнопки
		}
	}
	
/*------------------------------------------------------------------------------------*/	
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	    bt=(ImageButton)v;
		if (count==1) {
		    count++;	
		    switch(bt.getId()){
				case R.id.imageButton1:
					squad[0] = 1;
					break;
				case R.id.imageButton2:
					squad[1] = 1;
					break;
				case R.id.imageButton3:
					squad[2] = 1;
					break;
				case R.id.imageButton4:
					squad[3] = 1;
					break;
				case R.id.imageButton5:
					squad[4] = 1;
					break;
				case R.id.imageButton6:
					squad[5] = 1;
					break;
				case R.id.imageButton7:
					squad[6] = 1;
					break;
				case R.id.imageButton8:
					squad[7] = 1;
					break;
				case R.id.imageButton9:
					squad[8] = 1;
					break;
				default: break;
			}
		}
		else  {
            count--;
          	switch(bt.getId()){
		  		case R.id.imageButton1:
		  			squad[0] = -1;
		  			break;
		  		case R.id.imageButton2:
		  			squad[1] = -1;
		  			break;
		  		case R.id.imageButton3:
		  			squad[2] = -1;
		  			break;
		  		case R.id.imageButton4:
		  			squad[3] = -1;
		  			break;
		  		case R.id.imageButton5:
		  			squad[4] = -1;
		  			break;
		  		case R.id.imageButton6:
		  			squad[5] = -1;
		  			break;
		  		case R.id.imageButton7:
		  			squad[6] = -1;
		  			break;
		  		case R.id.imageButton8:
		  			squad[7] = -1;
		  			break;
		  		case R.id.imageButton9:
		  			squad[8] = -1;
		  			break;
		  			default: break;
            }
	 
	}
	check(); //Проверяем на победителя
	draw(); //Отрисовываем.
	/* Сначала проверяем потом отрисовываем, иначе будет возможность после победы заполнить еще одну кнопку*/
	b++;	
	if(EndGame) startActReset(); //Если игра закончена, создаем активити с диалогом

}
    
	private void check(){ 
    	if ( 
    		 (squad[0] + squad[1] + squad[2] == 3) ||
    		 (squad[0] + squad[4] + squad[8] == 3) ||
    		 (squad[0] + squad[3] + squad[6] == 3) ||
    		 (squad[1] + squad[4] + squad[7] == 3) ||
    		 (squad[2] + squad[5] + squad[8] == 3) ||
    		 (squad[3] + squad[4] + squad[5] == 3) ||
    		 (squad[6] + squad[4] + squad[2] == 3) ||
    		 (squad[6] + squad[7] + squad[8] == 3) 
    		)  
    	{
    		Toast.makeText(this,"Выиграли Крестики" , Toast.LENGTH_LONG).show();
    		EndGame = true;//Победитель найден, игра закончена
    	}
    	
    	else if ( 
       		 (squad[0] + squad[1] + squad[2] == -3) ||
       		 (squad[0] + squad[4] + squad[8] == -3) ||
       		 (squad[0] + squad[3] + squad[6] == -3) ||
       		 (squad[1] + squad[4] + squad[7] == -3) ||
       		 (squad[2] + squad[5] + squad[8] == -3) ||
       		 (squad[3] + squad[4] + squad[5] == -3) ||
       		 (squad[6] + squad[4] + squad[2] == -3) ||
       		 (squad[6] + squad[7] + squad[8] == -3) 
       		)   
    	{
    		Toast.makeText(this,"Выиграли Нолики" , Toast.LENGTH_LONG).show();
    		EndGame = true;//Победитель найден, игра закончена
    	}
    	
    	else if(b==8) {
    		EndGame = true;//Если все кнопки заняты, игра закончена
    		Toast.makeText(this,"Ничья" , Toast.LENGTH_LONG).show();
    	}
    }
	
	
	
	//-------------------------Запускаем новую активити с ожиданием результата------//
	
	private void startActReset() {
		Intent resetAct = new Intent(this, reset.class);
		startActivityForResult(resetAct, 1);		
	}
	
	//------------------------------------------------------------------------------//
	
	
	
	//------------Как только получили результат вызывается эта функция--------------//
	
	@Override 
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(data == null) return;
		newGame = data.getBooleanExtra("newGame", false);//получаем какая кнопка нажата
		reset(); //вызываем функцию сброса
	}
	
	//------------------------------------------------------------------------------//
	
	
	
	//--------------------------------Функция сброса--------------------------------//
	
	private void reset() {
		if(newGame) { //Если была нажата кнопка "Да"
			for(int i=0;i<9;i++) {
				squad[i] = 0; //Очищаем массив
				bt1[i].setImageResource(R.drawable.background); //Закрашиваем фоном
				bt1[i].setClickable(true); //Делаем кликабельными
			}
			EndGame = false; //Конец игры false
			b = 0; //Сбрасываем счетчик ничьи
			draw(); //Отрисовываем
		}
		else finish(); //Если кнопка "Нет", то завершаем работу приложения
	}
	
	//------------------------------------------------------------------------------//
}