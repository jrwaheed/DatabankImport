import java.util.ArrayList;
import java.util.List;

public class FilmDetails {
    private List titles;
    private List genre;


    public FilmDetails(List titles, List genre) {
        this.titles = new ArrayList();
        this.genre = new ArrayList();
    }

    public List getTitles() {
        return titles;
    }

    public void setTitles(List titles) {
        this.titles = titles;
    }

    public List getGenre() {
        return genre;
    }

    public void setGenre(List genre) {
        this.genre = genre;
    }


}
