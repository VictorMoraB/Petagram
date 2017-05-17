package com.mora.victor.petagram;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import javax.mail.AuthenticationFailedException;
import javax.mail.MessagingException;

public class ContactarActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar myActionbar;
    private TextView tituloActionBar;
    private Button btnSendEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactar);

        //obtener el action bar
        myActionbar = (Toolbar) findViewById(R.id.miActionBarContactar);
        setSupportActionBar(myActionbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //Cambiar el mensaje del action bar del por defecto al de esta actividad
        tituloActionBar = (TextView) findViewById(R.id.tituloActionBar);
        tituloActionBar.setText(getString(R.string.titulo_actionBar_contacto));
        //habiliatar la navegacion de regreso al padre
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnSendEmail = (Button) findViewById(R.id.btnSendEmail);
        btnSendEmail.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        switch (viewId) {
            case R.id.btnSendEmail:
                EnviarEmail();
                break;
        }
    }

    private void EnviarEmail() {
        String[] recipients = { "" };
        SendEmailAsyncTask email = new SendEmailAsyncTask();
        email.activity = this;
        email.m = new Mail("", "");
        email.m.set_from("");
        email.m.setBody("Lalalala body");
        email.m.set_to(recipients);
        email.m.set_subject("Lalalal subject");
        email.execute();

    }

    public void displayMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    class SendEmailAsyncTask extends AsyncTask<Void, Void, Boolean> {
        Mail m;
        ContactarActivity activity;

        public SendEmailAsyncTask() {
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            try {
                if (m.send()) {
                    activity.displayMessage("Sent");
                } else {
                    activity.displayMessage("Failed");
                }

                return true;
            } catch (AuthenticationFailedException e) {
                activity.displayMessage(e.getMessage());
                return false;
            } catch (MessagingException e) {
                activity.displayMessage(e.getMessage());
                return false;
            } catch (Exception e) {
                activity.displayMessage(e.getMessage());
                return false;
            }
        }
    }
}
