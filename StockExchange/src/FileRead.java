import java.io.*;
import java.util.function.Function;

public class FileRead {

    private BufferedReader fileReader = null;

    public FileRead(String filePath, String fileName){
        try{
            fileReader = new BufferedReader(new FileReader(filePath + fileName));
        }
        catch(FileNotFoundException fileException){
            fileException.printStackTrace();
        }
    }

    public String processFile(Function<BufferedReader, String> f){
        return f.apply(fileReader);
    }

    public void closeFile(){
        try{
            fileReader.close();
        }
        catch (NullPointerException nullException) {
            //Reader is null if file was never opened
            nullException.printStackTrace();
        } catch (IOException closingIoException) {
            //Handles IOException if there is any issues when closing the file
            closingIoException.printStackTrace();
        }
    }
}
