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
    
    public String token;

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
        
        if ("init".equals(action)) {
                    
            MixpanelAPI mixpanel = MixpanelAPI.getInstance(this.cordova.getActivity().getApplicationContext(), data.getString(0));
            token = data.getString(0);
            callbackContext.success();
                    
            return true;
        }
        else if ("createAlias".equals(action)) {
                    
            MixpanelAPI mixpanel = MixpanelAPI.getInstance(this.cordova.getActivity().getApplicationContext(), token);
            
            String alias = data.getString(0);
    
            mixpanel.alias(alias, mixpanel.getDistinctId());
            mixpanel.identify(mixpanel.getDistinctId());
            callbackContext.success();
             
            return true;       
        }  
        else if ("track".equals(action)) {
                    
            MixpanelAPI mixpanel = MixpanelAPI.getInstance(this.cordova.getActivity().getApplicationContext(), token);
            
            String eventName = data.getString(0);
            JSONObject properties = data.getJSONObject(1);
            mixpanel.track(eventName, properties);

            callbackContext.success();
                    
            return true;
        }
        else if ("identify".equals(action)) {
                    
            MixpanelAPI mixpanel = MixpanelAPI.getInstance(this.cordova.getActivity().getApplicationContext(), token);
            
            String distinctId = null;
            if(data.getString(0) != null){
                distinctId = data.getString(0);
            }
            else{
                distinctId = mixpanel.getDistinctId();
            }
            
            mixpanel.identify(distinctId);

            callbackContext.success();
      
            return true;

        }
        else if ("peopleSet".equals(action)) {
                    
            MixpanelAPI mixpanel = MixpanelAPI.getInstance(this.cordova.getActivity().getApplicationContext(), token);
            
            mixpanel.identify(mixpanel.getDistinctId());
            JSONObject properties = data.getJSONObject(0);
            mixpanel.getPeople().set(properties);

            callbackContext.success();
      
            return true;

        }
        else if ("trackCharge".equals(action)) {
                    
            MixpanelAPI mixpanel = MixpanelAPI.getInstance(this.cordova.getActivity().getApplicationContext(), token);
            
            mixpanel.identify(mixpanel.getDistinctId());
            double amount = data.optDouble(0);
            mixpanel.getPeople().trackCharge(amount, new JSONObject());

            callbackContext.success();
      
            return true;

        }
        else if ("trackChargeWithProperties".equals(action)) {
                    
            MixpanelAPI mixpanel = MixpanelAPI.getInstance(this.cordova.getActivity().getApplicationContext(), token);
            
            mixpanel.identify(mixpanel.getDistinctId());
            double amount = data.optDouble(0);
            JSONObject properties = data.getJSONObject(1);
            mixpanel.getPeople().trackCharge(amount, properties);

            callbackContext.success();
      
            return true;

        }
        else if ("setShowNotificationOnActive".equals(action)) {

            callbackContext.error("Not Implemented");
      
            return true;

        }
        else if ("showNotification".equals(action)) {

            callbackContext.error("Not Implemented");
      
            return true;

        }
        else if ("showNotificationWithID".equals(action)) {

            callbackContext.error("Not Implemented");
      
            return true;

        }
        else if ("setShowSurveyOnActive".equals(action)) {

            callbackContext.error("Not Implemented");
      
            return true;

        }
        else if ("showSurvey".equals(action)) {

            callbackContext.error("Not Implemented");
      
            return true;

        }
        else if ("showSurveyWithID".equals(action)) {

            callbackContext.error("Not Implemented");
      
            return true;

        }
        else if ("showSurveyWithID".equals(action)) {

            callbackContext.error("Not Implemented");
      
            return true;

        }
        else if ("increment".equals(action)) {
                    
            MixpanelAPI mixpanel = MixpanelAPI.getInstance(this.cordova.getActivity().getApplicationContext(), token);
            mixpanel.identify(mixpanel.getDistinctId());
            String property = data.getString(0);
            double by = data.optDouble(1);
            mixpanel.increment(property, by);
            
            callbackContext.success();
      
            return true;

        }
        else if ( "register".equals( action ) ) {
                    
                    try{

                        MixpanelAPI mixpanel = MixpanelAPI.getInstance( this.cordova.getActivity().getApplicationContext(), token );
                        mixpanel.identify(mixpanel.getDistinctId());
                        
                        MixpanelAPI.People people = mixpanel.getPeople();
                        people.identify(mixpanel.getDistinctId());

                        JSONObject obj = data.getJSONObject(0);

                        people.initPushHandling(obj.getString("googleSenderId"));
                        
                        //ensure is sent 
                        mixpanel.flush(); // sends the info

                        callbackContext.success();
                    }
                    catch(Exception e) {
                        
                        callbackContext.error(e.getMessage());
                        
                    }
          return true;
        }
        else if ( "unregister".equals( action ) ) {
                    
            callbackContext.error("Not Implemented");
      
            return true;
        }
        else if ("setApplicationIconBadgeNumber".equals(action)) {

            callbackContext.error("Not Implemented");
      
            return true;

        }
        return false;  // Returning false results in a "MethodNotFound" error.
    }

}
