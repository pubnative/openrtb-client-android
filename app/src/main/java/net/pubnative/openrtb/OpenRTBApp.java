package net.pubnative.openrtb;

import android.app.Application;

public class OpenRTBApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        OpenRTB.init(this);
    }
}
