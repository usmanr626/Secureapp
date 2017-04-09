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
import android.widget.EditText;

import com.r462.hammad.questionnaire.R;


public class crimeArea extends Fragment {
    Button crimeAreaNextBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_crime_area,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        crimeAreaNextBtn=(Button)getActivity().findViewById(R.id.crimeAreaNexTId);
        EditText criminalAreaEditText = (EditText)getActivity().findViewById(R.id.crimeAreaID);
        String crimeArea = criminalAreaEditText.getText().toString();

        crimeAreaNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,new crimeTime()).addToBackStack(null).commit();
            }
        });



    }
}
