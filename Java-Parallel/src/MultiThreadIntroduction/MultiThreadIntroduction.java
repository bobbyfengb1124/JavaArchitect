package MultiThreadIntroduction;

public class MultiThreadIntroduction {
    public static void main(String[] args) {
        Thread scannerThread1 = new Thread(() -> {
            String scannerIP = "192.168.1.2";

            VehicleScanner vs = connectScanner(scannerIP);
            vs.sendCommand("RealTimeData");

            while (true) {
                ScannerData scannerData = vs.readData();
                processDataAndTakeAction(scannerData);
            }


        });

        Thread scannerThread2 = new Thread(() -> {
            String scannerIP = "192.168.1.3";

            VehicleScanner vs = connectScanner(scannerIP);
            vs.sendCommand("RealTimeData");

            while (true) {
                ScannerData scannerData = vs.readData();
                processDataAndTakeAction(scannerData);
            }
        });

        Thread scannerThread3 = new Thread(() -> {
            String scannerIP = "192.168.1.4";

            VehicleScanner vs = connectScanner(scannerIP);
            vs.sendCommand("RealTimeData");

            while (true) {
                ScannerData scannerData = vs.readData();
                processDataAndTakeAction(scannerData);
            }
        });

        scannerThread1.start();
        scannerThread2.start();
        scannerThread3.start();
    }

    private static void processDataAndTakeAction(ScannerData scannerData) {

    }

    private static VehicleScanner connectScanner(String scannerIP) {
        return new VehicleScanner(scannerIP);
    }
}
