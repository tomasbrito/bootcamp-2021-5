package junit.sespinoza;

public class KataCinco {
    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        // Your code goes here. Have fun!
        String winner = "";
        while (fighter1.health > 0 && fighter2.health >0){
            if(firstAttacker == fighter1.name){
                fighter2.health -= fighter1.damagePerAttack;
                if(fighter2.health <= 0){
                    winner = fighter1.name;
                    break;
                }
                fighter1.health -= fighter2.damagePerAttack;
                if(fighter1.health <= 0){
                    winner = fighter2.name;
                }
            }else{
                fighter1.health -= fighter2.damagePerAttack;
                if(fighter1.health <= 0) {
                    winner = fighter2.name;
                    break;
                }
                fighter2.health -= fighter1.damagePerAttack;
                if(fighter2.health <= 0){
                    winner = fighter1.name;
                }
            }
        }
        return winner;
    }
}

