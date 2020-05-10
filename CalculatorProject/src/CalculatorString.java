public class CalculatorString extends CalculatorStiintific {

    public CalculatorString() {

    }

    public String concatenare(String text, String text2) {
        return text.concat(text2);
    }

    public int contineCaracter(String text, char a) {
        return text.indexOf(a);
    }

    public int adunareStringuri(String text, String text2) {
        return text.length() + text2.length();
    }

    public boolean stringParImpar(String text) {
        if (text.length() % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public char[] sirCaractere(String text2) {
        return text2.toCharArray();
    }
    public boolean vocala(String text){
        char primaLitera =text.charAt(0);
        if(primaLitera=='a' || primaLitera=='e' || primaLitera=='i' || primaLitera=='o' || primaLitera=='u'){
            return true;
        }else {
            return false;
        }

    }
    public int spatiiString(String text){
        int numarSpatii= 0;
        for(int cursor=0;cursor<text.length();cursor++){
            if(text.charAt(cursor)==' '){
                numarSpatii++;
            }
        }
        return numarSpatii;
    }
}
