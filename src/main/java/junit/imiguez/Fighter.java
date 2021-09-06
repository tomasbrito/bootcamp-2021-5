package junit.imiguez;

public class Fighter {

    /*Create a function that returns the name of the winner in a fight between two fighters.
    Each fighter takes turns attacking the other and whoever kills the other first is victorious.
    Death is defined as having health <= 0.     */

    public static void main(String[] args) {
        Fighter f1 = new Fighter("Pepe", 0, 1);
        Fighter f2 = new Fighter("John", 0, 2);
        System.out.println(f1.fight(f2));
    }

    public String name;
    public int health, damagePerAttack;

    public Fighter(String name, int health, int damagePerAttack) {
        this.name = name;
        this.health = health;
        this.damagePerAttack = damagePerAttack;
    }

    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        // Your code goes here. Have fun!
        int turn = 0;
        if (firstAttacker.equals(fighter1.name))
            turn++;
        while (fighter1.health > 0 && fighter2.health > 0) {
            turn++;
            if (turn % 2 == 0)
                fighter2.health -= fighter1.damagePerAttack;
            else
                fighter1.health -= fighter2.damagePerAttack;
            if (fighter1.health <= 0) {
                System.out.println(fighter1.name+" died.");
                return fighter2.name;
            } else if (fighter2.health <= 0) {
                System.out.println(fighter2.name+" died.");
                return fighter1.name;
            }
            System.out.println(fighter1.name+" has "+fighter1.health+" life points.");
            System.out.println(fighter2.name+" has "+fighter2.health+" life points.");
        }
        return "Both are dead.";
    }

    public String fight(Fighter enemy) {
        int turn = 0;
        while (health > 0 && enemy.health > 0) {
            turn++;
            if (turn % 2 == 0)
                enemy.health -= damagePerAttack;
            else
                health -= enemy.damagePerAttack;
            if (health <= 0) {
                System.out.println(name+" died.");
                return enemy.name+" is the winner.";
            } else if (enemy.health <= 0) {
                System.out.println(enemy.name+" died.");
                return name+" is the winner.";
            }
            System.out.println(name+" has "+health+" life points.");
            System.out.println(enemy.name+" has "+enemy.health+" life points.");
        }
        return "Both are dead.";
    }
}