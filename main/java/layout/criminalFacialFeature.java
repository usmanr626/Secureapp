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

public class criminalFacialFeature extends Fragment {

    List<String> facialFeatureList = new ArrayList<>();
    CheckBox cleanChaveCheckBox, shortBeardMoustacheCheckBox,LongBeardMoustacheCheckBox,baldCheckBox,shortHairCheckBox,longHairCheckBox;
    Button SelectFacialFeatureBtn,nextFacialBtn;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_criminal_facial_feature,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        cleanChaveCheckBox=(CheckBox)getActivity().findViewById(R.id.cleanSaveId);
        shortBeardMoustacheCheckBox=(CheckBox)getActivity().findViewById(R.id.shortBreadmoustacheId);
        LongBeardMoustacheCheckBox=(CheckBox)getActivity().findViewById(R.id.LongBeardMoustacheId);
        baldCheckBox=(CheckBox)getActivity().findViewById(R.id.bladId);
        shortHairCheckBox=(CheckBox)getActivity().findViewById(R.id.shortHairId);
        longHairCheckBox=(CheckBox)getActivity().findViewById(R.id.longHaireId);
        nextFacialBtn = (Button)getActivity().findViewById(R.id.facialFeatureNextId);

        nextFacialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cleanChaveCheckBox.isChecked()){
                    facialFeatureList.add(cleanChaveCheckBox.getText().toString());
                }
                if(shortBeardMoustacheCheckBox.isChecked()){
                    facialFeatureList.add(shortBeardMoustacheCheckBox.getText().toString());
                }
                if(LongBeardMoustacheCheckBox.isChecked()){
                    facialFeatureList.add(LongBeardMoustacheCheckBox.getText().toString());
                }
                if (baldCheckBox.isChecked()){
                    facialFeatureList.add(baldCheckBox.getText().toString());
                }
                if (shortHairCheckBox.isChecked()){
                    facialFeatureList.add(shortHairCheckBox.getText().toString());
                }
                if (longHairCheckBox.isChecked()){
                    facialFeatureList.add(longHairCheckBox.getText().toString());
                }
                for(int i=0;i<facialFeatureList.size();i++){
                    Toast.makeText(getActivity(),facialFeatureList.get(i),Toast.LENGTH_SHORT).show();
                }

                getFragmentManager().beginTransaction().replace(R.id.fragment_container,new criminalOutfit()).addToBackStack(null).commit();
            }
        });





    }
}
