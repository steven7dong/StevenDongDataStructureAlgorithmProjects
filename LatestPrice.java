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
}