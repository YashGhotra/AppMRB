package com.example.amandeepkaur.reciepebox.http;

import android.os.AsyncTask;

import org.json.JSONObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Amandeep Kaur on 7/04/2016.
 */
public class LoginTask  extends AsyncTask<String,Long, String>{


    @Override
    protected String doInBackground(String... params) {

        String response = "";
        try {
            URL  url = new URL(params[0]);
            URLConnection urlConnection  =  url.openConnection();
            // Local Stream

            String username  = "gurdeep.singh@gmail.com";
            String password    = "123456";
            JSONObject  jsonObject   = new JSONObject();
            jsonObject.put("username", username);
            jsonObject.put("password",password);

            //String jsonData = "{\"usename\":\"gurdeep.singh@gmail.com\",\"password\":\"123456\"}";
            String jsonData  = jsonObject.toString();


            // This is to Send  data on Output Stream
            OutputStream  os  =  urlConnection.getOutputStream();
            DataOutputStream  dos    =   new DataOutputStream(os);
            // This line of code will send data to server
            dos.write(jsonData.getBytes());
            dos.flush();

            //   This is to read data from Input Stream of server
            DataInputStream  dis  = new DataInputStream(urlConnection.getInputStream());

            // To Append the data from server stream char by char
            StringBuffer sbf   = new StringBuffer();
            while (dis.read()!=-1){
                //95  = o;
              char c   =   (char) dis.read();
                sbf.append(c);
            }
               response   = sbf.toString();

        }

        catch (Exception e)
        {};


        return response;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
