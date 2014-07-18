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
    public boolean execute( String action, JSONArray data, CallbackContext callbackContext ) throws JSONException {
        if ( "initPushHandling".equals( action ) ) {
                    try{

                        MixpanelAPI mixpanel = MixpanelAPI.getInstance( this.cordova.getActivity().getApplicationContext(), data.getString( 0 ) );
                        
                        MixpanelAPI.People people = mixpanel.getPeople();
                        people.identify( data.getString( 1 ) );
                        people.initPushHandling( data.getString( 2 ) );
                        System.out.println( "mixpanel people  " + data.getString( 1 ) + " - " + data.getString( 2 ) + "-" + people );
                        //people.set("hello", "world");
                        mixpanel.flush(); // sends the info

                        callbackContext.success();
                    }
                    catch( Exception e ) {
                        callbackContext.error( "Error is Mixpanel " + e );
                        
                    }
          return true;
        }
        return false;  // Returning false results in a "MethodNotFound" error.
    }

}
