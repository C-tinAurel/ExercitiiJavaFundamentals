public class StringOperations {
    //daca faci modificari ai grija ca testarul sa functioneaze
    public int stringLength(String text) {
        return text.length();
    }

    public String concatenare(String text1, String text2) {
        return text1.concat(text2);
    }
public boolean stringContains(String text1,String text2){
        if(text1.contains(text2)){
            return true;
        }else{
            return false
                    ;
        }
}
}
