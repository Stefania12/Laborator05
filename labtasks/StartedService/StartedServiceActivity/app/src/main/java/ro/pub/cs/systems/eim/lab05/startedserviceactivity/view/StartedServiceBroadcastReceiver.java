package ro.pub.cs.systems.eim.lab05.startedserviceactivity.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import ro.pub.cs.systems.eim.lab05.startedserviceactivity.general.Constants;

public class StartedServiceBroadcastReceiver extends BroadcastReceiver {

    private TextView messageTextView;

    // TODO: exercise 9 - default constructor

    public StartedServiceBroadcastReceiver(TextView messageTextView) {
        this.messageTextView = messageTextView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action =  intent.getAction();
        if (action.equals(Constants.ACTION_STRING)) {
            String data = intent.getStringExtra(Constants.DATA);
            if (messageTextView != null) {
                messageTextView.setText(messageTextView.getText().toString().concat("\n".concat(data)));
            }
        }

        if (action.equals(Constants.ACTION_INTEGER)) {
            int data = intent.getIntExtra(Constants.DATA, 0);
            if (messageTextView != null) {
                messageTextView.setText(messageTextView.getText().toString().concat("\n".concat(Integer.toString(data))));
            }
        }

        if (action.equals(Constants.ACTION_ARRAY_LIST)) {
            ArrayList<String> data = intent.getStringArrayListExtra(Constants.DATA);
            if (messageTextView != null) {
                for (int i = 0; i < data.size(); i++) {
                    messageTextView.setText(messageTextView.getText().toString().concat("\n".concat(data.get(i))));
                }
            }
        }

        // TODO: exercise 9 - restart the activity through an intent
        // if the messageTextView is not available
    }
}
