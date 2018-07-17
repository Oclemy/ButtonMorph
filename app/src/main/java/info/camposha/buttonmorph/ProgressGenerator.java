package info.camposha.buttonmorph;

import com.dd.processbutton.ProcessButton;

import android.os.Handler;

import java.util.Random;
/*
Generate for us progress
 */
public class ProgressGenerator {

    /*
    CompletionListener Interfae
     */
    public interface OnCompleteListener {

        public void onComplete();
    }

    private OnCompleteListener mListener;
    private int mProgress;

    /*
    Progress generator constructor
     */
    public ProgressGenerator(OnCompleteListener listener) {
        mListener = listener;
    }

    /*
    Start progress
     */
    public void start(final ProcessButton button) {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mProgress += 10;
                button.setProgress(mProgress);
                if (mProgress < 100) {
                    handler.postDelayed(this, generateDelay());
                } else {
                    mListener.onComplete();
                }
            }
        }, generateDelay());
    }

    /*
    random clas
     */
    private Random random = new Random();

    /*
    generate delay
     */
    private int generateDelay() {
        return random.nextInt(1000);
    }
}
