package santhosh;

public class Main {
	    public static void main(String[] args) {
	        deviceconnector connector = new deviceconnector();
	        connector.connectDevice("Printer-01");
	        connector.connectDevice(192, 168, 1, 10);
	    }
	}

