import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class RepurchaseModule {
    private FileRead file_read;
    private FileParse file_parse;
    private ArrayList<FinancialEntity> allEntities;

    public RepurchaseModule(){
        allEntities = new ArrayList<>();
    }

    private String readLine(){
        return file_read.processFile((BufferedReader br) ->{
            try{
                return br.readLine();
            }
            catch(IOException ioe){
                throw new RuntimeException(ioe);
            }
        });
    }

    public void getAllEntitiesFromFile(String filePath, String fileName){
        file_read = new FileRead(filePath, fileName);
        file_parse = new FileParse();
        String[] parsedLine;
        String line;
        line = readLine();
        while (line != null){
            parsedLine = file_parse.getParsedString((String s) -> s.split("\\s+"), line);
            allEntities.add(toEntity(parsedLine));
            line = readLine();
        }
        file_read.closeFile();
    }

    public void test(){
        Map<String, List<FinancialEntity>> map = new HashMap<>();
        map = allEntities.stream().collect(Collectors.groupingBy(FinancialEntity::getType));

    }
    private FinancialEntity toEntity(String[] parsedString){
        return new FinancialEntity(parsedString[0], parsedString[1], parsedString[2]);
    }

    public void display(){
        for (FinancialEntity fe: allEntities){
            System.out.println(fe);
        }
    }
}


