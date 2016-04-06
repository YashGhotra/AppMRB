package com.example.amandeepkaur.reciepebox;

/**
 * Created by Amandeep Kaur on 31/03/2016.
 */

import android.content.Context;
import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;



/**
 * Created by Test on 26/08/2015.
 */
public class ProfileFunction {

    private ProfileFunction () {}

    public static ProfileFunction newInstance() {
        return new ProfileFunction();
    }



    /*Require Thread */
    public String updateProfileToServer(String jsonData , String companyUrl, String cookies, int pathResourceId) {


        InputStream is = null;

        try {


            URL url = new URL("http://www.myreceipebox.com/");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.addRequestProperty("content-type", "application/json");
            conn.addRequestProperty("content-length", ""+jsonData.length());
            conn.addRequestProperty("Authorization", cookies);
            conn.setUseCaches(false);
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(10000);

            //conn.setDoOutput(true);

            // conn.setRequestProperty("Cookie", cookies.split(";", 1)[0]);


            System.out.println("================== ");
            Log.e("", "content-type application/json");
            Log.e("", "Authorization == " + cookies);


            //String postData = "{ \"username\": \""+username+"\" }";
            //byte[] data = postData.getBytes();
            conn.getOutputStream().write(jsonData.getBytes());
            int code = conn.getResponseCode();

            is = conn.getInputStream();
            int ch;
            StringBuffer sb = new StringBuffer();
            while ((ch = is.read()) != -1) {
                sb.append((char) ch);
            }


            if(code!=200){
                sb = null;

            }

            is.close();
            conn.disconnect();

            String pattern = ":\\s*null\\s,?";
            String trimmedString = sb.toString().replaceAll(pattern, ":\"\"");

            InputStream stream = new ByteArrayInputStream(trimmedString.getBytes());

            stream.close();

            //return profileResponse;

            return  sb.toString();

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}


