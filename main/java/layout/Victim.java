package layout;

import android.app.Activity;
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
import android.widget.Toast;

import com.r462.hammad.questionnaire.R;

import java.util.ArrayList;
import java.util.List;


public class Victim extends Fragment {
    CheckBox youcheckBox ,yourFriendCheckBox,yourRelativeCheckBox,otherVictimCheckBox,strangerCheckBox;
    Button selectVictimbtn,nextVictimbtn;
    EditText victimOtherText;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_victim,container,false);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Activity activity = getActivity();
    youcheckBox=(CheckBox)activity.findViewById(R.id.you);
        yourFriendCheckBox=(CheckBox)activity.findViewById(R.id.yourFriend);
        yourRelativeCheckBox=(CheckBox)activity.findViewById(R.id.yourRelative);
        strangerCheckBox=(CheckBox)activity.findViewById(R.id.strangerVictim);
        otherVictimCheckBox = (CheckBox)activity.findViewById(R.id.other);
        victimOtherText = (EditText) activity.findViewById(R.id.victimValueText);
        nextVictimbtn = (Button)activity.findViewById(R.id.VictimNext);
        final List<String> selectedvictim = new ArrayList<String>();
        nextVictimbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(youcheckBox.isChecked()){

                    selectedvictim.add(youcheckBox.getText().toString());
                }
                if(yourFriendCheckBox.isChecked()){

                    selectedvictim.add(yourFriendCheckBox.getText().toString());
                }
                if(yourRelativeCheckBox.isChecked()){
                    selectedvictim.add(yourRelativeCheckBox.getText().toString());
                }
                if(strangerCheckBox.isChecked()){
                    selectedvictim.add(strangerCheckBox.getText().toString());
                }
                if(otherVictimCheckBox.isChecked()&&victimOtherText!=null){
                    selectedvictim.add(victimOtherText.getText().toString());
                }

                getFragmentManager().beginTransaction().replace(R.id.fragment_container,new crimeArea()).addToBackStack(null).commit();


                for(int i=0;i<selectedvictim.size();i++){
                    Toast.makeText(getActivity(),selectedvictim.get(i),Toast.LENGTH_SHORT).show();
                }

            }
        });








    }
}

