package com.gmail.erezmta.euler.utils;

import java.io.Closeable;
import java.io.IOException;

public class IOUtils {

	public static void closeSilently(Closeable closable) {
		if(closable != null) {
			try {
				closable.close();
			} catch (IOException e) {
				//Ignore
			}
		}
	}

}
