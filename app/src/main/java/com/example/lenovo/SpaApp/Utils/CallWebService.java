package com.example.lenovo.SpaApp.Utils;

import android.content.Context;
import android.os.Handler;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.lenovo.SpaApp.CustomDialog.CustomCardleDialog;
import com.example.lenovo.SpaApp.Interfaces.CallBackInterface;
import com.example.lenovo.SpaApp.MyApplication;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/**
 * Created by Lenovo on 30-10-2015.
 */
public class CallWebService {

    private static Context context = null;

    private static CallWebService instance = null;

    private static CustomProgressDialog progressDialog = null;

    private static CustomCardleDialog customCardleDialog = null;

    public static int GET = Request.Method.GET;

    public static int POST = Request.Method.POST;


    public static CallWebService getInstance(Context context, boolean showProgressBar) {
        instance.context = context;
        if (context != null && showProgressBar) {
            customCardleDialog = new CustomCardleDialog(context);

        } else {

            customCardleDialog = null;
        }
        if (instance == null) {
            instance = new CallWebService();
        }

        return instance;
    }

    public void hitJSONObjectVolleyWebService(int requestType, final String url, HashMap<String, String> json, final CallBackInterface callBackinerface) {
        // public void hitJSONObjectVolleyWebService(int requestType, final String url, JSONObject json, final CallBackInterface callBackinerface) {
        if (customCardleDialog != null)
            customCardleDialog.show();

        JsonObjectRequest request = new JsonObjectRequest(requestType, url, json == null ? null : (new JSONObject(json)), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(final JSONObject response) {

                try {
                    MyApplication.getInstance(context).getRequestQueue().getCache().invalidate(url, true);
                    if (response.getString(Constants.STATUS_CODE).equalsIgnoreCase("True")) {
                        if (customCardleDialog != null) {
                            customCardleDialog.Success();

                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    customCardleDialog.dismiss();
                                    try {
                                        callBackinerface.onJsonObjectSuccess(response);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }

                                }
                            }, 2000);
                        } else
                            callBackinerface.onJsonObjectSuccess(response);
                    } else {
                        if (customCardleDialog != null) {
                            customCardleDialog.Fail(response.optString(Constants.MESSAGE));
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    customCardleDialog.dismiss();
                                    callBackinerface.onFailure(response.optString(Constants.MESSAGE));

                                }
                            }, 2000);
                        } else
                            callBackinerface.onFailure(response.optString(Constants.MESSAGE));
                    }
                } catch (final JSONException e) {
                    if (customCardleDialog != null) {
                        customCardleDialog.Fail(e.getMessage());

                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                callBackinerface.onFailure(e.getMessage());

                            }
                        }, 2000);
                    } else
                        callBackinerface.onFailure(e.getMessage());

                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(final VolleyError error) {
                MyApplication.getInstance(context).getRequestQueue().getCache().invalidate(url, true);
                if (customCardleDialog != null) {
                    customCardleDialog.Fail(error.getMessage());

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            customCardleDialog.dismiss();
                            callBackinerface.onFailure(error.getMessage());

                        }
                    }, 2000);
                } else
                    callBackinerface.onFailure(error.getMessage());


            }
        });

        MyApplication.getInstance(context).addToRequestQueue(request, url);
    }


    // public void hitWithJSONObjectVolleyWebService(int requestType, final String url, HashMap<String, String> json, final CallBackInterface callBackinerface) {
    public void hitWithJSONObjectVolleyWebService(int requestType, final String url, JSONObject json, final CallBackInterface callBackinerface) {
        if (customCardleDialog != null)
            customCardleDialog.show();

        JsonObjectRequest request = new JsonObjectRequest(requestType, url, json == null ? null : (json), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(final JSONObject response) {

                try {
                    MyApplication.getInstance(context).getRequestQueue().getCache().invalidate(url, true);
                    if (response.getString(Constants.STATUS_CODE).equalsIgnoreCase("True")) {
                        if (customCardleDialog != null)
                            customCardleDialog.dismiss();
                        callBackinerface.onJsonObjectSuccess(response);
                    } else {
                        if (customCardleDialog != null) {
                            customCardleDialog.Fail(response.optString(Constants.MESSAGE));
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    customCardleDialog.dismiss();
                                    callBackinerface.onFailure(response.optString(Constants.MESSAGE));

                                }
                            }, 2000);
                        } else
                            callBackinerface.onFailure(response.optString(Constants.MESSAGE));
                    }
                } catch (final JSONException e) {
                    if (customCardleDialog != null) {
                        customCardleDialog.Fail(e.getMessage());

                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                callBackinerface.onFailure(e.getMessage());

                            }
                        }, 2000);
                    } else
                        callBackinerface.onFailure(e.getMessage());

                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(final VolleyError error) {
                MyApplication.getInstance(context).getRequestQueue().getCache().invalidate(url, true);
                if (customCardleDialog != null) {
                    customCardleDialog.Fail(getErrorMessage(error));

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            customCardleDialog.dismiss();
                            callBackinerface.onFailure(getErrorMessage(error));

                        }
                    }, 2000);
                } else
                    callBackinerface.onFailure(getErrorMessage(error));


            }
        });

        MyApplication.getInstance(context).addToRequestQueue(request, url);
    }

    protected String getErrorMessage(VolleyError error) {
        String body = "";
        if (error.networkResponse.data != null) {
            try {
                body = new String(error.networkResponse.data, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return body;
    }

}