package junit.gozimisa;
//kata 5
public class KataCinco {
    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        boolean ganaa=false;
        boolean ganab=false;
        String ganador = "";
        Fighter a=fighter1, b=fighter2;
        if(firstAttacker.equals(fighter2.name)){
            a=fighter2;
            b=fighter1;
        }
        while(!ganaa && !ganab){ {
                b.health=b.health-a.damagePerAttack;
                if(b.health<=0){
                    ganador=a.name;
                    ganaa=true;
                }

                a.health=a.health-b.damagePerAttack;
                if(a.health<=0 && !ganaa){
                    ganador=b.name;
                    ganab=true;
                }
            }
        }
        return ganador;
    }
}
