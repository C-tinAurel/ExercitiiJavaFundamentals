import java.util.*;

public class Main {
    public static void main(String[] args) {


        //Proiect prin care exemplificam folosirea colectiilor din Java

        //Set sa se declare un set in care adaugam 10 din capitalele Europei


        Set<String> capitals = new HashSet<String>();
        capitals.add("Bucuresti");
        capitals.add("Viena");
        capitals.add("Madrid");
        capitals.add("Roma");
        capitals.add("Berlin");
        capitals.add("Sofia");
        capitals.add("Paris");
        capitals.add("Budapesta");
        capitals.add("Praga");
        capitals.add("Lisabona");


        //stergem o intrare din set :folosim metoda remove
        capitals.remove("Lisabona");

        //adaugam in lista o intrare duplicate(o intrare care deja exista)

        capitals.add("Berlin");
        //deoarece set nu poate contine duplicate Berlin nu poate fii adaugata
        //java verifica daca obiectul exista deja si nu il mai aduga
        //verificare se face prin hashcode


        // parcurgerea unui set
        for (String capital : capitals) {
            System.out.println("Capitala este : " + capital);
        }

// List
        // sa se adauge intr o lista 10 culori
        List<String> colors = new ArrayList<String>();
        colors.add("red");
        colors.add("black");
        colors.add("white");
        colors.add("blue");


        for (String color : colors) {
            System.out.println("Culoarea gasita este " + color);
        }
        colors.remove("red");
        System.out.println("Culorile dupa ce am sters rosu " + colors);


        //LinkedList
        List<Integer> numbers = new LinkedList<Integer>();
        numbers.add(2);
        numbers.add(3);
        numbers.add(44);
        for (Integer number : numbers) {
            System.out.println("Numerele sunt : " + number);
        }
        // numbers.remove(55);// vazut ca si pozitia 55 (int 55 nu Integer)
        numbers.remove(Integer.valueOf(3));
        System.out.println("NUmerele dupa ce am sters 3");
        for (Integer number : numbers) {
            System.out.println("Numerele " + number);
        }
        //Collections clasa in java care ne ofera operatii gata implementate si optimizate
        //metodele din clsasa Collections sunt Statice


        //hai sa sortam listele
        Collections.sort(numbers);
        System.out.println("Lista de numere dupa ce a fost sortata");
        for (Integer number : numbers) {
            System.out.println("Numarul gasit este " + number);
        }
        Collections.sort(colors);
        System.out.println("Lista de culori dupa ce a fost sortata");
        for (String color : colors) {
            System.out.println("Culoare gasita este : " + color);
        }

        //cautarea--> returneaza indexul sau pozitia pe care a fost gasit elementul cautat
        int result = Collections.binarySearch(numbers, 2);
        System.out.println("rezultatul cautarii este " + result);

        int maximum = Collections.max(numbers);
        int minimum= Collections.min(numbers);
        System.out.println("Afisam maximum si minimum " +maximum + " " + minimum);


        // Map
        // sa se declare un Map in care sa se stocheze fiecare tara cu capitale ei
        Map<String,String>countryCapitalMap= new HashMap<String,String>();
        countryCapitalMap.put("Romania","Bucuresti");
        countryCapitalMap.put("Ungaria","Budapesta");
        countryCapitalMap.put("Bulgaria","Sofia");


        System.out.println( "Afisam capitala Ungariei " + countryCapitalMap.get("Ungaria"));
        System.out.println("Afisam capitala Bulgariei " + countryCapitalMap.get("Bulgaria"));


        //map care sa contina persoane si vastele lor
        Map<String,Integer> persoanAgeMap=new HashMap<String,Integer>();
        persoanAgeMap.put("Popescu",25);
        persoanAgeMap.put("Ionescu",36);
        System.out.println("Varsta lui Ionescu " +persoanAgeMap.get("Ionescu"));


        //parcurgem un map
       Set<String> countryCapitalKeys=countryCapitalMap.keySet();
        for(String key : countryCapitalKeys){
            System.out.println("Valoarea din map-ul CountryCapitalMap aferenta cheii " + key + " este " + countryCapitalMap.get(key));
        }
        //Map <String,Object>
        //Map<String,List<String>>




    }
}
