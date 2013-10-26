package com.example.tpbibliotecamovil;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends Activity {
	private RadioButton radAutor;
	private RadioButton radLibro;
	private RadioButton radCategoria;
	private Button buscarBTN;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		levantarXML();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void levantarXML(){
		radAutor = (RadioButton)findViewById(R.id.radAutor);
		radLibro = (RadioButton)findViewById(R.id.radLibro);
		radCategoria = (RadioButton)findViewById(R.id.radCategoria);
		buscarBTN =(Button)findViewById(R.id.buscarBTN);
	}
	private void asignarEventos() 
	{
		buscarBTN.setOnClickListener(new OnClickListener() 
		{			
			@Override
			public void onClick(View v) 
			{
				if(radAutor.isChecked()){
					
					
				}else{
					if(radLibro.isChecked()){
						
					}else{
						if(radCategoria.isChecked()){
							
						}else{
							//mostrar mensaje que debe seleccionar algo
						}
					}
				}

			}
		});
	}

}
