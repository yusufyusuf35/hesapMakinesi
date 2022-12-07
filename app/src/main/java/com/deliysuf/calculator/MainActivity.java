package com.deliysuf.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.deliysuf.calculator.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ArrayList<Integer> array;
    EditText textView ;
    String asilSayi;
    float toplam ;
    String Value;
    String isaret;
    float carpim ;
    boolean memory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        textView = findViewById(R.id.textView);
        array = new ArrayList<>();
        asilSayi = "";
        Value = "";
        isaret = "";
        carpim = 1;
        memory = true;

        binding.bir.setOnClickListener(view->{
            writing("1");
            topla(1);
        });
        binding.iki.setOnClickListener(view -> {
            writing("2");
            topla(2);
        });
        binding.uc.setOnClickListener(view -> {
            writing("3");
            topla(3);
        });
        binding.dort.setOnClickListener(view -> {
            writing("4");
            topla(4);
        });
        binding.bes.setOnClickListener(view -> {
            writing("5");
            topla(5);


        });
        binding.alti.setOnClickListener(view -> {
            writing("6");
            topla(6);


        });
        binding.yedi.setOnClickListener(view -> {
            writing("7");
            topla(7);

        });
        binding.sekiz.setOnClickListener(view -> {
            writing("8");
            topla(8);

        });
        binding.dokuz.setOnClickListener(view -> {
            writing("9");
            topla(9);

        });
        binding.sifir.setOnClickListener(view -> {
            writing("0");
            topla(0);

        });
        binding.esittir.setOnClickListener(view->{
            esittir();
        });
        binding.arti.setOnClickListener(view->{
            arti();

        });
        binding.eksi.setOnClickListener(view->{
            cikar();
        });
        binding.carpma.setOnClickListener(view->{
            carp();
        });
        binding.bolme.setOnClickListener(view -> {
            bol();
        });
        binding.temizle.setOnClickListener(view -> {
            temizle();
        });

    }

    void writing(String b){


        asilSayi = asilSayi+b;

        textView.setText(asilSayi);

    }
    void topla(int sayi){
        String a = String.valueOf(sayi);
      Value = Value+a;


    }
    void arti(){
        float value = Float.parseFloat(Value);
        switch(isaret){
            case "" :

                toplam = value ;
                break;
            case "+" :
                carpim = 1;
                toplam = toplam+value;

                break;
            case "-" :
                carpim = 1;
                toplam = toplam-value;

                break;
            case "/" :
                carpim = carpim/value;
                if(memory){
                    toplam = toplam+carpim;
                }else {
                    toplam = toplam-carpim;
                }
                break;
            case "*" :
                carpim = carpim*value;
                if(memory){
                    toplam = toplam+carpim;
                }else {
                    toplam = toplam-carpim;
                }
                break;
        }
        writing("+");
        Value = "";
        carpim = 1;
        isaret = "+";


    }
    void cikar(){
        float value = Float.parseFloat(Value);
        switch(isaret){
            case "" :
                toplam = value;
                break;
            case "+" :
                carpim = 1;
                toplam = toplam+value;
                break;
            case "-" :
                carpim = 1;
                toplam = toplam-value;
                break;
            case "/" :
                carpim = carpim/value;
                if(memory){
                    toplam = toplam+carpim;
                }else {
                    toplam = toplam-carpim;
                }
                break;
            case "*" :
                carpim = carpim*value;
                if(memory){
                    toplam = toplam+carpim;
                }else {
                    toplam = toplam-carpim;
                }
                break;
        }
        writing("-");
        Value = "";
        carpim = 1;
        isaret = "-";
    }

    void carp(){
        float value = Float.parseFloat(Value);

        switch(isaret){
            case "" :
                carpim = carpim*value ;
                break;
            case "+" :
                carpim = carpim*value ;
                memory = true ;
                break;
            case "-" :
                carpim = carpim*value ;
                memory = false ;
                break;
            case "/" :
                carpim = carpim/value;
                Value = String.valueOf(carpim) ;
                break;
            case "*" :
                carpim = carpim*value;
                Value = String.valueOf(carpim);
                break;
            default :
                break;
        }
        writing("*");
        Value = "";
        isaret = "*";
    }
    void bol(){
        float value = Float.parseFloat(Value);
        switch(isaret){
            case "" :
                carpim = carpim*value ;
                break;
            case "+" :
                carpim = carpim*value ;
                memory = true ;
                break;
            case "-" :
                carpim = carpim*value ;
                memory = false ;
                break;
            case "/" :
                carpim = carpim/value;
                Value = String.valueOf(carpim);
                break;
            case "*" :
                carpim = carpim*value;
                Value = String.valueOf(carpim);
                break;
            default :
                break;
        }
        writing("/");
        Value = "";
        isaret = "/";
    }
    void esittir(){
        writing("=");
        float value = Float.parseFloat(Value);
       /*switch(isaret){
           case "" :
               toplam = 0;
               break;
           case "+" :
               toplam = toplam+value;
               break;
           case "-" :
               toplam = toplam-value;
               break;
           case "/" :
               toplam = toplam+value;
               break;
           case "*" :
               toplam = toplam+value;
               break;

           default :
               break;
        }*/
        switch(isaret){
            case "" :
                carpim = carpim*value;
                toplam = value ;
                break;
            case "+" :
                carpim = 1;
                toplam = toplam+carpim*value;
                carpim = carpim*value ;
                break;
            case "-" :
                carpim = 1;
                toplam = toplam-carpim*value;
                break;
            case "/" :
                carpim = carpim/value;
                if(memory){
                    toplam = toplam+carpim;
                }else {
                    toplam = toplam-carpim;
                }
                break;
            case "*" :
                carpim = carpim*value;
                 if(memory){
                     toplam = toplam+carpim;
                 }else {
                     toplam = toplam-carpim;
                 }
                break;
            default :
                break;
        }
        asilSayi = "" ;
        textView.setText(String.valueOf(toplam));
        toplam = 0;
        Value = "";
        isaret = "";
        carpim = 1 ;
    }
    void temizle(){
        asilSayi = "" ;
        textView.setText("");
        toplam = 0;
        Value = "";
        isaret = "";
        carpim = 1 ;
    }




}