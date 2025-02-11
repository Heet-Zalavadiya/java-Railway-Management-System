import java.util.Scanner;

class Train {
    String[] Stations;
    int[] kms;
    int Train_No;
    String Trian_Name;
    int S1 = 72, S2 = 72, B1 = 72, A1 = 48, H1 = 24;

    public Train(String Trian_Name, int Train_No, String[] Stations, int[] kms) {
        this.Trian_Name = Trian_Name;
        this.Train_No = Train_No;
        this.Stations = Stations;
        this.kms = kms;
    }

}

public class RMS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Train[] t = new Train[3];

        String[] Stations1 = { "RJT", "BKNG", "GDL", "VRR", "NUD", "JLR", "JND", "KSD", "MLHA", "VRL" };
        int[] kms1 = { 0, 6, 41, 58, 71, 77, 103, 138, 154, 185 };
        t[0] = new Train("SAURASHTRA JANTA", 19217, Stations1, kms1);

        String[] Stations2 = { "PBR", "RJT", "ADI", "BRC", "BH", "ST", "BL", "VAPI" };
        int[] kms2 = { 0, 216, 463, 563, 633, 692, 760, 784 };
        t[1] = new Train("SAURASHTRA EXP", 19016, Stations2, kms2);

        String[] Stations3 = { "JAM", "ADI", "ST", "BSR", "PNVL", "MAO", "MAJN", "SRR", "TEN" };
        int[] kms3 = { 0, 332, 560, 775, 842, 1539, 1970, 2282, 2738 };
        t[2] = new Train("JAM TEN EXP", 19578, Stations3, kms3);

        System.out.println("Enter Starting point: ");
        String from_Station = sc.nextLine();

        System.out.println("Enter Destination: ");
        String To_Station = sc.nextLine();

        System.out.println("No. of passengers:");
        int passenger_count = sc.nextInt();

        boolean is_TrainFound = false;
        for (int i = 0; i < t.length; i++) {

            int start_index = -1;
            int end_index = -1;

            for (int j = 0; j < t[i].Stations.length; j++) {
                if (start_index == -1 && t[i].Stations[j].equals(from_Station)) {
                    start_index = j;
                }

                if (start_index != -1 && t[i].Stations[j].equals(To_Station)) {
                    end_index = j;
                }
            }
            if (start_index >= 0 && end_index >= 0 && (passenger_count < t[i].S1 || passenger_count < t[i].S2
                    || passenger_count < t[i].A1 || passenger_count < t[i].B1 || passenger_count < t[i].H1)) {
                is_TrainFound = true;

            }
            if (is_TrainFound == true) {
                System.out.println("Train Found " + t[i].Train_No + "-" + t[i].Trian_Name);
                break;
            }
        }
        if (!is_TrainFound) {
            System.out.println("Train not Found or insufficent seates.");
        }
    }
}