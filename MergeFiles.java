import java.io.*;
import java.util.Comparator;

/**
 * <h1>Implementation of String Comparator</h1>
 * <b>Note:</b> User defines a comparison rule by implements the Comparator
 * interface and overrides the compare function.
 *
 * @author  Steven Dong
 * @version 1.0
 * @since   2019-02-17
 */
class StringComparator implements Comparator<String>{
    @Override
    public int compare(String s1, String s2) {
        StringBuilder sb = new StringBuilder(s1);
        for (int i = 0; i < s2.length(); i++){
            sb.append(s2.charAt(i));
        }
        StringBuilder sb1 = new StringBuilder(s2);
        for(int j = 0; j < s1.length(); j++){
            sb1.append(s1.charAt(j));
        }
        return sb.compareTo(sb1);
    }
}
/**
 * <h1>Merge two sorted file to a new file, preserving sort order</h1>
 * <b>Note:</b> Merging two sorted file by comparing each line and write
 * to a new file. Users defines comparison rule and pass in a Comparator
 *
 * @author  Steven Dong
 * @version 1.0
 * @since   2019-02-17
 */
public class MergeFiles {
    public static void main(String[] args){
        mergeFiles("/Users/cuteandsassy/Desktop/",
                "/Users/cuteandsassy/Desktop/",
                "/Users/cuteandsassy/Desktop/",
                "file1.txt",
                "file2.txt",
                "merged_file.txt",
                new StringComparator());
    }

    public static void mergeFiles(String path1
                                , String path2
                                , String toFilePath
                                , String fileName1
                                , String fileName2
                                , String toFile
                                , Comparator<String> comp) {
        BufferedReader fileOneReader = null;
        BufferedReader fileTwoReader = null;
        BufferedWriter writer = null;
        String fileOneLine;
        String fileTwoLine;
        try {
            fileOneReader = new BufferedReader(new FileReader(path1 + fileName1));
            fileTwoReader = new BufferedReader(new FileReader(path2 + fileName2));
            writer = new BufferedWriter(new FileWriter(toFilePath + toFile, true));
            fileOneLine = fileOneReader.readLine();
            fileTwoLine = fileTwoReader.readLine();
            while (fileOneLine != null || fileTwoLine != null){
                if (fileOneLine != null && fileTwoLine != null){
                    if (comp.compare(fileOneLine, fileTwoLine) < 0){
                        appendLine(writer, fileOneLine);
                        fileOneLine = fileOneReader.readLine();
                    }
                    else{
                        appendLine(writer, fileTwoLine);
                        fileTwoLine = fileTwoReader.readLine();
                    }
                }
                else{
                    appendFile(fileOneLine, fileOneReader, writer);
                    appendFile(fileTwoLine, fileTwoReader, writer);
                    break;
                }
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
        finally {
            try {
                fileOneReader.close();
                fileTwoReader.close();
                writer.close();
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
     * <h1>Append a file to the merged file</h1>
     * <b>Note:</b> When there is nothing to read from one of the files,
     * this function is invoked to append the rest of the other file to
     * the merged file
     *
     * @author  Steven Dong
     * @version 1.0
     * @since   2019-02-17
     */
    private static void appendFile(String fileLine, BufferedReader fileReader, BufferedWriter writer) throws IOException{
        if (fileLine == null) return;
        appendLine(writer, fileLine);
        while ((fileLine = fileReader.readLine()) != null){
            appendLine(writer, fileLine);
        }
    }
    /**
     * <h1>Append a line to the merged file</h1>
     * <b>Note:</b> Append a line to the merged file and add a new line
     * character at the end
     *
     * @author  Steven Dong
     * @version 1.0
     * @since   2019-02-17
     */
    private static void appendLine(BufferedWriter writer, String fileLine) throws IOException{
        writer.write(fileLine, 0, fileLine.length());
        writer.newLine();
        writer.flush();
    }
}
