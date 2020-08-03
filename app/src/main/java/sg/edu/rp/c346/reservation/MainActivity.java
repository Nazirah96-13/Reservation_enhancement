package sg.edu.rp.c346.reservation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etTelephone;
    EditText etSize;
    CheckBox checkBox;
    TextView txtDay;
    EditText etDay;

    TextView txtTime;
    EditText etTime;

    Button btReserve;
    Button btReset;
    String msg;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etTelephone = findViewById(R.id.editTextTelephone);
        etSize = findViewById(R.id.editTextSize);
        checkBox = findViewById(R.id.checkBox);
        txtDay = findViewById(R.id.textViewDay);
        etDay = findViewById(R.id.editTextDay);
        txtTime = findViewById(R.id.textViewTime);
        etTime = findViewById(R.id.editTextTime);

        btReserve = findViewById(R.id.buttonReserve);
        btReset = findViewById(R.id.buttonReset);




        //Day
       etDay.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                   public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                       etDay.setText(" " + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);

                   }
               };
               DatePickerDialog myDateDialog = new  DatePickerDialog(MainActivity.this, myDateListener, 2014, 11,31);
               myDateDialog.show();

              }
           });



        //Time
        etTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        etTime.setText(" " + hourOfDay + " : " + minute);
                    }
                };
                TimePickerDialog myTimeDialog = new  TimePickerDialog(MainActivity.this, myTimeListener, 20, 00,true);
                myTimeDialog.show();

            };
        });



        btReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String isSmoke = "";

                if (checkBox.isChecked()) {
                    isSmoke = "smoking";
                }
                else {
                    isSmoke = "non-smoking";
                }

               //Prepare a string for a display
                Log.i("String","0");
                msg ="New Reservation"+"\n";
                msg = "Name  " + etName.getText().toString() + "\n";
                msg = "Smoking: " + isSmoke + "\n";
                msg = "Size: " + etSize.getText().toString()+ "\n";
                msg = "Date: "+ etDay.getText().toString()+ "\n";
                msg = "Time: "+ etTime.getText().toString();

                 //Create the Dialog builder
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                myBuilder.setTitle("Confirm Your Order");
                //Set the string that you create on top
                myBuilder.setMessage(msg);

                myBuilder.setCancelable(false);

                //Positive btn (confirm)
                myBuilder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //Toast
                        Toast.makeText(MainActivity.this, msg,Toast.LENGTH_LONG).show();
                    }
                });



                //negative btn (cancel)
                myBuilder.setNegativeButton("Cancel", null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

            }
        });

        btReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etName.setText("");
                etTelephone.setText("");
                etSize.setText("");
                checkBox.setChecked(false);
                //datePicker.updateDate(2020, 5, 1);
                //timePicker.setCurrentHour(20);
                //timePicker.setCurrentMinute(30);
            }
        });
    }
}