public class SubscriptonFactory {

    public Subscripton getSubscripton(String subscriptonName){
        if(subscriptonName.equals("Standard")){
            return new Standard();
        }if(subscriptonName.equals("Bussnies")){
            return new Bussnies();
        }if(subscriptonName.equals("Premium")){
            return new Premium();
        }else{
            return null;
        }
    }

}
