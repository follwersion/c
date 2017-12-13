package labExam1002;

import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

public class ZMS {
         
    Map<String, User> swut;
    
    public ZMS() {
        super();
        swut = new TreeMap<String, User>();
    }
    
    public void add(User user) {
        swut.put(user.account, user);
    }
    
    public void del(String account) {
        swut.remove(account);
    }
    
    public int nou() {
        return swut.size();        
    }

    public String toString() {
        return String.format("ZMS [swut=%s]", swut);
    }
    
    public void printAllUser() {
        for ( String a : swut.keySet() ) {
            System.out.println(swut.get(a));
        }
    }
    
    public void delPerson(int id) {
        for (int i = 0; i < swut.keySet().size(); i++) {
            if ( swut.get(swut.keySet().toArray()[i] ).person.id == id) {
                swut.remove(swut.keySet().toArray()[i]);
            }
        }
//        for ( String a : swut.keySet() ) {
//           if (swut.get(a).person.id == id) {
//               swut.remove(a);
//           }
//        }
    }
    
    public boolean checkPassword(String account, Password pw) {
        if (swut.get(account).pw.equals(pw)) {
            return true;
        }
        return false;        
    }
    
    public int nop() {        
        HashSet<Person> temp = new HashSet<Person>();
        for ( String a : swut.keySet() ) {
            temp.add(swut.get(a).person);
        }
        return temp.size();
    }
    
    
            
    public static void main (String[] args) {
        ZMS zms;
        User tmpu;
        zms = new ZMS();
        System.out.printf("Test1a\n======\n\n");
        Person klugeKarla = new Person("Kluge", "Karla", "Customer Care");
        Person marxMax = new Person("Marx", "Max", "Marketing");
        Person allmaAnton = new Person("Allmaechtig", "Anton", "EDV");
        zms.add(new Chef("kluge_k", new Password("xX_01_Xx"), klugeKarla));
        zms.add(new Entwickler("eilig_e", new Password("xX_02_Xx"), new Person(
                "Eilig", "Egon", "R&D")));
        zms.add(new Admin("allma_aa", new Password("xX_03_Xx"), allmaAnton));
        zms.add(new Chef("allma_ac", new Password("xX_04_Xx"), allmaAnton));
        zms.add(new Gast("allma_ag", new Password("xX_05_Xx"), allmaAnton));
        zms.add(new NurNutzer("hase_h", new Password("xX_06_Xx"), new Person(
                "Hase", "Heike", "HR")));
        zms.add(new Entwickler("xanadu_x", new Password("xX_07_Xx"),
                new Person("Xanadu", "Xaver", "R&D")));
        zms.add(new NurNutzer("gjoen_g", new Password("xX_08_Xx"), new Person(
                "Gjoen", "Gustav", "HR")));
        zms.add(new NurNutzer("defoy_d", new Password("xX_09_Xx"), new Person(
                "Defoy", "Doris", "HR")));
        zms.add(new NurNutzer("marx_m", new Password("xX_10_Xx"), marxMax));
        zms.add(new Entwickler("torfs_t", new Password("xX_11_Xx"), new Person(
                "Torfs", "Till", "R&D")));
        zms.add(new Admin("wolf_w", new Password("xX_12_Xx"), new Person(
                "Wolf", "Wilma", "EDV")));
        zms.add(new NurNutzer("feuers_f", new Password("xX_13_Xx"), new Person(
                "Feuerstein", "Fred", "Marketing")));
        zms.add(new Admin("duck_d", new Password("xX_14_Xx"), new Person(
                "Duck", "Donald", "EDV")));
        zms.add(new Chef("flof_f", new Password("xX_15_Xx"), new Person("Floh",
                "Fritz", "Marketing")));
        zms.add(new NurNutzer("chok_c", new Password("xX_16_Xx"), new Person(
                "Chok", "Charlie", "Marketing")));
        
        System.out.println("****************************");
        zms.printAllUser();
        System.out.println("****************************");
        zms.delPerson(1);
        zms.printAllUser();
        System.out.println("****************************");
        System.out.println(zms.checkPassword("chok_c", new Password ("xX_16_Xx")));
        
    }
    
    
    
    
    
}