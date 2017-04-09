package com.r462.hammad.questionnaire;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import layout.Casualties;
import layout.Victim;
import layout.crimeArea;
import layout.crimeDate;
import layout.crimeTime;
import layout.criminalFacialFeature;
import layout.criminalOutfit;
import layout.criminalVehicle;
import layout.criminalVehicleIdentification;
import layout.criminialWeapon;
import layout.numbersOfcrimnal;
import layout.reportView;
import layout.treatmentByCriminal;
import layout.typeOfCrime;

public class MainActivity extends AppCompatActivity{
    String crimeType="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,new reportView()).commit();



    }
    public void onFragmentInteraction(String Type){

        crimeType=Type;
        Toast.makeText(this,Type,Toast.LENGTH_SHORT).show();



    }




    public void Report(View view) {

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new typeOfCrime()).commit();


    }
}
