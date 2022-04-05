package ro.pub.cs.systems.eim.lab05.startedserviceactivity.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

import java.util.ArrayList;

import ro.pub.cs.systems.eim.lab05.startedserviceactivity.general.Constants;

public class StartedServiceBroadcastReceiver extends BroadcastReceiver {

    private TextView messageTextView = null;

    public StartedServiceBroadcastReceiver() {}

    public StartedServiceBroadcastReceiver(TextView messageTextView) {
        this.messageTextView = messageTextView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action =  intent.getAction();
        String data = "";
        if (action == null) {
            return;
        }
        if (action.equals(Constants.ACTION_STRING)) {
            data = intent.getStringExtra(Constants.DATA);
        }

        if (action.equals(Constants.ACTION_INTEGER)) {
            data = Integer.toString(intent.getIntExtra(Constants.DATA, 0));
        }

        if (action.equals(Constants.ACTION_ARRAY_LIST)) {
            ArrayList<String> extra = intent.getStringArrayListExtra(Constants.DATA);
            for (int i = 0; i < extra.size(); i++) {
                data = data.concat("\n".concat(extra.get(i)));
            }
        }

        if (messageTextView != null) {
            messageTextView.append("\n".concat(data));
        } else {
            Intent startedServiceActivityIntent = new Intent(context, StartedServiceActivity.class);
            startedServiceActivityIntent.putExtra(Constants.MESSAGE, data);
            startedServiceActivityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP);
            context.startActivity(startedServiceActivityIntent);

        }
    }
}
