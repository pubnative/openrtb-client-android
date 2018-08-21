// The MIT License (MIT)
//
// Copyright (c) 2017 PubNative GmbH
//
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
//
// The above copyright notice and this permission notice shall be included in all
// copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
// SOFTWARE.

package net.pubnative.openrtb.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class DeviceUtils {

    private static final String TAG = DeviceUtils.class.getSimpleName();

    public enum ConnectionType {
        UNKNOWN,
        CELLULAR,
        WIFI
    }

    /**
     * Gets you the PackageInfo object based on the Context object passed in.
     *
     * @return PackageInfo object if context is valid, else null
     */
    public static PackageInfo getPackageInfo(Context context) {
        PackageInfo result = null;
        try {
            result = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (Exception e) {
            Log.e(TAG, "getPackageInfo - Error:" + e);
        }
        return result;
    }

    protected static NetworkInfo getActiveNetworkInfo(Context context) {

        NetworkInfo result = null;
        Context appContext = context.getApplicationContext();
        ConnectivityManager manager = (ConnectivityManager) appContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (manager == null) {
            Log.w(TAG, "ERROR: Couldn't retrieve valid ConnectivityManager, please ensure that you added `ACCESS_NETWORK_STATE` permission to your Manifest file");
        } else {
            result = manager.getActiveNetworkInfo();
        }
        return result;
    }

    /**
     * Checks if the current networkName is available and connected to internet
     *
     * @return true if it's available and connected
     */
    public static boolean isNetworkAvailable(Context context) {

        boolean result = false;
        NetworkInfo info = getActiveNetworkInfo(context);
        if (info == null) {
            Log.w(TAG, "ERROR: Couldn't retrieve valid NetworkInfo, please ensure that you added `ACCESS_NETWORK_STATE` permission to your Manifest file");
        } else {
            result = info.isConnectedOrConnecting();
        }
        return result;
    }

    /**
     * Extracts the specific connection type to which this device is connected from WIFI or CELLULLAR
     *
     * @return connection type
     */
    public static ConnectionType getConnectionType(Context context) {

        ConnectionType result = ConnectionType.UNKNOWN;
        NetworkInfo info = getActiveNetworkInfo(context);
        if (info != null && info.isConnected()) {
            result = ConnectionType.CELLULAR;
            if (info.getType() == ConnectivityManager.TYPE_WIFI) {
                result = ConnectionType.WIFI;
            }
        }
        return result;
    }
}
