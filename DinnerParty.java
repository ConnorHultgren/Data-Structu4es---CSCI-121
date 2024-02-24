public class DinnerParty extends Party{
    private int dinnerChoice;
    public String food;

    public int getdinnerChoice() {return dinnerChoice;}

    public void setdinnerChoice(int dinnerChoice) {
        this.dinnerChoice = dinnerChoice;
        setFoodChoice();
    }

    private void setFoodChoice(){
        if (dinnerChoice ==1){
            food = "Barbeque";
        }
        if (dinnerChoice ==2){
            food = "Italian";
        }
        else{
            food = "Salmon";
        }
    }
}
