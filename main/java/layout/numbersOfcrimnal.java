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
import android.widget.Toast;

import com.r462.hammad.questionnaire.R;

import java.util.ArrayList;
import java.util.List;


public class numbersOfcrimnal extends Fragment {

    CheckBox oneCriminalCheckBox,twoCrimininalCheckBox,threeCriminalCheckBox,moreThanThreeCheckBox;
    Button SelectNumberOfCriminalBtn,nextNumberofCriminalBtn;
    List<String> numberofCrimninalList =  new ArrayList<String>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_numbers_ofcrimnal,container,false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        oneCriminalCheckBox=(CheckBox)getActivity().findViewById(R.id.oneCriminalId);
        twoCrimininalCheckBox=(CheckBox)getActivity().findViewById(R.id.twoCriminalId);
        threeCriminalCheckBox=(CheckBox)getActivity().findViewById(R.id.threeCriminalId);
        moreThanThreeCheckBox=(CheckBox)getActivity().findViewById(R.id.moreThanThreeId);
        nextNumberofCriminalBtn=(Button)getActivity().findViewById(R.id.numberofcrimnalNextId);
        nextNumberofCriminalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              if(oneCriminalCheckBox.isChecked()){
                 numberofCrimninalList.add(oneCriminalCheckBox.getText().toString());
                  twoCrimininalCheckBox.setChecked(false);
                  threeCriminalCheckBox.setChecked(false);
                  moreThanThreeCheckBox.setChecked(false);
              }
                if(twoCrimininalCheckBox.isChecked()){

                   numberofCrimninalList.add(twoCrimininalCheckBox.getText().toString());
                    threeCriminalCheckBox.setChecked(false);
                    moreThanThreeCheckBox.setChecked(false);
                    oneCriminalCheckBox.setChecked(false);
                }
                if(threeCriminalCheckBox.isChecked()){
                    numberofCrimninalList.add(threeCriminalCheckBox.getText().toString());
                    moreThanThreeCheckBox.setChecked(false);
                    oneCriminalCheckBox.setChecked(false);
                    twoCrimininalCheckBox.setChecked(false);
                }
                if(moreThanThreeCheckBox.isChecked()){
                    numberofCrimninalList.add(moreThanThreeCheckBox.getText().toString());
                    oneCriminalCheckBox.setChecked(false);
                    twoCrimininalCheckBox.setChecked(false);
                    threeCriminalCheckBox.setChecked(false);
                }

                for(int i=0;i<numberofCrimninalList.size();i++){
                    Toast.makeText(getActivity(),numberofCrimninalList.get(i),Toast.LENGTH_SHORT).show();
                }
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,new criminialWeapon()).addToBackStack(null).commit();

            }
        });


    }
}
