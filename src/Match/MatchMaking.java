package Match;

import javafx.stage.Stage;

import static InitializationGame.WindowMatchMaking1.launch;

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


    public static void battleProcess(Stage stage, Player player1, Player player2){
        launch(stage, player1, player2);
        boolean inBattle = true;
        while (inBattle){
Player thisPlayer = player1;
Player otherPlayer = player2;



inBattle=false;














        }
    }
}
