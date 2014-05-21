package net.schwadron.fingr;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;


public class ImgurUploader {
	private static final String TAG = ImgurUploader.class.getSimpleName();
	private static final String UPLOAD_URL = "https://api.imgur.com/3/image";
	public static final String MY_IMGUR_CLIENT_ID = "e37468434493d67";
    public static final String MY_IMGUR_CLIENT_SECRET = "";
    
    private Context context;
//	private Uri imageUri; 
    private static String imgurLink;
    
    private static ImgurUploader INSTANCE;

    ImgurUploader() {}

    public static ImgurUploader getInstance() {
        if (INSTANCE == null)
            INSTANCE = new ImgurUploader();
        return INSTANCE;
    }

	public void upload(Uri imageUri, Context applicationContext) {
		context = applicationContext;
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
	    StrictMode.setThreadPolicy(policy);
	    
		File file = new File(imageUri.getPath());
		InputStream imageIn = null;
		try {
			imageIn = applicationContext.getContentResolver().openInputStream(imageUri);
		} catch (FileNotFoundException e) {
			Log.e(TAG, "could not open InputStream", e);
		}
		
		InputStream input = null;
		HttpURLConnection conn = null;
        InputStream responseIn = null;
        String id = null;
        
		try {
			input = new FileInputStream(file);
            conn = (HttpURLConnection) new URL(UPLOAD_URL).openConnection();
            conn.setDoOutput(true);

            conn.setRequestProperty("Authorization", "Client-ID " + MY_IMGUR_CLIENT_ID);
            
            OutputStream out = conn.getOutputStream();

            byte[] buf = new byte[8192];
            /*int count = 0;
            int n = 0;
            while (-1 != (n = input.read(buf))) {
            	out.write(buf, 0, n);
                count += n;
            }
            out.flush();
            out.close();*/

            int c = 0;
            while ((c = input.read(buf, 0, buf.length)) > 0) {
            	out.write(buf, 0, c);
            	out.flush();
            }
            out.close();

            
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                responseIn = conn.getInputStream();
                id = onInput(responseIn);
            }
            else {
                Log.i(TAG, "responseCode=" + conn.getResponseCode());
                responseIn = conn.getErrorStream();
                StringBuilder sb = new StringBuilder();
                Scanner scanner = new Scanner(responseIn);
                while (scanner.hasNext()) {
                    sb.append(scanner.next());
                }
                Log.i(TAG, "error response: " + sb.toString());
//                return null;
            }
		} catch (Exception ex) {
			Log.e(TAG, "Error during POST", ex);
//			return null;
		} finally {
            try {
                responseIn.close();
            } catch (Exception ignore) {}
            try {
                conn.disconnect();
            } catch (Exception ignore) {}
			try {
//				imageIn.close();
				input.close();
			} catch (Exception ignore) {}
		}
		// open the result in new browser
//		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://imgur.com/" + id));
//		applicationContext.startActivity(browserIntent);
		
	}
    
    private static int copy(InputStream input, OutputStream output) throws IOException {
        byte[] buffer = new byte[8192];
        int count = 0;
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
            count += n;
        }
        return count;
    }
    
	protected String onInput(InputStream in) throws Exception {
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(in);
        while (scanner.hasNext()) {
            sb.append(scanner.next());
        }

        JSONObject root = new JSONObject(sb.toString());
        String id = root.getJSONObject("data").getString("id");
        String deletehash = root.getJSONObject("data").getString("deletehash");

		Log.i(TAG, "new imgur url: http://imgur.com/" + id + " (delete hash: " + deletehash + ")");
		Toast.makeText(context, "http://imgur.com/" + id, Toast.LENGTH_LONG).show();
		
		imgurLink = id;
		
		return id;
	}
	
	public static String getImgurLink()
	{
		return imgurLink;
	}
    
}

//Jonathan Schwadron
//Mobile Application Development
//Final Project Fall 2013