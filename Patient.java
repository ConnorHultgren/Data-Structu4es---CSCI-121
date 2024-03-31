public class Patient {
    private int ID;
    private int age;
    private BloodData blood;

    public Patient(){
        this.ID = 0;
        this.age = 0;
        this.blood = new BloodData();
    }

    public Patient(int ID,int age, BloodData blood){
        this.ID = ID;
        this.age = age;
        this.blood = blood;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public BloodData getBlood() {
        return blood;
    }

    public void setBlood(BloodData blood) {
        this.blood = blood;
    }
}
