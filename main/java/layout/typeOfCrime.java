package layout;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import com.r462.hammad.questionnaire.R;


import java.util.ArrayList;
import java.util.List;


public class typeOfCrime extends Fragment {


    CheckBox mobilesnatchingCheckBox, murderCheckBox, kidnappingCheckBox, robberyCheckBox, sexualharassmentCheckBox, blastCheckBox, vandalismCheckBox,vehicleSnatchingCheckBox;
    Button selectbtn, nextbtn;
    // private  TypeofCrime mListner;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_type_of_crime, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        final Activity activity = getActivity();
        mobilesnatchingCheckBox = (CheckBox) activity.findViewById(R.id.mobilesnatching);
        murderCheckBox = (CheckBox) activity.findViewById(R.id.murder);
        kidnappingCheckBox = (CheckBox) activity.findViewById(R.id.robbery);
        robberyCheckBox = (CheckBox) activity.findViewById(R.id.robbery);
        sexualharassmentCheckBox = (CheckBox) activity.findViewById(R.id.sexualHarassment);
        blastCheckBox = (CheckBox) activity.findViewById(R.id.blast);
        vandalismCheckBox = (CheckBox) activity.findViewById(R.id.vandalism);
        vehicleSnatchingCheckBox = (CheckBox) activity.findViewById(R.id.vehicleSnatchingId);



        nextbtn=(Button)activity.findViewById(R.id.Next);






        nextbtn.setOnClickListener(new View.OnClickListener() {
            List<String> selectedType = new ArrayList<String>();
            @Override
            public void onClick(View v) {

                if (mobilesnatchingCheckBox.isChecked()) {

                    selectedType.add("Mobile snatching");
                    nextbtn.setEnabled(true);



                }
                if (murderCheckBox.isChecked()) {
                    selectedType.add("Murder");
                    nextbtn.setEnabled(true);



                }
                if (kidnappingCheckBox.isChecked()) {
                    selectedType.add("kidnapping");
                    nextbtn.setEnabled(true);




                }
                if (robberyCheckBox.isChecked()) {

                    selectedType.add("robbery");
                    nextbtn.setEnabled(true);





                }
                if (sexualharassmentCheckBox.isChecked()) {

                    selectedType.add("Sexual harassment");
                    nextbtn.setEnabled(true);





                }
                if (blastCheckBox.isChecked()) {
                    selectedType.add("blast");
                    nextbtn.setEnabled(true);





                }
                if (vandalismCheckBox.isChecked()) {
                    selectedType.add("vandalism");
                    nextbtn.setEnabled(true);




                }
                if(vehicleSnatchingCheckBox.isChecked()){
                    selectedType.add("vehicle Snatching");
                    nextbtn.setEnabled(true);

                }

                getFragmentManager().beginTransaction().replace(R.id.fragment_container,new Victim()).addToBackStack(null).commit();

                for(int i=0;i<selectedType.size();i++){
                    Toast.makeText(getActivity(),selectedType.get(i),Toast.LENGTH_SHORT).show();

                }

            }

        });













}
        

    }








