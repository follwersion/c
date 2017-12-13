package b1;

public enum Inhalt
{
    Audio, Video, Movie;
    public String toString()
    {
        String resu;

        switch (this)
        {
        case Audio:
            resu = "Audio";
            break;
        case Video:
            resu = "Video";
            break;
        case Movie:
            resu = "Movie";
            break;
        default:
            resu = "";
        }

        return resu;
    }
}
