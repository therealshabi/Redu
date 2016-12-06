package testing.example.com.r_edu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {

    TextView mSignUpText;
    EditText mEmailId;
    EditText mPassword;
    Button mSignIn;
    DataHelper mDataHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mSignUpText = (TextView) findViewById(R.id.activity_signin_signup_text_view);
        mEmailId = (EditText) findViewById(R.id.activity_signin_username_edit_text);
        mPassword = (EditText) findViewById(R.id.activity_signin_password_edit_text);
        mSignIn = (Button) findViewById(R.id.activity_signin_singin_button);

        mDataHelper = new DataHelper(getBaseContext());

        //CS Course
        mDataHelper.courseInsert("Android", "Android apps are everywhere, and learning to build them can be a fantastic career move. No programming experience? No problem! The skills you learn in this beginning Nanodegree program will accelerate your journey to becoming a working Android Developer.", "cs");
        mDataHelper.courseInsert("Front-End Web Developer Nanodegree", "JavaScript is the most widely deployed language in the world. Whether you’re interested in writing front-end client side code, back-end code for servers, or even game development, you’ll be able to accomplish all of this and more with JavaScript.\n" +
                " This learning path includes JavaScript tutorials for both the new programmer looking to get started and the advanced web developer wanting to solidify and enhance their skills.", "cs");
        mDataHelper.courseInsert("Artificial Intelligence Engineer", "Welcome to the Artificial Intelligence Nanodegree program, where virtually anyone on the planet can study to become an AI engineer!\n" +
                "We’ve collaborated with leading innovators in the field to bring you world-class curriculum, expert instructors, and exclusive hiring opportunities.", "cs");
        mDataHelper.courseInsert("Mean stack developer", "MEAN is a collection of JavaScript-based technologies — MongoDB, Express.js, AngularJS, and Node.js — used to develop web applications. From the client and server sides to databases,\n" +
                " MEAN is a full-stack development toolkit. Play through the following five courses to become a MEAN stack developer and earn a new badge!", "cs");
        mDataHelper.courseInsert("Javascript", "JavaScript is the most widely deployed language in the world. Whether you’re interested in writing front-end client side code, back-end code for servers, or even game development, you’ll be able to accomplish all of this and more with JavaScript.\n" +
                " This learning path includes JavaScript tutorials for both the new programmer looking to get started and the advanced web developer wanting to solidify and enhance their skills.", "cs");

        //Commerce Course
        mDataHelper.courseInsert("MBA", "The core courses in an MBA program cover various areas of business such as accounting, finance, marketing, human resources, and operations in a manner most relevant to management analysis and strategy.\n" +
                "Most programs also include elective courses. The MBA is a terminal degree and a professional degree.", "com");
        mDataHelper.courseInsert("BBA", "The Bachelor of Business Administration (BBA or B.B.A.) is a bachelor's degree in commerce and business administration.\n" +
                "The degree is conferred after four years of full-time study in one or more areas of business concentrations.", "com");

        //ECE Course
        mDataHelper.courseInsert("Embedded System", "Embedded systems are combination of hardware and software systems with a dedicated function within a mechanical or electrical system. It is either fixed in capability or is programmable to perform a special function. Programming interfaces are provided to Embedded Systems that are programmable.\n" +
                "\n" +
                "The applications of embedded systems range from portable devices such as PDA and mobile phones to large industrial systems like factory controllers and traffic lights. It also deals with variety of other industrial installations like automobiles, medical equipments, cameras, household appliances, airplanes, vending machines, etc.", "ece");
        mDataHelper.courseInsert("Information Technology", "The advancement of digitalization and the widespread networking of devices and systems opens new automation and optimization potentials. Terms like Cyber-Physical Systems (CPS) address technologies and concepts to realize the next generation of networked sensing capabilities and data propagation. For the industrial domain, these terms have been further specialized (e. g. cyber physical production systems).\n" +
                "Thereby, the changes are characterized by manufacturing entities that are, on all levels, autonomous, in the sense that they incorporate planning systems and adjust themselves in response to changing environments.", "ece");
        mDataHelper.courseInsert("IOT", "The advancement of digitalization and the widespread networking of devices and systems opens new automation and optimization potentials. Terms like Cyber-Physical Systems (CPS) address technologies and concepts to realize the next generation of networked sensing capabilities and data propagation. For the industrial domain, these terms have been further specialized (e. g. cyber physical production systems). Thereby, the changes are characterized by manufacturing entities that are, on all levels,\n" +
                "autonomous, in the sense that they incorporate planning systems and adjust themselves in response to changing environments.", "ece");


        //Centre Name
        mDataHelper.centersInsert("Udacity","www.udacity.com","Android",11999,1195,5);
        mDataHelper.centersInsert("Udacity","www.udacity.com","Front-End Web Developer Nanodegree",13999,1100,5);
        mDataHelper.centersInsert("Udacity","www.udacity.com","Artificial Intelligence Engineer",10999,1200,4.8);
        mDataHelper.centersInsert("Udacity","www.udacity.com","Mean stack developer",11999,1304,4.3);
        mDataHelper.centersInsert("Udacity","www.udacity.com","Javascript",11999,2095,3);

        mDataHelper.centersInsert("Pluralsight","www.pluralsight.com","Android",12001,1695,3);
        mDataHelper.centersInsert("Pluralsight","www.pluralsight.com","Front-End Web Developer Nanodegree",12999,1100,2);
        mDataHelper.centersInsert("Pluralsight","www.pluralsight.com","Artificial Intelligence Engineer",16000,1200,5);
        mDataHelper.centersInsert("Pluralsight","www.pluralsight.com","Mean stack developer",13059,1706,4);
        mDataHelper.centersInsert("Pluralsight","www.pluralsight.com","Javascript",10000,956,2);

        mDataHelper.centersInsert("Lynda","www.lynda.com","Android",10000,305,3.1);
        mDataHelper.centersInsert("Lynda","www.lynda.com","Front-End Web Developer Nanodegree",13999,1100,2);
        mDataHelper.centersInsert("Lynda","www.lynda.com","Artificial Intelligence Engineer",12066,1200,3);
        mDataHelper.centersInsert("Lynda","www.lynda.com","Mean stack developer",10522,1350,4.3);
        mDataHelper.centersInsert("Lynda","www.lynda.com","Javascript",11999,2095,3.2);

        mDataHelper.centersInsert("Coursera","www.coursera.com","Android",10999,1195,5);
        mDataHelper.centersInsert("Coursera","www.coursera.com","Front-End Web Developer Nanodegree",13999,1100,5);
        mDataHelper.centersInsert("Coursera","www.coursera.com","Artificial Intelligence Engineer",11999,1200,4.8);
        mDataHelper.centersInsert("Coursera","www.coursera.com","Mean stack developer",16700,2506,4.3);
        mDataHelper.centersInsert("Coursera","www.coursera.com","Javascript",7000,5000,2.9);


        mSignUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
            }
        });

        mSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mEmailId.getText().toString().equals("test@test.com") && mPassword.getText().toString().equals("pass")) {
                    startActivity(new Intent(SignInActivity.this, MainScreen.class));
                    Toast.makeText(getBaseContext(), "Logged In Successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getBaseContext(), "Sign In Error", Toast.LENGTH_SHORT).show();
                    mEmailId.requestFocus();
                    mEmailId.setText("");
                    mPassword.setText("");
                }
            }
        });
    }
}
