package com.uao.calculadora_imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Atributos
    private EditText PesoText,EdadText,EstaturaText;
    private TextView resultado,mensaje,get_resultado;
    private RadioButton masculino,femenino;
    private Spinner list_actividad;
    private Button btn_salir,btn_calcular,btn_get;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Configurar botones
        btn_salir = findViewById(R.id.btn_salir);
        btn_calcular = findViewById(R.id.btn_calcular);
        btn_get = findViewById(R.id.btn_get);

        btn_salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){exit(v);}
        });
        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){calcular_imc();}
        });

        btn_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){calcular_get();}
        });

        //configurar elementos
        PesoText = findViewById(R.id.PesoText);
        EdadText = findViewById(R.id.EdadText);
        EstaturaText = findViewById(R.id.EstaturaText);
        resultado = findViewById(R.id.resultado);
        mensaje = findViewById(R.id.mensaje);
        masculino = findViewById(R.id.masculino);
        femenino = findViewById(R.id.femenino);
        get_resultado = findViewById(R.id.get_resultado);
        //configurar lista Spinner
        list_actividad = findViewById(R.id.list_actividad);
        String [] opciones = {"Sedentario","Ligera","Moderada","Intensa","Muy intensa","Acción dinámica"};
        ArrayAdapter<String>adapter_ = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,opciones);
        list_actividad.setAdapter(adapter_);

    }
    //Subprocesos
    public void exit(View view){
        finish();
    }

    public void calcular_imc(){
        double suPeso=Double.parseDouble(PesoText.getText().toString());
        double suEstatura= Double.parseDouble(EstaturaText.getText().toString());
        int suEdad=Integer.parseInt(EdadText.getText().toString());
        double resultado_imc=(suPeso/Math.sqrt(suEstatura));
        //Impresión del resultado:
        resultado.setText(String.valueOf(resultado_imc));
        //Lógica de mensaje:
        if(resultado_imc <= 18.5) {mensaje.setText("La persona tiene desnutrición.");}
        else if(resultado_imc>=18.5 && resultado_imc<25){mensaje.setText("La persona tiene bajo peso.");}
        else if(resultado_imc>=25 && resultado_imc<30){mensaje.setText("La persona tiene peso normal.");}
        else if(resultado_imc>=30 && resultado_imc<40){mensaje.setText("La persona tiene problemas de obesidad.");}
        else {mensaje.setText("La persona tiene probleas de obesidad severos.");}

    }
    public void calcular_get(){
        //P: Peso; E: Estatura; I: Edad.
        double elPeso = Double.parseDouble(PesoText.getText().toString());
        double laEstatura= Double.parseDouble(EstaturaText.getText().toString()),gastoEnergeticoTotalBase,gastoEnergeticoTotalFinal;
        int laEdad=Integer.parseInt(EdadText.getText().toString());
        String tipoActividad = list_actividad.getSelectedItem().toString();
        //Condiciones masculino
       if(masculino.isChecked()) {
           gastoEnergeticoTotalBase=66.5+(13.7*elPeso)+(5*laEstatura)-(6.8*laEdad);
           //{"Sedentario","Ligera","Moderada","Intensa","Muy intensa","Acción dinámica"}
           if(tipoActividad.equals("Sedentario")) {
               gastoEnergeticoTotalFinal = (gastoEnergeticoTotalBase * 0.2) + gastoEnergeticoTotalBase;
               get_resultado.setText(String.valueOf(gastoEnergeticoTotalFinal));
           }else if(tipoActividad.equals("Ligero")){
               gastoEnergeticoTotalFinal =(gastoEnergeticoTotalBase*0.3)+gastoEnergeticoTotalBase;
               get_resultado.setText(String.valueOf(gastoEnergeticoTotalFinal));
           }
           else if(tipoActividad.equals("Moderado")){
               gastoEnergeticoTotalFinal =(gastoEnergeticoTotalBase*0.4)+gastoEnergeticoTotalBase;
               get_resultado.setText(String.valueOf(gastoEnergeticoTotalFinal));
           }
           else if(tipoActividad.equals("Intenso")){
               gastoEnergeticoTotalFinal =(gastoEnergeticoTotalBase*0.5)+gastoEnergeticoTotalBase;
               get_resultado.setText(String.valueOf(gastoEnergeticoTotalFinal));
           }
           else if(tipoActividad.equals("Muy intenso")){
               gastoEnergeticoTotalFinal =(gastoEnergeticoTotalBase*0.7)+gastoEnergeticoTotalBase;
               get_resultado.setText(String.valueOf(gastoEnergeticoTotalFinal));
           }
           else if(tipoActividad.equals("Acción dinámica")){
               gastoEnergeticoTotalFinal =(gastoEnergeticoTotalBase*0.1)+gastoEnergeticoTotalBase;
               get_resultado.setText(String.valueOf(gastoEnergeticoTotalFinal));
           }
       }else if(femenino.isChecked()){
           gastoEnergeticoTotalBase=655.1+(9.56*elPeso)+(1.85*laEstatura)-(4.7*laEdad);
           if(tipoActividad.equals("Sedentario")) {
               gastoEnergeticoTotalFinal = (gastoEnergeticoTotalBase * 0.2) + gastoEnergeticoTotalBase;
               get_resultado.setText(String.valueOf(gastoEnergeticoTotalFinal));
           }else if(tipoActividad.equals("Ligero")){
               gastoEnergeticoTotalFinal =(gastoEnergeticoTotalBase*0.3)+gastoEnergeticoTotalBase;
               get_resultado.setText(String.valueOf(gastoEnergeticoTotalFinal));
           }
           else if(tipoActividad.equals("Moderado")){
               gastoEnergeticoTotalFinal =(gastoEnergeticoTotalBase*0.4)+gastoEnergeticoTotalBase;
               get_resultado.setText(String.valueOf(gastoEnergeticoTotalFinal));
           }
           else if(tipoActividad.equals("Intenso")){
               gastoEnergeticoTotalFinal =(gastoEnergeticoTotalBase*0.5)+gastoEnergeticoTotalBase;
               get_resultado.setText(String.valueOf(gastoEnergeticoTotalFinal));
           }
           else if(tipoActividad.equals("Muy intenso")){
               gastoEnergeticoTotalFinal =(gastoEnergeticoTotalBase*0.7)+gastoEnergeticoTotalBase;
               get_resultado.setText(String.valueOf(gastoEnergeticoTotalFinal));
           }
           else if(tipoActividad.equals("Acción dinámica")){
               gastoEnergeticoTotalFinal =(gastoEnergeticoTotalBase*0.1)+gastoEnergeticoTotalBase;
               get_resultado.setText(String.valueOf(gastoEnergeticoTotalFinal));
           }
       } //condiciones femenino

    }
}