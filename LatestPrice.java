import java.io.*;

public class LatestPrice {

    public static void main(String[] args) {
        printCusipLatestPrice("/Users/cuteandsassy/Desktop/", "assignment1.txt");

    }
    /**
     * <h1>Print the lastest price for each CUSIP</h1>
     * <b>Note:</b> This function takes a file path and a file name
     * to read and print out the lastest price for each CUSIP code
     *
     * @author  Steven Dong
     * @version 1.0
     * @since   2019-02-17
     */
    public static void printCusipLatestPrice(String path, String fileName){
        String line;
        String prevCusip;
        String currentCusip = "";
        String lastPrice = "";
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new FileReader(path + fileName));
            while ((line = reader.readLine()) != null) {
                if (!isCusip(line.trim())){
                    lastPrice = line;
                    continue;
                }
                prevCusip = currentCusip;
                currentCusip = line;
                if (prevCusip.isEmpty()) continue;
                System.out.println("cusip " + prevCusip + " lastest price is: " + lastPrice);
            }
            if (lastPrice != null && currentCusip != "") {
                System.out.println("cusip " + currentCusip + " lastest price is: " + lastPrice);
            }
        }
        catch(FileNotFoundException fileException){
            //Handles FileNotFoundException if issues arise when opening file
            fileException.printStackTrace();
        }
        catch(IOException ioException){
            //Handles IOException if there is any issues when reading file
            ioException.printStackTrace();
        }
        finally{
            try {
                reader.close();
            } catch (NullPointerException nullException) {
                //Reader is null if file was never opened
                nullException.printStackTrace();
            } catch (IOException closingIoException) {
                //Handles IOException if there is any issues when closing the file
                closingIoException.printStackTrace();
            }
        }
    }
    /**
     * <h1>Check to whether an alphanumeric code is a CUSIP code</h1>
     * <b>Note:</b> Checking whether a string is CUSIP code, this is a
     * brief version based on the problem stated that CUSIP is an
     * alphanumeric string that cannot be converted to decimal number.
     * In real production code, checking for CUSIP should have it own
     * algorithm
     *
     * @author  Steven Dong
     * @version 1.0
     * @since   2019-02-17
     */
    private static boolean isCusip(String str){
        try{
            Double.parseDouble(str);
        }
        catch(NumberFormatException e){
            return true;
        }
        return false;
    }
/*
    //Precondition: an array of integer representating pip number
    //Postcondition: return the minimum number of moves to make all pip number equal, or -1 if mininum number of moves cannot be achieved.
    public int solution(int[] A) {
        //if A is empty them we cannot achieve making all pips the same number, return -1
        if (A.length == 0) {
            return -1;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 6);
        map.put(2, 5);
        map.put(3, 4);
        map.put(6, 1);
        map.put(5, 2);
        map.put(4, 3);
        Integer minTotalSteps = Integer.MAX_VALUE;
        for (int i = 1; i < 7; i++) {
            int steps = 0;
            for (int j = 0; j < A.length; j++) {
                int nextPossibleMove = calculateSteps(i, A[j], map);
                //If the return value is -1, it means A array contains illegal pip, return -1
                //to indicate minimum moves are not possible
                if (nextPossibleMove == -1) {
                    return -1;
                }
                steps += nextPossibleMove;
            }
            minTotalSteps = steps < minTotalSteps ? steps : minTotalSteps;
        }
        return minTotalSteps;
    }


    private int calculateSteps(int destination, int from, HashMap<Integer, Integer> map) {
        //function returns -1 if the pips given in int[] A has numbers not in 1-6 range, which
        //indicates move not possible.
        if (map.get(from) == null || map.get(destination) == null) {
            return -1;
        }
        if (destination == from) {
            return 0;
        }
        if (map.get(from) == destination) {
            return 2;
        }
        return 1;
    }
*/

}