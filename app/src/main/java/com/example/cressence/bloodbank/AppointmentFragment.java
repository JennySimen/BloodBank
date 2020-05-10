package com.example.cressence.bloodbank;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TimePicker;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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

        mSave = view.findViewById(R.id.appointment_save);
        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeAppointment();
            }
        });

        mCancel = view.findViewById(R.id.appointment_cancel);
        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //getActivity().finish();
                AppointmentFragment.this.getActivity().finish();

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

    private void makeAppointment() {
//
//        String hosp_data = "";
//        String date_data = "";
//        String time_data = "";

//        hosp_data = hosp.getText().toString();
//        date_data = appointmentDate.getText().toString();
//        time_data = appointmentTime.getText().toString();
//        String data =  "hospital: " + hosp_data + "date: "  + date_data  + "time: " + time_data;
//
//        Toast.makeText(getActivity(), data , Toast.LENGTH_LONG).show();

        final String hospital= hosp.getText().toString().trim();
        final String dates = appointmentDate.getText().toString().trim();
        final String hour = appointmentTime.getText().toString().trim();
        String data =  "hospital: " + hospital + "date: "  + dates  + "time: " + hour;

        //first we will do the validations

        if (TextUtils.isEmpty(hospital)) {
            hosp.setError("Please enter hospital name");
            hosp.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(dates)) {
            appointmentDate.setError("Please enter the date");
            appointmentDate.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(hour)) {
            appointmentTime.setText("please enter a time");
           appointmentTime.requestFocus();
            return;
        }

        //if it passes all the validations

        class BookAppointment extends AsyncTask<Void, Void, String> {
            public ProgressBar progressBar;


            @Override
            protected String doInBackground(Void... voids) {
                Log.i("main", URLS.URL_BOOK);
                //creating request handler object
                RequestHandler requestHandler = new RequestHandler();

                //creating request parameters
                HashMap<String, String> params = new HashMap<>();
                params.put("hospital", hospital);
                params.put("dates", dates);
                params.put("hour", hour);

                //returing the response
                return requestHandler.sendPostRequest(URLS.URL_BOOK, params);
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                Log.i("Before", "the pre function");
//                displaying the progress bar while user registers on the server
                //mSave.setVisibility(View.GONE);
                Toast.makeText(getActivity(), data , Toast.LENGTH_LONG).show();

            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                Log.i("post", "the after function");
//                hiding the progressbar after completion
//                progressBar.setVisibility(View.GONE);

                try {
                    //converting response to json object
                    JSONObject obj = new JSONObject(s);

                    //if no error in response
                    if (!obj.getBoolean("error")) {
                        Toast.makeText(getActivity().getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();

                        //getting the user from the response
                        JSONObject userJson = obj.getJSONObject("book");

                        //creating a new user object
                        Book book = new Book(
                                userJson.getInt("book_id"),
                                userJson.getString("hospital"),
                                userJson.getString("dates"),
                                userJson.getString("hours")
                        );

                        //storing the user in shared preferences
//                        PrefManager.getInstance(getActivity().getApplicationContext()).userLogin(book);

                        //starting the profile activity
//                        getActivity().finish();
//                        Toast.makeText(getActivity(), data , Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getActivity().getApplicationContext(), "Some error occurred", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        //executing the async task
        BookAppointment ba = new BookAppointment();
        ba.execute();
    }


}

