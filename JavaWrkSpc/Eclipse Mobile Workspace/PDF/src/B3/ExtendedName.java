package nachname_vorname.part3;

import _untouchable_.Name;

public class ExtendedName extends Name {
    private String titel;

    public ExtendedName(String fname, String sname, String titel) {
        super(fname, sname);
        this.titel = titel;
    }

    public String toString() {
        return super.toString() + String.format("titel= %s", titel);
    }
}
