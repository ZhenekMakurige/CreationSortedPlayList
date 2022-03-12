import java.util.Arrays;

public class CreationSortedPlayList {

    public static int NumTracks = 0;
    public static int NumTacts = 0;
    public static int NumSemples = 0;

    public static int[][] PlayListEM;
    public static int[][] PlayListOlesya;

    public static void main(String[] args) {
        Entrance enterInt = new Entrance();

        NumTracks = enterInt.SetIntegerValue("Tracks");
        if (NumTracks < 1){
            System.out.println("The numbers of trucks is less 1. Try again...");
            return;
        }

        NumTacts = enterInt.SetIntegerValue("Tacts");
        if (0 > NumTacts || NumTacts > Math.pow(10, 9)){
            System.out.println("The numbers of trucks is less 0 or much 10~9. Try again...");
            return;
        }

        NumSemples = enterInt.SetIntegerValue("Semples");
        if (1 > NumSemples || NumSemples > 200000){
            System.out.println("The numbers of trucks is less 0 or much 10~9. Try again...");
            return;
        }

        PlayListEM = new int[NumTracks][NumTacts];
        PlayListOlesya = new int[NumSemples][NumTacts];

        GetRND getRnd = new GetRND();

        for (int i = 0; i < NumSemples; i++){
            int NewRND = getRnd.GetRandom(NumTacts);
            for (int j = 0; j < NewRND; j++) {
                PlayListOlesya[i][j] = NewRND;
            }
        }

        for (int i = 0; i < NumSemples; i++){
            int tmpLength = PlayListOlesya[i][0];
            int[] tmpArr = Arrays.copyOf(PlayListOlesya[i], tmpLength);
            int NumFree = 0;
            boolean SemplIsPasted = false;

            for (int j = 0; j < NumTracks; j++){
                int k = 0;
                for (k = 0; k < NumTacts; k++){
                    if (PlayListEM[j][k] == 0){
                        NumFree = NumTacts - k;
                        break;
                    }
                }
                if (tmpLength <= NumFree){
                    System.arraycopy(tmpArr, 0, PlayListEM[j], k, tmpLength);
                    System.out.println("Sempl " + (i + 1) + " (length = " + tmpLength + ") : " + (j + 1) + "");
                    SemplIsPasted = true;
                    break;
                }
            }
            if (!SemplIsPasted){
                System.out.println("Sempl " + (i + 1) + " (length = " + tmpLength + ") : -1");
            }
        }
    }
}
