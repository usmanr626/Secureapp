package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.r462.hammad.questionnaire.R;

import java.util.ArrayList;
import java.util.List;


public class criminalVehicle extends Fragment {
    List<String> criminalVehicleList = new ArrayList<>();

    CheckBox carCheckBox,bikeCheckBox,otherCheckBox;
      EditText userVehicleText;
        Button selectVehicleBtn,nextVehicleBtn;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_criminal_vehicle,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        carCheckBox = (CheckBox)getActivity().findViewById(R.id.carId);
        bikeCheckBox=(CheckBox)getActivity().findViewById(R.id.bikeId);
        otherCheckBox=(CheckBox)getActivity().findViewById(R.id.othervehicleId);
        userVehicleText= (EditText)getActivity().findViewById(R.id.userVehileId);
        nextVehicleBtn=(Button)getActivity().findViewById(R.id.nextCriminalVehicleId);
        nextVehicleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(carCheckBox.isChecked()){

                    criminalVehicleList.add(carCheckBox.getText().toString());
                }
                if(bikeCheckBox.isChecked()){

                    criminalVehicleList.add(bikeCheckBox.getText().toString());
                }
                if(otherCheckBox.isChecked()&&userVehicleText!=null){

                    criminalVehicleList.add(userVehicleText.getText().toString());
                }
                for(int i=0;i<criminalVehicleList.size();i++){
                    Toast.makeText(getActivity(),criminalVehicleList.get(i),Toast.LENGTH_SHORT).show();
                }

                getFragmentManager().beginTransaction().replace(R.id.fragment_container,new criminalVehicleIdentification()).addToBackStack(null).commit();

            }
        });


    }
}
