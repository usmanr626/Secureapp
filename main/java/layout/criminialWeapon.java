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


public class criminialWeapon extends Fragment {
    List<String> selectedweapon = new ArrayList<String>();
    CheckBox revolverCheckBox,pistonCheckBOx,daggerCheckBox,otherCheckBox;
    Button selectWeaponBtn,nextWeaponBtn;
    EditText userWaponEditText;
    List<String> selectweaponList = new ArrayList<String>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_criminial_weapon,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        revolverCheckBox=(CheckBox)getActivity().findViewById(R.id.revolverId);
        pistonCheckBOx=(CheckBox)getActivity().findViewById(R.id.pistolId);
        daggerCheckBox=(CheckBox)getActivity().findViewById(R.id.daggerId);
        otherCheckBox=(CheckBox)getActivity().findViewById(R.id.otherWeaponId);
        userWaponEditText=(EditText)getActivity().findViewById(R.id.userWeaponId);
        nextWeaponBtn=(Button)getActivity().findViewById(R.id.weaponNextId);
        nextWeaponBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(revolverCheckBox.isChecked()){

                    selectweaponList.add(revolverCheckBox.getText().toString());
                }
                if(pistonCheckBOx.isChecked()){
                    selectweaponList.add(pistonCheckBOx.getText().toString());
                }
                if(daggerCheckBox.isChecked()){
                    selectweaponList.add(daggerCheckBox.getText().toString());
                }
                if(otherCheckBox.isChecked()&&userWaponEditText!=null){
                    selectweaponList.add(userWaponEditText.getText().toString());
                }

                for(int i=0;i<selectweaponList.size();i++){
                    Toast.makeText(getActivity(),selectweaponList.get(i),Toast.LENGTH_SHORT).show();
                }

                getFragmentManager().beginTransaction().replace(R.id.fragment_container,new criminalFacialFeature()).addToBackStack(null).commit();
            }
        });



    }
}
