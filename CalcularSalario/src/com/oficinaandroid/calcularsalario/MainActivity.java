package com.oficinaandroid.calcularsalario;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activiy_main);
		
		Button btn_calcular = (Button) findViewById(R.id.btn_calcular);
		
		final TextView resultado = (TextView) findViewById(R.id.resultado);
		
		btn_calcular.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				double salario, novo_sal = 0;
				
				EditText edsalario = (EditText) findViewById(R.id.edsalario);
				
				salario = Double.parseDouble(edsalario.getText().toString()); //Pega texto -> string -> Double
				
				if(Double.parseDouble(edsalario.getText().toString()) == 0){ //Verifica o valor do edsalario se for igual a 0 não realiza o calculo e alerta o usuario atraz de uma caixa
					AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
					dialogo.setTitle("Erro!");
					dialogo.setMessage("Digite um valor!");
					dialogo.setNeutralButton("OK", null);
					dialogo.show();
				} else {
				RadioGroup rg = (RadioGroup) findViewById(R.id.rgopcoes); //Reconhecimento do RadioGroup
				

				
				int op = rg.getCheckedRadioButtonId(); //Retorna o id do RB selecionado

					if(op==R.id.rb40){
						novo_sal = salario + (salario * 0.4);
						TextView resultado = (TextView) findViewById(R.id.resultado);
						resultado.setText("R$"+ novo_sal);
					} else {
						if(op==R.id.rb45){
							novo_sal = salario + (salario * 0.45);
							TextView resultado = (TextView) findViewById(R.id.resultado);
							resultado.setText("R$"+ novo_sal);
						} else { 
								if (op==R.id.rb50)	{
								novo_sal = salario + (salario * 0.5);
								TextView resultado = (TextView) findViewById(R.id.resultado);
								resultado.setText("R$"+ novo_sal);
							} 
							else {
								AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
								dialogo.setTitle("Erro!");
								dialogo.setMessage("Selecione um percentual!");
								dialogo.setNeutralButton("OK", null);
								dialogo.show();
							}
						}
					}
				}
			} 
		});
	}

}
