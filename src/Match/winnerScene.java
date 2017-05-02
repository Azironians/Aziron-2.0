package Match;

import Heroes.HeroDevourer;
import Heroes.HeroLordVamp;
import Heroes.HeroOrcBasher;
import Main.Profile;

public class winnerScene {
    public static void winInfoUpdate(Profile profile1, Profile profile2, Boolean winer){
        if (winer){
            profile1.setWin(profile1.getWin()+1);
            if (profile1.getPlayer().getHero().getClass().equals(HeroOrcBasher.class)) profile1.setWinForOrcBacher(profile1.getWinForOrcBacher()+1);
            if (profile1.getPlayer().getHero().getClass().equals(HeroLordVamp.class)) profile1.setWinForLV(profile1.getWinForLV()+1);
            if (profile1.getPlayer().getHero().getClass().equals(HeroDevourer.class)) profile1.setWinForDevourer(profile1.getWinForDevourer()+1);
        profile2.setLose(profile2.getLose()+1);
        }else {
            profile2.setWin(profile2.getWin()+1);
            if (profile2.getPlayer().getHero().getClass().equals(HeroOrcBasher.class)) profile2.setWinForOrcBacher(profile2.getWinForOrcBacher()+1);
            if (profile2.getPlayer().getHero().getClass().equals(HeroLordVamp.class)) profile2.setWinForLV(profile2.getWinForLV()+1);
            if (profile2.getPlayer().getHero().getClass().equals(HeroDevourer.class)) profile2.setWinForDevourer(profile2.getWinForDevourer()+1);
            profile1.setLose(profile1.getLose()+1);
        }
        profile1.rewriteFile();
        profile2.rewriteFile();
    }
}
