package net.schwadron.fingr;

import android.graphics.BitmapFactory;
import android.graphics.Bitmap;

public class GifGenerator {
	
	private Main context;
	
	public GifGenerator(Main main) {
		context = main;
	}
	
	//First
	public Bitmap getFirstBit(Bitmap bit, char charPosition)
	{
		switch (charPosition)
		{
		case 'a' : bit = BitmapFactory.decodeResource(context.getResources(), R.drawable.a);
			break;
			
		case 'b' : bit = BitmapFactory.decodeResource(context.getResources(), R.drawable.b);
			break;
			
		case 'c' : bit = BitmapFactory.decodeResource(context.getResources(), R.drawable.c);
			break;
			
		case 'd' : bit = BitmapFactory.decodeResource(context.getResources(), R.drawable.d);
			break;
			
		case 'e' : bit = BitmapFactory.decodeResource(context.getResources(), R.drawable.e);
			break;
			
		case 'f' : bit = BitmapFactory.decodeResource(context.getResources(), R.drawable.f);
			break;
			
		case 'g' : bit = BitmapFactory.decodeResource(context.getResources(), R.drawable.g);
			break;
			
		case 'h' : bit = BitmapFactory.decodeResource(context.getResources(), R.drawable.h);
			break;
			
		case 'i' : bit = BitmapFactory.decodeResource(context.getResources(), R.drawable.i);
			break;
			
		case 'j' : bit = BitmapFactory.decodeResource(context.getResources(), R.drawable.j);
			break;
			
		case 'k' : bit = BitmapFactory.decodeResource(context.getResources(), R.drawable.k);
			break;
			
		case 'l' : bit = BitmapFactory.decodeResource(context.getResources(), R.drawable.l);
			break;
			
		case 'm' : bit = BitmapFactory.decodeResource(context.getResources(), R.drawable.m);
			break;
			
		case 'n' : bit = BitmapFactory.decodeResource(context.getResources(), R.drawable.n);
			break;
			
		case 'o' : bit = BitmapFactory.decodeResource(context.getResources(), R.drawable.o);
			break;
			
		case 'p' : bit = BitmapFactory.decodeResource(context.getResources(), R.drawable.p);
			break;
			
		case 'q' : bit = BitmapFactory.decodeResource(context.getResources(), R.drawable.q);
			break;
			
		case 'r' : bit = BitmapFactory.decodeResource(context.getResources(), R.drawable.r);
			break;
			
		case 's' : bit = BitmapFactory.decodeResource(context.getResources(), R.drawable.s);
			break;
			
		case 't' : bit = BitmapFactory.decodeResource(context.getResources(), R.drawable.t);
			break;
			
		case 'u' : bit = BitmapFactory.decodeResource(context.getResources(), R.drawable.u);
			break;
			
		case 'v' : bit = BitmapFactory.decodeResource(context.getResources(), R.drawable.v);
			break;
			
		case 'w' : bit = BitmapFactory.decodeResource(context.getResources(), R.drawable.w);
			break;
			
		case 'x' : bit = BitmapFactory.decodeResource(context.getResources(), R.drawable.x);
			break;
			
		case 'y' : bit = BitmapFactory.decodeResource(context.getResources(), R.drawable.y);
			break;
			
		case 'z' : bit = BitmapFactory.decodeResource(context.getResources(), R.drawable.z);
			break;
			
		case ' ' : bit = BitmapFactory.decodeResource(context.getResources(), R.drawable._);
			break;
			
		default: 
			break;	
		}
		return bit;
	}
	
	//Second
	public Bitmap getSecondBit(Bitmap _bit, char charPosition)
	{
		switch (charPosition)
		{
		case 'a' : _bit = BitmapFactory.decodeResource(context.getResources(), R.drawable._a);
			break;
			
		case 'b' : _bit = BitmapFactory.decodeResource(context.getResources(), R.drawable._b);
			break;
			
		case 'c' : _bit = BitmapFactory.decodeResource(context.getResources(), R.drawable._c);
			break;
			
		case 'd' : _bit = BitmapFactory.decodeResource(context.getResources(), R.drawable._d);
			break;
			
		case 'e' : _bit = BitmapFactory.decodeResource(context.getResources(), R.drawable._e);
			break;
			
		case 'f' : _bit = BitmapFactory.decodeResource(context.getResources(), R.drawable._f);
			break;
			
		case 'g' : _bit = BitmapFactory.decodeResource(context.getResources(), R.drawable._g);
			break;
			
		case 'h' : _bit = BitmapFactory.decodeResource(context.getResources(), R.drawable._h);
			break;
			
		case 'i' : _bit = BitmapFactory.decodeResource(context.getResources(), R.drawable._i);
			break;
			
		case 'j' : _bit = BitmapFactory.decodeResource(context.getResources(), R.drawable._j);
			break;
			
		case 'k' : _bit = BitmapFactory.decodeResource(context.getResources(), R.drawable._k);
			break;
			
		case 'l' : _bit = BitmapFactory.decodeResource(context.getResources(), R.drawable._l);
			break;
			
		case 'm' : _bit = BitmapFactory.decodeResource(context.getResources(), R.drawable._m);
			break;
			
		case 'n' : _bit = BitmapFactory.decodeResource(context.getResources(), R.drawable._n);
			break;
			
		case 'o' : _bit = BitmapFactory.decodeResource(context.getResources(), R.drawable._o);
			break;
			
		case 'p' : _bit = BitmapFactory.decodeResource(context.getResources(), R.drawable._p);
			break;
			
		case 'q' : _bit = BitmapFactory.decodeResource(context.getResources(), R.drawable._q);
			break;
			
		case 'r' : _bit = BitmapFactory.decodeResource(context.getResources(), R.drawable._r);
			break;
			
		case 's' : _bit = BitmapFactory.decodeResource(context.getResources(), R.drawable._s);
			break;
			
		case 't' : _bit = BitmapFactory.decodeResource(context.getResources(), R.drawable._t);
			break;
			
		case 'u' : _bit = BitmapFactory.decodeResource(context.getResources(), R.drawable._u);
			break;
			
		case 'v' : _bit = BitmapFactory.decodeResource(context.getResources(), R.drawable._v);
			break;
			
		case 'w' : _bit = BitmapFactory.decodeResource(context.getResources(), R.drawable._w);
			break;
			
		case 'x' : _bit = BitmapFactory.decodeResource(context.getResources(), R.drawable._x);
			break;
			
		case 'y' : _bit = BitmapFactory.decodeResource(context.getResources(), R.drawable._y);
			break;
			
		case 'z' : _bit = BitmapFactory.decodeResource(context.getResources(), R.drawable._z);
			break;
			
		default: 
			break;	
		}
		return _bit;
	}

}

//Jonathan Schwadron
//Mobile Application Development
//Final Project Fall 2013