package com.mixpanel.android;
import com.mixpanel.android.mpmetrics.*;
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
    
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if ("init".equals(action)) {
                    try{
                        MixpanelAPI mixpanel = MixpanelAPI.getInstance(this.cordova.getActivity().getApplicationContext(), data.getString(0));
                        JSONObject props = new JSONObject();    
                        props.put("Test", "True");
                        mixpanel.track("Open_App", props);
                        System.out.println("hello world "+mixpanel+" - "+data.getString(0));
                        callbackContext.success();
                    }
                    catch(Exception e){
                        callbackContext.error("Error is Mixpanel "+e);
                        
                    }
          return true;
        }
        return false;  // Returning false results in a "MethodNotFound" error.
    }

}
