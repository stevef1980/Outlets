package com.example.outlets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
    StringRequest mReq;
    RequestQueue mQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQueue = Volley.newRequestQueue(this);
    }

    public void OnClick(View v)
    {
        String code;
        int id = v.getId();
        RFOutlets rf = new RFOutlets(this,"192.168.1.49");

        switch (id)
        {
            case R.id.btnOn1:
                code = "21811";
                break;
            case R.id.btnOff1:
                code = "21820";
                break;
            case R.id.btnOn2:
                code = "21955";
                break;
            case R.id.btnOff2:
                code = "21964";
                break;
            case R.id.btnOn3:
                code = "4543795";
                break;
            case R.id.btnOff3:
                code = "4543804";
                break;
            case R.id.btnOn4:
                code = "4543939";
                break;
            case R.id.btnOff4:
                code = "4543948";
                break;
            case R.id.btnOn5:
                code = "4545795";
                break;
            case R.id.btnOff5:
                code = "4545804";
                break;
            case R.id.btnOn6:
                code = "4551939";
                break;
            case R.id.btnOff6:
                code = "4551948";
                break;
            case R.id.btnOn7:
                code = "22275";
                break;
            case R.id.btnOff7:
                code = "22284";
                break;
            default:
                code = "0000";
        }

        SendCode(code);
        //rf.SendCode(code);
    }

    public void SendCode(String code)
    {
        String url = "http://192.168.1.49/rf2/tog.php?code=\"";
        url = url + code + "\"";
        // Request a string response from the provided URL.
        mReq = new StringRequest(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        //textView.setText("Response is: "+ response.substring(0,500));
                        Toast.makeText(getApplicationContext(), "Success!", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //textView.setText("That didn't work!\n" + error.toString());
                Toast.makeText(getApplicationContext(), "Error!", Toast.LENGTH_SHORT).show();
            }
        });

        // Add the request to the RequestQueue.
        mQueue.add(mReq);
    }
}
