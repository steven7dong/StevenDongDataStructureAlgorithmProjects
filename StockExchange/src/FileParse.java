import java.util.function.Function;

public class FileParse {

    public FileParse(){ }

    public String[] getParsedString(Function<String, String[]> f, String str){
        return f.apply(str);
    }
}

