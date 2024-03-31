public class BloodData {
    enum BloodGroup {
        A, B, AB, O
    }
    enum Rh{
        POSITIVE,NEGATIVE
    }

    private BloodGroup bloodLetter;
    private Rh posNeg;

    public BloodData(){
        this.bloodLetter = BloodGroup.O;
        this.posNeg = Rh.POSITIVE;
    }

    public BloodData(BloodGroup bloodLetter, Rh posNeg){
        this.bloodLetter = bloodLetter;
        this.posNeg = posNeg;
    }

    public BloodGroup getBloodLetter() {
        return bloodLetter;
    }

    public void setBloodLetter(BloodGroup bloodLetter) {
        this.bloodLetter = bloodLetter;
    }

    public Rh getPosNeg() {
        return posNeg;
    }

    public void setPosNeg(Rh posNeg) {
        this.posNeg = posNeg;
    }
}