import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Afisam strategia");
        System.out.println("1 ati ales strategia defense");
        System.out.println("2 ati ales strategia attack");


        Scanner scanner=new Scanner(System.in);
        int optiune= scanner.nextInt();
        if(optiune==1){
            Strategy defenseStrategy=new DefenseStrategy();
            BattleField battleFieldDefense= new BattleField(defenseStrategy);
           battleFieldDefense.applyStrategy();
        }if(optiune==2){
           Strategy attackStrategy=new  AttackStrategy();
            BattleField battleFieldAttack= new BattleField(attackStrategy);
            battleFieldAttack.applyStrategy();
        }

    }
}
