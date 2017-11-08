/**
 */
package com.mv;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import android.util.Log;
import android.content.Intent;
import android.os.Bundle;
import android.content.Context;

import java.util.Date;

/*
* @autor Jeronimo Nascimento
* @version 1.0
* Empresa MV Sistemas
* @data 06/04/2017
*/


public class ExternalBroadcaster extends CordovaPlugin {

  private static final String TAG = "ExternalBroadcaster";

  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);

    Log.d(TAG, "Initializing ExternalBroadcaster");
  }

  /**
  * Metodo utilizado para envio do evento nativo
  */
   private void fireNativeEvent() {

      Intent intent = new Intent("android.intent.action.BARCODE_NOTIFY");
  		intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);

      Bundle bundle = new Bundle();
  		bundle.putString("COMPORT","/dev/ttyO0");
  		//it means the barcode reader connect toUART ttyO0

      intent.putExtras(bundle);
      sendBroadcast( intent );
   }

  /*
  * Metodo utilizado para o envio do broadcast através de context da aplicação
  */
	protected void sendBroadcast(android.content.Intent intent) {
     super.webView.getContext().sendBroadcast(intent);
  }

  /**
  * Metodo executado ao chamar o pluguin pela ionic
  */
  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {

    if(action.equals("broadcast")) {

      try {
  			cordova.getThreadPool().execute(new Runnable() {

            @Override
            public void run() {
               fireNativeEvent();
            }

        });

        callbackContext.success();
        return true;

  			} //try
  			catch (Exception e) {
  				Log.e(e.getClass().getName(), e.getMessage(), e);
  			} //catch
  	  }

    return true;

  }
}
