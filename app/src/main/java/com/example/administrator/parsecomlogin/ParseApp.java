package com.example.administrator.parsecomlogin;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;

/**
 * Created by Administrator on 2015-07-28.
 */
public class ParseApp extends Application{

    public void onCreate() {
        super.onCreate();

        Parse.initialize(this, "tI2yTk4x5sY9WFCtk0dmN6GsMeaZqLvNpDdqZP0I", "9hNRopuHzeQAKpMsltIbPMy6XTEwN8ecw4va4faO");

        ParseUser.enableAutomaticUser();
        ParseACL defauAcl = new ParseACL();

        defauAcl.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defauAcl, true);
    }
}
