package layout;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import com.r462.hammad.questionnaire.R;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static android.R.attr.format;

public class crimeTime extends Fragment {
    TimePicker crimeTime;
    Button nextTimeBtn;
    Calendar calendar;
    String format="";
    List<String> crimeTimeList = new ArrayList<String>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater .inflate(R.layout.fragment_crime_time,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Activity activity = getActivity();

        crimeTime = (TimePicker)activity.findViewById(R.id.crimeTimeId);
        nextTimeBtn = (Button)activity.findViewById(R.id.TimeSelectNextId);
        crimeTime.is24HourView();
        nextTimeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              //  calendar = Calendar.getInstance();

               //int hour = calendar.get(Calendar.HOUR_OF_DAY);
                //int min = calendar.get(Calendar.MINUTE);
                int hour = crimeTime.getHour();
                int min = crimeTime.getMinute();

                if (hour == 0) {
                    hour += 12;
                    format = "AM";
                } else if (hour == 12) {
                    format = "PM";
                } else if (hour > 12) {
                    hour -= 12;
                    format = "PM";
                } else {
                    format = "AM";
                }

                crimeTimeList.add(hour+":"+min+" "+format);


               Toast.makeText(getActivity(),hour+":"+min+" "+format,Toast.LENGTH_SHORT).show();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,new crimeDate()).addToBackStack(null).commit();
            }
        });




    }
}