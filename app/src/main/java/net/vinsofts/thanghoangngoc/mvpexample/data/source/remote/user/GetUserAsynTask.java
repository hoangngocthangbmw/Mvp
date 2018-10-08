package net.vinsofts.thanghoangngoc.mvpexample.data.source.remote.user;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import net.vinsofts.thanghoangngoc.mvpexample.data.UserDataSource;
import net.vinsofts.thanghoangngoc.mvpexample.data.model.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GetUserAsynTask {
    List<User> list = new ArrayList<User>();
    private UserDataSource.OnFetchDataListener<User> mOnFetchDataListener;

    public GetUserAsynTask(UserDataSource.OnFetchDataListener listener) {
        mOnFetchDataListener = listener;
    }

    public void getListUsers(String url, Context context) {
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONArray jsonArray;
                try {
                    jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        list.add(new User(jsonObject.getString("name"), jsonObject.getString("email")));
                    }
                    mOnFetchDataListener.onFetchDataSuccess(list);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mOnFetchDataListener.onFetchDataFailure(error.getMessage());
            }
        });
        queue.add(stringRequest);
    }
}
