package com.mdev.sc_github;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class AllCommand {
	public boolean isConnectingToInternet(Context _context) {
		try {
			ConnectivityManager connectivity = (ConnectivityManager) _context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			if (connectivity != null) {
				NetworkInfo[] info = connectivity.getAllNetworkInfo();
				if (info != null)
					for (int i = 0; i < info.length; i++)
						if (info[i].getState() == NetworkInfo.State.CONNECTED) {
							return true;
						}
			}

		}catch (Exception e){}
		return false;
	}
	public String POST_OK_HTTP_SendData(String url, RequestBody formBody){
		ShowLogcat("*** POST URL ***",url);
		try{
			OkHttpClient client = new OkHttpClient();
			Request request = new Request.Builder()
					.url(url)
					.post(formBody)
					.build();
			String s = formBody.toString();
			Response response = client.newCall(request).execute();
			if (response.isSuccessful()){
				Headers responseHeaders = response.headers();
				for (int i = 0; i < responseHeaders.size(); i++) {
					ShowLogcat("Post Parameter ",responseHeaders.name(i) + ": " + responseHeaders.value(i));
				}
				return response.body().string().toString();
			}
		}catch (Exception e){
			ShowLogcat("*** Err ***","Err POST_OK_HTTP_SendData " + e.getMessage());
			return "";
		}
		return "";
	}
	public String GET_OK_HTTP_SendData(String url){
		ShowLogcat("*** GET URL ***",url);
		try{
			OkHttpClient client = new OkHttpClient();
			Request request = new Request.Builder().url(url).build();
			Response response = client.newCall(request).execute();
			return response.body().string();
		}catch (Exception e){
			Log.e("*** Err ***","Err GET_OK_HTTP_SendData " + e.getMessage());
			return "";
		}
	}

	public void ShowLogcat(String tag, String msg) {
		if (BuildConfig.DEBUG) {
			Log.e("***" + tag + "***",msg);
		}
	}
}
