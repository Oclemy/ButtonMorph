package info.camposha.buttonmorph;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.dd.processbutton.iml.SubmitProcessButton;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
/*
MessageActivity. Simulate message sending.
 */
public class MessageActivity extends AppCompatActivity implements ProgressGenerator.OnCompleteListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        final EditText editMessage = (EditText) findViewById(R.id.editMessage);

        final ProgressGenerator progressGenerator = new ProgressGenerator(this);
        final SubmitProcessButton btnSend = (SubmitProcessButton) findViewById(R.id.btnSend);

        //start sending message and disable button
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressGenerator.start(btnSend);
                btnSend.setEnabled(false);
                editMessage.setEnabled(false);
            }
        });
    }

    /*
    sending complete
     */
    @Override
    public void onComplete() {
        Toast.makeText(this, R.string.Loading_Complete, Toast.LENGTH_LONG).show();
    }

}
