package com;

import com.badlogic.gdx.backends.jogl.JoglApplication;

public class Desktop {
	public static void main (String[] args) {
        new JoglApplication(new Cenital(), "Cenital", 480, 320, false);
	}
}
