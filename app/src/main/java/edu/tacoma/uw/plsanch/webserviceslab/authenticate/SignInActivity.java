package edu.tacoma.uw.plsanch.webserviceslab.authenticate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import edu.tacoma.uw.plsanch.webserviceslab.LoginFragment;
import edu.tacoma.uw.plsanch.webserviceslab.R;

public class SignInActivity extends AppCompatActivity implements LoginFragment.LoginInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }

    @Override
    public void login(String userId, String pwd) {

    }
}
