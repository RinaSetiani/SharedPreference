import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sharedpreference.MainActivity;
import com.example.sharedpreference.R;

public class LoginActivity extends AppCompatActivity {
    private Button login;
    private EditText mViewUser, mViewPassword;
}

protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    mViewUser = (EditText) findViewById(R.id.editTextEmail);
    mViewPassword = (EditText) findViewById(R.id.editTextPassword);
    login = (Button) findViewById(R.id.buttonLoggin);
}

private boolean cekUser(String User){
    return user.equals(Preferences.getRegisteredUser(getBaseContext()));
}

private boolean cekPassword(String Password){
    return password.equals(Preferences.getRegisteredPass(getBaseContext()));
}

private void mainPage(){
    Preferences.setLoggedInUser(getBaseContext(),
            Preferences.getRegisteredUser(getBaseContext()));
    Preferences.setLoggedInStatus(getBaseContext(), status:true);
    startActivity(new Intent(getBaseContext(), MainActivity.class));finish();
}

private void cekLogin(){
    mViewUser.setError(null);
    mViewPassword.setError(null);
    View fokus = null;
    boolean cancel = false;

    String user = mViewUser.getText().toString();
    String password = mViewPassword.getText().toString();

    if (TextUtils.isEmpty(user)){
        mViewUser.setError("This field in required");
        fokus = mViewUser;
        cancel = true;
    }
    else if(!cekUser(user)){
        mViewUser.setError("This username is not found");
        fokus = mViewUser;
        cancel = true;
    }

    if (TextUtils.isEmpty(password)){
        mViewPassword.setError("This field in required");
        fokus = mViewPassword;
        cancel = true;
    }
    else if(!cekPassword(password)){
        mViewPassword.setError("This password is incorect");
        fokus = mViewPasswordr;
        cancel = true;
    }

    if (cancel) fokus.requestFocus();
    else mainPage();
}

login.setOnClickListener(new View.OnClickListener(){
@Override
public void onClick(View v){
        cekLogin();
        }

        });
