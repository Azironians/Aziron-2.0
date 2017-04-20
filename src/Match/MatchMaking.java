package Match;

public class MatchMaking {
    Player player1;
    Player player2;

    public static void damageVisual(){}
    public static void treatmentVisual(){}
public void damage(Player thisPlayer,Player otherPlayer) {
    otherPlayer.getHero().setHitPoints(otherPlayer.getHero().getHitPoints()-thisPlayer.getHero().getAttack());
    damageVisual();
}


    public void treatment(Player thisPlayer) {
        thisPlayer.getHero().setHitPoints(thisPlayer.getHero().getHitPoints()+thisPlayer.getHero().getTreatment());
        treatmentVisual();
    }


    public static void battleProcess(Player player1, Player player2){
        boolean inBattle = true;
        while (inBattle){
Player thisPlayer = player1;
Player otherPlayer = player2;


















        }
    }
}
