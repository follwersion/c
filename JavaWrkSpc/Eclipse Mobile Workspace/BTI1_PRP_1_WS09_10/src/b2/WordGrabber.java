package b2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class WordGrabber {
    
    // declarations----------------------------------------------

    private BufferedReader br;
    private String line;
    private Matcher matcher;
    private Pattern pattern;
    
    
    
    // constructors----------------------------------------------

    WordGrabber( String fn ) throws FileNotFoundException, IOException {
        this.pattern = Pattern.compile( "\\w+" );
        this.br = new BufferedReader ( new FileReader ( fn ) );
        this.line = this.br.readLine();
        this.matcher = this.pattern.matcher( this.line );
    }//WordGrabber
    
    WordGrabber() throws FileNotFoundException, IOException {
        this( "input.txt" );
    }//WordGrabber


    
    // methods---------------------------------------------------

    boolean hasNext() throws FileNotFoundException, IOException {
        boolean found;
        found = this.matcher.find();
        while ( (!found) && (this.line!=null) ){
            this.line = this.br.readLine();
            if (this.line!=null ){
                this.matcher = this.pattern.matcher( this.line );
                found = this.matcher.find();
            }else{
                found = false;
            }//if
        }//while
        return found;
    }//hasNext
   
    String getNext(){
        return matcher.group();
    }//getNext
    
}//WordGrabber
