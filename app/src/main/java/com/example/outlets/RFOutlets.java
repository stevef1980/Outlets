package com.example.outlets;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class RFOutlets {

    Context mCtxt;
    String mIPAddr;



    RFOutlets(Context pCtxt, String IPAddr)
    {
        mCtxt = pCtxt;
        mIPAddr = IPAddr;

    }

    public void SendCode(String pCode)
    {
        RequestQueue queue = Volley.newRequestQueue(mCtxt);
        // Request a string response from the provided URL.
        String url = "http://" + mIPAddr + "/rf2/tog2.php?code=\"" + pCode + "\"";


        StringRequest req = new StringRequest(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        //textView.setText("Response is: "+ response.substring(0,500));
                        Toast.makeText(mCtxt, "Success!", Toast.LENGTH_SHORT).show();


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //textView.setText("That didn't work!\n" + error.toString());
                Toast.makeText(mCtxt, "Error! " + error.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        // Add the request to the RequestQueue.
        queue.add(req);
    }
}
