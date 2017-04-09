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


public class treatmentByCriminal extends Fragment {
    List<String> treatmentByCriminalList= new ArrayList<>();
    CheckBox simplePoliteCheckBox,badmouthingCheckBox,manhandlingCheckBox,otherTreatmentByCriminalCheckBox;
    EditText userNoticecriminalTreatment;
    Button SelectTreatmentByCriminalBtn,TreatmentByCriminalNextBtn;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_treatment_by_criminal,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        simplePoliteCheckBox=(CheckBox)getActivity().findViewById(R.id.simplePoliteId);
        badmouthingCheckBox=(CheckBox)getActivity().findViewById(R.id.badmouthingId);
        manhandlingCheckBox=(CheckBox)getActivity().findViewById(R.id.manhandlingId);
        otherTreatmentByCriminalCheckBox=(CheckBox)getActivity().findViewById(R.id.otherByUser);
        userNoticecriminalTreatment= (EditText)getActivity().findViewById(R.id.noticeTreatmentId);
        TreatmentByCriminalNextBtn=(Button)getActivity().findViewById(R.id.nextTreatmentByCriminalId);
        TreatmentByCriminalNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(simplePoliteCheckBox.isChecked()){

                    treatmentByCriminalList.add(simplePoliteCheckBox.getText().toString());
                }
                if(badmouthingCheckBox.isChecked()){
                    treatmentByCriminalList.add(badmouthingCheckBox.getText().toString());
                }
                if(manhandlingCheckBox.isChecked()){
                    treatmentByCriminalList.add(manhandlingCheckBox.getText().toString());
                }
                if(otherTreatmentByCriminalCheckBox.isChecked()&&userNoticecriminalTreatment!=null){
                    treatmentByCriminalList.add(userNoticecriminalTreatment.getText().toString());
                }
                for(int i=0;i<treatmentByCriminalList.size();i++){
                    Toast.makeText(getActivity(),treatmentByCriminalList.get(i),Toast.LENGTH_SHORT).show();
                }
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,new Casualties()).addToBackStack(null).commit();
            }
        });


    }


}
