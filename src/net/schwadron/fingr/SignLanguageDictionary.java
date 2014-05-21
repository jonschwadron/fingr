package net.schwadron.fingr;

import android.graphics.drawable.AnimationDrawable;

public class SignLanguageDictionary {
	
	private Main context;
	
	public SignLanguageDictionary(Main main) {
		context = main;
	}

	//First
	public AnimationDrawable getFirstBit(AnimationDrawable animate, char charPosition) {
		switch (charPosition)
		{
		case 'a' : animate.addFrame(context.getResources().getDrawable(R.drawable.a), 800);
			break;
			
		case 'b' : animate.addFrame(context.getResources().getDrawable(R.drawable.b), 800);
			break;
			
		case 'c' : animate.addFrame(context.getResources().getDrawable(R.drawable.c), 800);
			break;
			
		case 'd' : animate.addFrame(context.getResources().getDrawable(R.drawable.d), 800);
			break;
			
		case 'e' : animate.addFrame(context.getResources().getDrawable(R.drawable.e), 800);
			break;
			
		case 'f' : animate.addFrame(context.getResources().getDrawable(R.drawable.f), 800);
			break;
			
		case 'g' : animate.addFrame(context.getResources().getDrawable(R.drawable.g), 800);
			break;
			
		case 'h' : animate.addFrame(context.getResources().getDrawable(R.drawable.h), 800);
			break;
			
		case 'i' : animate.addFrame(context.getResources().getDrawable(R.drawable.i), 800);
			break;
			
		case 'j' : animate.addFrame(context.getResources().getDrawable(R.drawable.j), 800);
			break;
			
		case 'k' : animate.addFrame(context.getResources().getDrawable(R.drawable.k), 800);
			break;
			
		case 'l' : animate.addFrame(context.getResources().getDrawable(R.drawable.l), 800);
			break;
			
		case 'm' : animate.addFrame(context.getResources().getDrawable(R.drawable.m), 800);
			break;
			
		case 'n' : animate.addFrame(context.getResources().getDrawable(R.drawable.n), 800);
			break;
			
		case 'o' : animate.addFrame(context.getResources().getDrawable(R.drawable.o), 800);
			break;
			
		case 'p' : animate.addFrame(context.getResources().getDrawable(R.drawable.p), 800);
			break;
			
		case 'q' : animate.addFrame(context.getResources().getDrawable(R.drawable.q), 800);
			break;
			
		case 'r' : animate.addFrame(context.getResources().getDrawable(R.drawable.r), 800);
			break;
			
		case 's' : animate.addFrame(context.getResources().getDrawable(R.drawable.s), 800);
			break;
			
		case 't' : animate.addFrame(context.getResources().getDrawable(R.drawable.t), 800);
			break;
			
		case 'u' : animate.addFrame(context.getResources().getDrawable(R.drawable.u), 800);
			break;
			
		case 'v' : animate.addFrame(context.getResources().getDrawable(R.drawable.v), 800);
			break;
			
		case 'w' : animate.addFrame(context.getResources().getDrawable(R.drawable.w), 800);
			break;
			
		case 'x' : animate.addFrame(context.getResources().getDrawable(R.drawable.x), 800);
			break;
			
		case 'y' : animate.addFrame(context.getResources().getDrawable(R.drawable.y), 800);
			break;
			
		case 'z' : animate.addFrame(context.getResources().getDrawable(R.drawable.z), 800);
			break;
			
		case ' ' : animate.addFrame(context.getResources().getDrawable(R.drawable._), 200);
			break;
			
		default: 
			break;	
		}
		return animate;
		
	}
	
	//Second
	public AnimationDrawable getSecondBit(AnimationDrawable animate, char charPosition) {
		
		switch (charPosition)
		{
		case 'a' : animate.addFrame(context.getResources().getDrawable(R.drawable._a), 800);
			break;
			
		case 'b' : animate.addFrame(context.getResources().getDrawable(R.drawable._b), 800);
			break;
			
		case 'c' : animate.addFrame(context.getResources().getDrawable(R.drawable._c), 800);
			break;
			
		case 'd' : animate.addFrame(context.getResources().getDrawable(R.drawable._d), 800);
			break;
			
		case 'e' : animate.addFrame(context.getResources().getDrawable(R.drawable._e), 800);
			break;
			
		case 'f' : animate.addFrame(context.getResources().getDrawable(R.drawable._f), 800);
			break;
			
		case 'g' : animate.addFrame(context.getResources().getDrawable(R.drawable._g), 800);
			break;
			
		case 'h' : animate.addFrame(context.getResources().getDrawable(R.drawable._h), 800);
			break;
			
		case 'i' : animate.addFrame(context.getResources().getDrawable(R.drawable._i), 800);
			break;
			
		case 'j' : animate.addFrame(context.getResources().getDrawable(R.drawable._j), 800);
			break;
			
		case 'k' : animate.addFrame(context.getResources().getDrawable(R.drawable._k), 800);
			break;
			
		case 'l' : animate.addFrame(context.getResources().getDrawable(R.drawable._l), 800);
			break;
			
		case 'm' : animate.addFrame(context.getResources().getDrawable(R.drawable._m), 800);
			break;
			
		case 'n' : animate.addFrame(context.getResources().getDrawable(R.drawable._n), 800);
			break;
			
		case 'o' : animate.addFrame(context.getResources().getDrawable(R.drawable._o), 800);
			break;
			
		case 'p' : animate.addFrame(context.getResources().getDrawable(R.drawable._p), 800);
			break;
			
		case 'q' : animate.addFrame(context.getResources().getDrawable(R.drawable._q), 800);
			break;
			
		case 'r' : animate.addFrame(context.getResources().getDrawable(R.drawable._r), 800);
			break;
			
		case 's' : animate.addFrame(context.getResources().getDrawable(R.drawable._s), 800);
			break;
			
		case 't' : animate.addFrame(context.getResources().getDrawable(R.drawable._t), 800);
			break;
			
		case 'u' : animate.addFrame(context.getResources().getDrawable(R.drawable._u), 800);
			break;
			
		case 'v' : animate.addFrame(context.getResources().getDrawable(R.drawable._v), 800);
			break;
			
		case 'w' : animate.addFrame(context.getResources().getDrawable(R.drawable._w), 800);
			break;
			
		case 'x' : animate.addFrame(context.getResources().getDrawable(R.drawable._x), 800);
			break;
			
		case 'y' : animate.addFrame(context.getResources().getDrawable(R.drawable._y), 800);
			break;
			
		case 'z' : animate.addFrame(context.getResources().getDrawable(R.drawable._z), 800);
			break;
			
		default: 
			break;	
		}
		return animate;
	}
}

//Jonathan Schwadron
//Mobile Application Development
//Final Project Fall 2013