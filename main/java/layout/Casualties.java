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


public class Casualties extends Fragment {
    String casualtiesValue="";
    CheckBox yesCasualtiesCheckBox,NoCasualtiesCheckBox;
    Button selectCasualtiesBtn,finishBtn;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_casualties,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        yesCasualtiesCheckBox=(CheckBox)getActivity().findViewById(R.id.YesCasualtiesId);
        NoCasualtiesCheckBox=(CheckBox)getActivity().findViewById(R.id.NoCasualtiesId);
        finishBtn=(Button)getActivity().findViewById(R.id.FinishID);
        finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(yesCasualtiesCheckBox.isChecked()){
                     casualtiesValue="Yes";
                }
                if(NoCasualtiesCheckBox.isChecked()){

                        casualtiesValue="No";
                }

                Toast.makeText(getActivity(),casualtiesValue,Toast.LENGTH_SHORT).show();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,new reportView()).commit();

            }
        });

    }
}
