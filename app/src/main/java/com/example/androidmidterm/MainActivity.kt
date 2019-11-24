package com.example.androidmidterm

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.androidmidterm.R
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject
import android.widget.TextView;
import com.android.volley.toolbox.StringRequest

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val textView = findViewById<TextView>(R.id.eventTitle)

        // Volley uses internet permissions which needs to be enabled in the AndroidManifest.xml
        val queue = Volley.newRequestQueue(this)

        val url = "https://random-number-generator-251217.appspot.com/"


        val stringRequest = StringRequest(Request.Method.GET, url,
            Response.Listener<String> { response ->
                eventTitle.setText(response.toString())
            },
//            Response.ErrorListener { eventTitle.text = (0..1000001).random().toString()
                Response.ErrorListener { eventTitle.text = "That didn't work!"

                }
        )


        // button is the id for the button in activity_main.xml
        button.setOnClickListener {
            queue.add(stringRequest)
        }
    }
}
