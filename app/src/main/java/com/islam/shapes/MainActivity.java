package com.islam.shapes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Spinner sp;
    EditText et_h_Rg;
    EditText et_w_Rg;
    EditText et_Rd;
    EditText et_h_Tr;
    EditText et_b_Tr;
    Button bt;
    TextView tv;
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp=findViewById(R.id.spinner);
        et_h_Rg=findViewById(R.id.et_h_Rg);
        et_w_Rg=findViewById(R.id.et_w_Rg);
        et_Rd=findViewById(R.id.et_Rd);
        et_h_Tr=findViewById(R.id.et_h_Tr);
        et_b_Tr=findViewById(R.id.et_b_Tr);
        bt= findViewById(R.id.bt);
        tv= findViewById(R.id.tv);

      sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               Toast.makeText(getBaseContext(), sp.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
               tv.setText(".....");
              switch (i){
                  case 0:
                      et_w_Rg.setVisibility(View.GONE);
                      et_h_Rg.setVisibility(View.GONE);
                      et_Rd.setVisibility(View.GONE);
                      et_h_Tr.setVisibility(View.GONE);
                      et_b_Tr.setVisibility(View.GONE);
                      break;
                  case 1:
                      et_w_Rg.setVisibility(View.VISIBLE);
                      et_h_Rg.setVisibility(View.VISIBLE);
                      et_Rd.setVisibility(View.GONE);
                      et_h_Tr.setVisibility(View.GONE);
                      et_b_Tr.setVisibility(View.GONE);
                      break;
                  case 2:
                      et_w_Rg.setVisibility(View.GONE);
                      et_h_Rg.setVisibility(View.GONE);
                      et_Rd.setVisibility(View.VISIBLE);
                      et_h_Tr.setVisibility(View.GONE);
                      et_b_Tr.setVisibility(View.GONE);
                      break;
                  case 3:
                      et_w_Rg.setVisibility(View.GONE);
                      et_h_Rg.setVisibility(View.GONE);
                      et_Rd.setVisibility(View.GONE);
                      et_h_Tr.setVisibility(View.VISIBLE);
                      et_b_Tr.setVisibility(View.VISIBLE);
                      break;
              }
          }

          @Override
          public void onNothingSelected(AdapterView<?> adapterView) {

          }
      });

      bt.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              int index_shape= sp.getSelectedItemPosition();
              double result=0.0;
              if (index_shape==1){
                  String h = et_h_Rg.getText().toString();
                  String w = et_h_Rg.getText().toString();
                  double h_num=Double.parseDouble(h);
                  double w_num=Double.parseDouble(w);
                  result= h_num*w_num;
              } else if (index_shape==2) {
                  String r = et_Rd.getText().toString();
                  double r_num=Double.parseDouble(r);
                  result= Math.PI*Math.pow(r_num,2);
              } else if (index_shape==3) {
                  String h = et_h_Tr.getText().toString();
                  String w = et_b_Tr.getText().toString();
                  double h_num=Double.parseDouble(h);
                  double w_num=Double.parseDouble(w);
                  result= .5*h_num*w_num;

              }
              tv.setText(result+"");
          }
      });
    }
}