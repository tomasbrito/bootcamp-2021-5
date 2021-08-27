package junit.lvazquez;

public class KataCinco {
    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {

        Fighter first;
        Fighter second;

        //1. Establecer primer atacante

        if (fighter1.name == firstAttacker) {
            first = fighter1;
            second = fighter2;
        } else {
            first = fighter2;
            second = fighter1;
        }

        //2. Mientras ambos tengan vida se siguen pegando
        while (first.health > 0 && second.health > 0) {
            second.health -= first.damagePerAttack;
            if (second.health >= 0) {
                first.health -= second.damagePerAttack;
            }
        }

        //3. Cuando ya no se pegan, si el primero tiene mas de 0 vida es el ganador
        //3. Si tiene 0 o menos, es el perdedor
        if (first.health > 0) return first.name;
        return second.name;
    }

}