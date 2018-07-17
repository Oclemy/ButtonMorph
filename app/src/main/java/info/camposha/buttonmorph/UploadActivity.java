package info.camposha.buttonmorph;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.dd.processbutton.iml.GenerateProcessButton;
import android.view.View;
import android.widget.Toast;
/*
UploadActivity. Simulate uploading data.
 */
public class UploadActivity extends AppCompatActivity implements ProgressGenerator.OnCompleteListener {

    /*
    onCreate callback.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        final ProgressGenerator progressGenerator = new ProgressGenerator(this);
        final GenerateProcessButton btnUpload =
                (GenerateProcessButton) findViewById(R.id.btnUpload);

        //start upload.
        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressGenerator.start(btnUpload);
                btnUpload.setEnabled(false);
            }
        });
    }

    /*
    Upload complete.
     */
    @Override
    public void onComplete() {
        Toast.makeText(this, R.string.Loading_Complete, Toast.LENGTH_LONG).show();
    }
}
