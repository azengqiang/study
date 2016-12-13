import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReaderToString{

    public static  void  main(String arg[]) throws IOException {
        Reader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        char[] buff = new char[1024];
        int len =-1;
        StringBuffer sb = new StringBuffer();
        while((len= IOUtils.read(br, buff))!=-1 && len!=0){
            sb.append(buff,0,len);
        }
        IOUtils.closeQuietly(reader);
        System.out.println(sb.toString());

    }

}
