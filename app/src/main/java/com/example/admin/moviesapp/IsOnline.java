package com.example.admin.moviesapp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Admin on 05-02-2016.
 */
 
// Check whether the user is online or not
public class IsOnline {
    public static boolean isNetworkStatusAvailable (Context context) {
        
        //Get connectivity manager system service to get network information
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null)
        {
            // Get the network information from above the connectivity manager 
            NetworkInfo netInfos = connectivityManager.getActiveNetworkInfo();
            
            // Gives true if the user is connected to a internet network
            if(netInfos != null)
            {
                return netInfos.isConnected();
            }
        }
        return false;
    }
}
