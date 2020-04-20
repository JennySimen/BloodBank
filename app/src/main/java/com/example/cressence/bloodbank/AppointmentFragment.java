package com.example.cressence.bloodbank;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class AppointmentFragment extends Fragment {

private EditText appointmentDate;
private Calendar cal;
private EditText hosp;
private EditText appointmentTime;
private Button mSave;
private Button mCancel;
    Date dateObject;
    String date;
    String time;



    public static AppointmentFragment newInstance() {
        AppointmentFragment fragment = new AppointmentFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstances) {
        View view = inflater.inflate(R.layout.fragment_appointment, container, false);


       appointmentDate = view.findViewById(R.id.edit_date);
        appointmentDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDatePickerDialog(v);
            }
        });

        appointmentTime = view.findViewById(R.id.edit_time);
        appointmentTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTimePickerDialog(v);
            }
        });

        hosp = view.findViewById(R.id.edit_hospital);

//        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); // Make sure user insert date into edittext in this format.
//
//
//
//        try {
//            String dob_var=(appointmentDate.getText().toString());
//            String time_var=(appointmentTime.getText().toString());
//
//            dateObject = formatter.parse(dob_var);
//
//            date = new SimpleDateFormat("dd/MM/yyyy").format(dateObject);
//            time = new SimpleDateFormat("h:mmaa").format(dateObject);
//
//        }
//        catch (java.text.ParseException e) {
//            e.printStackTrace();
//        }

        mSave = view.findViewById(R.id.appointment_save);
        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hosp_data = "";
                String date_data = "";
                String time_data = "";

                hosp_data = hosp.getText().toString();
                date_data = appointmentDate.getText().toString();
                time_data = appointmentTime.getText().toString();
                String data =  "hospital: " + hosp_data + "date: "  + date_data  + "time: " + time_data;

                Toast.makeText(getActivity(), data , Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
    public void openDatePickerDialog(final View v) {

        Calendar cal = Calendar.getInstance();
        // Get Current Date
        Calendar mcurrentDate = Calendar.getInstance();
        int mYear = mcurrentDate.get(Calendar.YEAR);
        int mMonth = mcurrentDate.get(Calendar.MONTH);
        int mDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog mDatePicker;
        mDatePicker = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                /*      Your code   to get date and time    */
                selectedmonth = selectedmonth + 1;
                appointmentDate.setText("" + selectedday + "/" + selectedmonth + "/" + selectedyear);
            }
        }, mYear, mMonth, mDay);
        mDatePicker.setTitle("Select Date");
        mDatePicker.show();
    }

        public void openTimePickerDialog(final View v) {

            Calendar cal = Calendar.getInstance();
//            ///Get time
            Calendar mcurrentTime = Calendar.getInstance();
            int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
            int minute = mcurrentTime.get(Calendar.MINUTE);
            TimePickerDialog mTimePicker;
            mTimePicker = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                    appointmentTime.setText( selectedHour + ":" + selectedMinute);
                }
            }, hour, minute, true);//Yes 24 hour time
            mTimePicker.setTitle("Select Time");
            mTimePicker.show();
        }



}

