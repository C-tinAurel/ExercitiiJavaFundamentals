public class BattleField {
    private Strategy fightStrategy;

    public BattleField(Strategy fightStrategy) {
        this.fightStrategy = fightStrategy;
    }

    public void applyStrategy(){
        fightStrategy.attack();

    }

}
