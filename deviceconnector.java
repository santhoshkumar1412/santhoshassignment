package santhosh;

public class deviceconnector {
    public void connectDevice(String deviceName) {
        System.out.println("Connecting to device using name: " + deviceName);
    }

    public void connectDevice(int ipPart1, int ipPart2, int ipPart3, int ipPart4) {
        String ip = ipPart1 + "." + ipPart2 + "." + ipPart3 + "." + ipPart4;
        System.out.println("Connecting to device using IP address: " + ip);
    }
}




