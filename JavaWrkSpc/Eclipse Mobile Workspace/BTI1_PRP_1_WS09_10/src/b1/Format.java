package b1;

public enum Format
{
    PAL, NTSC;
    public String toString()
    {
        String resu;

        switch (this)
        {
        case PAL:
            resu = "PAL";
            break;
        case NTSC:
            resu = "NTSC";
            break;
        default:
            resu = "";
        }

        return resu;
    }
}
