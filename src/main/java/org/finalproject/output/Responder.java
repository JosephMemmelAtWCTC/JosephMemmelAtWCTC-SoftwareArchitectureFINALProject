package org.finalproject.output;

public interface Responder {

//	static Responder singletonInstance = null;

	public void actionRespond(String message);

	public void helpUserMessage(String message);//In case other displays are to respond in different ways

	public void simpleOutput(String message);
}
