package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

public class LogoutActivity extends AppCompatActivity {

    /*private static AppState singleInstance;
    private boolean isLoggingOut;
    private AppState() {
    }

    public static AppState getSingleInstance() {
        if (singleInstance == null) {
            singleInstance = new AppState();
        }
        return singleInstance;
    }

    public boolean isLoggingOut() {
        return isLoggingOut;
    }

    public void setLoggingOut(boolean isLoggingOut) {
        this.isLoggingOut = isLoggingOut;
    }

    logout.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View arg0) {
            SharedPreferences myPrefs = getSharedPreferences("MY",
                    MODE_PRIVATE);
            SharedPreferences.Editor editor = myPrefs.edit();
            editor.clear();
            editor.commit();
            AppState.getSingleInstance().setLoggingOut(true);
            Log.d(TAG, "Now log out and start the activity login");
            Intent intent = new Intent(HomePage.this,
                    LoginPage.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);

        }
    });*/

}
