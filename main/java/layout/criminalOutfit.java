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
import android.widget.Toast;

import com.r462.hammad.questionnaire.R;

import java.util.ArrayList;
import java.util.List;


public class criminalOutfit extends Fragment {
    List<String> criminalOutfitList = new ArrayList<>();
    CheckBox shalwarKameezCheckBox,jeanTShirtCheckBox,shortsCheckBox,otherOutfitCheckBox;
    Button SelectOutfitBtn,nextOutfitBtn;
    EditText userOutfitEText;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_criminal_outfit,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        shalwarKameezCheckBox=(CheckBox)getActivity().findViewById(R.id.shalwarKameezId);
        jeanTShirtCheckBox=(CheckBox)getActivity().findViewById(R.id.jeanTShirtId);
        shortsCheckBox=(CheckBox)getActivity().findViewById(R.id.shotsId);
        otherOutfitCheckBox=(CheckBox)getActivity().findViewById(R.id.otherOutfitId);
        userOutfitEText = (EditText)getActivity().findViewById(R.id.userOutfitId);
        nextOutfitBtn=(Button)getActivity().findViewById(R.id.nextOutfitId);
        nextOutfitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(shalwarKameezCheckBox.isChecked()){
                    criminalOutfitList.add(shalwarKameezCheckBox.getText().toString());

                }
                if(jeanTShirtCheckBox.isChecked()){
                    criminalOutfitList.add(jeanTShirtCheckBox.getText().toString());
                }
                if(shortsCheckBox.isChecked()){
                    criminalOutfitList.add(shortsCheckBox.getText().toString());
                }
                if(otherOutfitCheckBox.isChecked()&&userOutfitEText!=null){
                    criminalOutfitList.add(userOutfitEText.getText().toString());
                }
                for(int i=0;i<criminalOutfitList.size();i++){
                    Toast.makeText(getActivity(),criminalOutfitList.get(i),Toast.LENGTH_SHORT).show();
                }
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,new criminalVehicle()).commit();
            }
        });



    }
}
