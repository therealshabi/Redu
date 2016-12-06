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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mSignUpText = (TextView) findViewById(R.id.activity_signin_signup_text_view);
        mEmailId = (EditText) findViewById(R.id.activity_signin_username_edit_text);
        mPassword = (EditText) findViewById(R.id.activity_signin_password_edit_text);
        mSignIn = (Button) findViewById(R.id.activity_signin_singin_button);

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
                    startActivity(new Intent(SignInActivity.this, ReduMainScreen.class));
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
