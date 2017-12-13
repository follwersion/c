package b1;

public class DVD extends Disc
{
    private Format format;

    DVD(String title, Inhalt inhalt, Format format) {
        super(title, inhalt);
        this.format=format;
    }

    Format getFormat() {
        return format;
    }

    public String toString() {
        return (super.toString() + ", Format: " + format+ "]");
    }
}
