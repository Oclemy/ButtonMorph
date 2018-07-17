package info.camposha.buttonmorph;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set strings.xml array items to arrayadapter then to ListActivity.
		String[] items = getResources().getStringArray(R.array.sample_list);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        setListAdapter(adapter);
    }

    /*
    When a ListActivity item is clicked. Open appropriate activity.
     */
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        switch (position) {
            case 0:
                startSignInActivity(false);
                break;
            case 1:
                startSignInActivity(true);
                break;
            case 2:
                startMessageActivity();
                break;
            case 3:
                startUploadActivity();
                break;
            case 4:
                startStateSampleActivity();
                break;
        }
    }

    /*
    Open StateSampleActivity via intent.
     */
    private void startStateSampleActivity() {
        Intent intent = new Intent(this, StateSampleActivity.class);
        startActivity(intent);
    }

    /*
    Open UploadActivity via intent.
     */
    private void startUploadActivity() {
        Intent intent = new Intent(this, UploadActivity.class);
        startActivity(intent);
    }

    /*
    Open SignInActivity via intent.
     */
    private void startSignInActivity(boolean isEndlessMode) {
        Intent intent = new Intent(this, SignInActivity.class);
        intent.putExtra(SignInActivity.EXTRAS_ENDLESS_MODE, isEndlessMode);
        startActivity(intent);
    }

    /*
    Open MessageActivity via intent.
     */
    private void startMessageActivity() {
        Intent intent = new Intent(this, MessageActivity.class);
        startActivity(intent);
    }
}
