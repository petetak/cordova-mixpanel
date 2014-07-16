package com.mixpanel.android;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;


public class CDVMixpanel extends CordovaPlugin {
    private static final String TAG = "CDVMixpanel";

    public static final String ACTION_START = "start";
    public static final String ACTION_STOP = "stop";
    public static final String ACTION_CONFIGURE = "configure";
    public static final String ACTION_SET_CONFIG = "setConfig";
  public static final String ACTION_GET_ALL_POINTS = "getAllPoints";
  public static final String ACTION_DELETE_ALL_POINTS = "deleteAllPoints";

    private Intent updateServiceIntent;
    
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if ("init".equals(action)) {
            System.out.println("hello world "+action);
            callbackContext.success();
            return true;
        }
        return false;  // Returning false results in a "MethodNotFound" error.
    }

}
