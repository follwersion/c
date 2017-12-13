package ti1prp_.aufgabe06;

public class D3 implements Template {

    String cla = "D3";
    Template metho;
    public D3(Template metho){ this.metho = metho; }
    public String tu () {return metho.tu();        }
    public String id () {return (cla);       }
    public String xx () {return ("# "+cla+":" + metho.xx()+ metho.xx() + metho.xx()+" #");    }
    
}//templat
