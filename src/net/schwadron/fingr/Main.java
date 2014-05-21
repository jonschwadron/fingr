package net.schwadron.fingr;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends Activity {

	private AnimationDrawable animate;
	private Bitmap bit;
	private SignLanguageDictionary asl;
	private GifGenerator gif;
	private ImgurUploader url;
	boolean isGifSaved;
	Uri imageUri;
	private int gifCount;
	InputStream id;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		final ImageView imgFrame = (ImageView)findViewById(R.id.imgFinger);
		imgFrame.setBackgroundResource(R.drawable.animation);
		animate = (AnimationDrawable) imgFrame.getBackground();

		final EditText input = (EditText) findViewById(R.id.editTextInput);
		
		Button convertToASL = (Button) findViewById(R.id.buttonGo);
		final Button save = (Button) findViewById(R.id.buttonSave);
		Button upload = (Button) findViewById(R.id.buttonUpload);
		
		boolean mExternalStorageAvailable = false;
		boolean mExternalStorageWriteable = false;
		String state = Environment.getExternalStorageState();
		
		isGifSaved = false;
		gifCount = 0;
		
		final String FILE_NAME = "fingr";
		final String FILE_FORMAT = ".gif";
		
		//checks if SDCARD is mounted
		if (Environment.MEDIA_MOUNTED.equals(state)) {
		    // We can read and write the media
		    mExternalStorageAvailable = mExternalStorageWriteable = true;
		    Toast.makeText(Main.this, "Media Mounted", Toast.LENGTH_SHORT).show();
		} else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
		    // We can only read the media
		    mExternalStorageAvailable = true;
		    mExternalStorageWriteable = false;
		} else {
		    // Something else is wrong. It may be one of many other states, but all we need
		    //  to know is we can neither read nor write
		    mExternalStorageAvailable = mExternalStorageWriteable = false;
		    Toast.makeText(Main.this, "Media Not Mounted", Toast.LENGTH_SHORT).show();
		}
		
		asl = new SignLanguageDictionary(this);
		gif = new GifGenerator(this);
		url = new ImgurUploader();
		
		//translate button
		convertToASL.setOnClickListener(new OnClickListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
				// resets the save/upload process
				isGifSaved = false;
				imageUri = null;
				
				//loop 2 times to completely clear the animation buffer
				for (int i = 0; i < 2; i++)
				{
					animate.stop();
					((AnimationDrawable)(imgFrame.getBackground())).stop();
					imgFrame.setBackgroundDrawable(null);
					imgFrame.setBackgroundResource(R.drawable.animation);
					imgFrame.destroyDrawingCache();
					imgFrame.clearAnimation();
					animate = (AnimationDrawable) imgFrame.getBackground();		
				}
				
				//add blank frame
				animate.addFrame(getResources().getDrawable(R.drawable._), 200);

				String inputText = input.getText().toString().toLowerCase();
				
				//animator
				int i = 0;
				
				while(i < inputText.length())
				{
					char charPosition = inputText.charAt(i);
					//display.setText(Character.toString(charPosition));
					
					if (!(i+1>=inputText.length()) && inputText.charAt(i) == inputText.charAt(i+1))
					{
						
						animate = asl.getFirstBit(animate, charPosition);
						animate = asl.getSecondBit(animate, charPosition);
						i+=2;
					} 
					else if(i < inputText.length())
					{
						animate = asl.getFirstBit(animate, charPosition);
						i++;
					}
					
				}
				
				//hides the softkeyboard
				InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(input.getWindowToken(), 0);
				
				animate.start();
			}
			
		});
		
		//save button
		save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				
				// generate
				isGifSaved = generateGif(bos, input);
				String fileName = FILE_NAME + gifCount + FILE_FORMAT;
				
				//file output. note - creating a folder in emulator does not
				//work right but it works perfectly on actual devices.
				
				//use this path for actual devices
				//File directory = new File(Environment.getExternalStorageDirectory() + File.separator + "fingr");
				//directory.mkdir();
				//File filePath = new File(directory.getAbsolutePath() + File.separator + fileName);
				
				//use this path for emulator testing
				File filePath = new File(getApplicationContext().getFilesDir(), fileName);
				
				imageUri = Uri.fromFile(filePath);
				FileOutputStream outputStream;
				
				//display gif in gallery app
				Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
				mediaScanIntent.setData(imageUri);
			    sendBroadcast(mediaScanIntent);

				try 
				{
					outputStream = new FileOutputStream(filePath);
					outputStream.write(bos.toByteArray());
					gifCount++;
					Toast.makeText(Main.this, "Saved as " + fileName, Toast.LENGTH_SHORT).show();
					save.setText("Save");
				} 
				catch (FileNotFoundException e) {
					Toast.makeText(Main.this, "Unable to find this gif.", Toast.LENGTH_SHORT).show();
					save.setText("Save");
					
				}
				catch (IOException e) {
					Toast.makeText(Main.this, "Unable to save this gif.", Toast.LENGTH_SHORT).show();
					save.setText("Save");
				}
				
				
			}
		});
		
		//upload button
		upload.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(isGifSaved || imageUri != null){
					ImgurUploader.getInstance().upload(imageUri,getApplicationContext());
					//Toast.makeText(Main.this, "Uploaded.", Toast.LENGTH_SHORT).show();
		    		try {
						startActivity(new Intent(Intent.ACTION_VIEW,
								Uri.parse("http://i.imgur.com/" + ImgurUploader.getImgurLink() + ".gif")));
						
						ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE); 
						clipboard.setText("http://i.imgur.com/" + ImgurUploader.getImgurLink() + ".gif");
						//clipboard.getText();
						Toast.makeText(Main.this, "Imgur link copied to clipboard.", Toast.LENGTH_SHORT).show();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else{
					Toast.makeText(Main.this, "Please save this gif before uploading it to imgur!", Toast.LENGTH_SHORT).show();
				}
//				Toast.makeText(Main.this, imageUri.getPath(), Toast.LENGTH_SHORT).show();
			}
		});
	}
	private boolean generateGif(ByteArrayOutputStream bos, EditText input){
		AnimatedGifEncoder encoder = new AnimatedGifEncoder();
		
		encoder.setDelay(500); 
		encoder.setRepeat(0); 
		encoder.start(bos);    
		
		String inputText = input.getText().toString().toLowerCase();

		int i = 0;
		
		//encode frames
		while(i < inputText.length())
		{
			char charPosition = inputText.charAt(i);
			
			if (!(i+1>=inputText.length()) && inputText.charAt(i) == inputText.charAt(i+1))
			{
				bit = gif.getFirstBit(bit, charPosition);
				encoder.addFrame(bit);
				bit.recycle();
					
				bit = gif.getSecondBit(bit, charPosition);
				encoder.addFrame(bit);
				bit.recycle();
				
				i+=2;
			} 
			
			else if(i < inputText.length())
			{
				bit = gif.getFirstBit(bit, charPosition);
				encoder.addFrame(bit);
				bit.recycle();
				i++;
			}
		}
		
		//add a blank frame
		bit = BitmapFactory.decodeResource(getResources(), R.drawable._);
		encoder.addFrame(bit); 
		bit.recycle();

		return encoder.finish();
	}
}

//Jonathan Schwadron
//Mobile Application Development
//Final Project Fall 2013