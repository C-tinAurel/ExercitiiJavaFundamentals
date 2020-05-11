public class GasStation {
    private int motorina;
    private int benzina;
    private int pretM;
    private int pretB;

    public GasStation(int motorina, int pretM, int benzina, int pretB) {
        this.motorina = motorina;
        this.pretM = pretM;
        this.benzina = benzina;
        this.pretB = pretB;
    }

    public int getMotorina() {
        return motorina;
    }

    public int getPretM() {
        return pretM;
    }

    public int getBenzina() {
        return benzina;
    }

    public int getPretB() {
        return pretB;
    }

    public int sellM(int motorinaDeVandut) {
        int pretTotal = 0;
        if (this.motorina < 10) {
            System.out.println("Nu avem motorina in stoc");

        } else {
            if (motorinaDeVandut > this.motorina) {
                System.out.println("Nu avem atata motorina");
            }
            this.motorina -= motorinaDeVandut;
            pretTotal = motorinaDeVandut * pretM;

        }
        return pretTotal;


    }

    public int sellB(int benzinaDeVandut) {
        int pretTotal = 0;
        if (this.benzina < 10) {
            System.out.println("Nu avem  benzina stoc ");

        } else {
            if (benzinaDeVandut > this.benzina) {
                System.out.println("Nu avem atata benzina");

            }
            this.benzina -= benzinaDeVandut;
            pretTotal = benzinaDeVandut * pretB;
        }
        return pretTotal;
    }

    public String incaseazaBani(int bani, int pretTotal) {
        if (bani == pretTotal) {
            return "Multumim va mai asteptam ";
        } else if (bani > pretTotal) {
            return "Multumin , poftim restul" + (bani - pretTotal);
        } else {
            return "Chem politia";
        }
    }

}
