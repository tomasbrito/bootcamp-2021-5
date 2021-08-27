package junit.gastonb;

public class KataCinco {
    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        //int actualHealth1, actualHealth2;
        if (fighter1.name.equals(firstAttacker)){
            return (ciclosVida(fighter2, fighter1)<=ciclosVida(fighter1, fighter2))? fighter1.name : fighter2.name;
        }else{//empieza f2
            return (ciclosVida(fighter1, fighter2)<=ciclosVida(fighter2, fighter1))? fighter2.name : fighter1.name;
        }
        //return null;
    }
    public static int ciclosVida(Fighter fighterA, Fighter fighterB){
        int ciclos=0;
        while (fighterA.health>0){
            fighterA.health = fighterA.health - fighterB.damagePerAttack;
            ciclos++;
        }
        return ciclos;
    }
}
