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
import android.widget.DatePicker;
import android.widget.Toast;

import com.r462.hammad.questionnaire.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class crimeDate extends Fragment {
    List<String> crimeDateList = new ArrayList<String>();
    DatePicker datePicker;
    Button selectDate,dateNextBtn;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_crime_date,container,false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Activity activity = getActivity();


        datePicker=(DatePicker)activity.findViewById(R.id.crimedateId);
        dateNextBtn = (Button)activity.findViewById(R.id.dateSelectNextId);
        dateNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int month = datePicker.getMonth();
                            month++;
                int dayOfMonth = datePicker.getDayOfMonth();
                int year = datePicker.getYear();

                crimeDateList.add(dayOfMonth+" : "+month+" : "+year);
                Toast.makeText(getActivity(),crimeDateList.get(0),Toast.LENGTH_SHORT).show();

                getFragmentManager().beginTransaction().replace(R.id.fragment_container,new numbersOfcrimnal()).addToBackStack(null).commit();
            }
        });



    }
}
