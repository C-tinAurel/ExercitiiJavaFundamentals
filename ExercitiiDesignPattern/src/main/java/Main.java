public class Main {
    public static void main(String[] args) {
        //persoane
        // familia va avea 5 membrii
        //voma avea o clasa family-aplicam singleton
        //vom avea o clasa abstracta person
        //vom avea o clasa Mom-singleton
        //vom avea o clasa Dad-singleton
        //vom avea o clasa Kid
        //vom avea o clasa Son and Daughter o sa mosteneasca clasa kid


        Family family = Family.getInstance();
        Mom mom = Mom.getInstance();
        Dad dad = Dad.getInstance();
        Kid son = new Son("Popescu", "George", "13");
        Kid son2 = new Son("Popescu", "George", "15");
        Kid son3 = new Son("Popescu", "Mihai", "8");
        Kid daughter = new Daughter("Popescu", "Gabriela", "11");
        Kid daughter2 = new Daughter("Popescu", "Mirela", "17");

        family.getFamilyMambers().add(mom);
        family.getFamilyMambers().add(dad);
        family.getFamilyMambers().add(son);
        family.getFamilyMambers().add(son2);
        family.getFamilyMambers().add(son3);
        family.getFamilyMambers().add(daughter);
        family.getFamilyMambers().add(daughter2);
        System.out.println("Afisam membrii familiei");
        for (Person person : family.getFamilyMambers()) {

            System.out.println(person.toString());

        }


    }
}
