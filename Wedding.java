import java.time.LocalDate;

public class Wedding  extends Couple{
    private String location;
    private LocalDate date;
    private Couple couple;

    public Wedding (String location, LocalDate date, Couple couple){
        super(couple.getP1(), couple.getP2());
        this.location = location;
        this.date = date;
    }
    public Couple getCouple(){return couple;}
    public String getLocation(){return location;}
    
    public LocalDate getDate(){return date;}
}
