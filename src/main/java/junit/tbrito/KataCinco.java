package junit.tbrito;

public class KataCinco {
    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        String ganador = "";
        if(fighter2.name.equals(firstAttacker)){
            fighter1.health = fighter1.health - fighter2.damagePerAttack;
        }
        while(fighter1.health>0 && fighter2.health>0){
            fighter2.health = fighter2.health - fighter1.damagePerAttack;
            if (fighter2.health>0){
                fighter1.health = fighter1.health - fighter2.damagePerAttack;
            }
        }

       ganador = (fighter1.health>0)? fighter1.name : fighter2.name;

        return ganador;
    }
}
