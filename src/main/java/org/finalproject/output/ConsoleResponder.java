package org.finalproject.output;

public class ConsoleResponder implements Responder{
	static ConsoleResponder singletonInstance = null;


	public ConsoleResponder(){

	}

	@Override
	public void actionRespond(String message){
		System.out.println(message);
	}

	@Override
	public void helpUserMessage(String message) {
		System.out.println("\n ~~~ Help page ~~~\n\n"
				+message
		);
	}

	@Override
	public void simpleOutput(String message) {
		System.out.println(message);
	}

	//	@Override
	public static Responder getInstance() {
		if (singletonInstance == null)
			singletonInstance = new ConsoleResponder();
		return singletonInstance;
	}

}
