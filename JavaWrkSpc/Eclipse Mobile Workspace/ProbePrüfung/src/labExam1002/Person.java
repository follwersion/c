package labExam1002;

public class Person {
    
    String sname;
    String fname;
    String dep;
    int id;
    static int usrCounter = 1;
    
    public Person(String sname, String fname, String dep) {
        super();
        this.sname = sname;
        this.fname = fname;
        this.dep = dep;
        this.id = usrCounter;
        usrCounter++;
    }

    public String toString() {
        return String.format("Person [dep=%s, fname=%s, id=%s, sname=%s]", dep,
                fname, id, sname);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dep == null) ? 0 : dep.hashCode());
        result = prime * result + ((fname == null) ? 0 : fname.hashCode());
        result = prime * result + id;
        result = prime * result + ((sname == null) ? 0 : sname.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (dep == null) {
            if (other.dep != null)
                return false;
        } else if (!dep.equals(other.dep))
            return false;
        if (fname == null) {
            if (other.fname != null)
                return false;
        } else if (!fname.equals(other.fname))
            return false;
        if (id != other.id)
            return false;
        if (sname == null) {
            if (other.sname != null)
                return false;
        } else if (!sname.equals(other.sname))
            return false;
        return true;
    }
    
    
}
