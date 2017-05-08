package Main;

import Heroes.HeroDevourer;
import Heroes.HeroLordVamp;
import Heroes.HeroOrcBasher;
import Match.Player;

import java.io.*;

public class Profile {
    String name;
    Byte rank;
    Integer MMR;
    Integer win;
    Integer lose;
    Integer winForDevourer;
    Integer winForLV;
    Integer winForOrcBacher;
    Player player;

    public Profile(String name) {
        this.name = name;
    }

    public Profile(String name, Byte rank, Integer MMR, Integer win, Integer lose, Integer winForDevourer, Integer winForLV, Integer winForOrcBacher) {
        this.name = name;
        this.rank = rank;
        this.MMR = MMR;
        this.win = win;
        this.lose = lose;
        this.winForDevourer = winForDevourer;
        this.winForLV = winForLV;
        this.winForOrcBacher = winForOrcBacher;
    }

    public Profile(String name, Byte rank, Integer MMR, Integer win, Integer lose, Integer winForDevourer, Integer winForLV, Integer winForOrcBacher, Player player) {
        this.name = name;
        this.rank = rank;
        this.MMR = MMR;
        this.win = win;
        this.lose = lose;
        this.winForDevourer = winForDevourer;
        this.winForLV = winForLV;
        this.winForOrcBacher = winForOrcBacher;
        this.player = player;
    }

    //Изменяем ранг профию:
    public void correctStatistics(Player player, Profile profile, Profile opponentProfile) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(profile.getName()));

        if (player.isWinner()){
            for (int i = 0; i < 8; i++){
                switch (i){
                    case 2: //Коррекция рейтинга:
                        profile.setMMR(profile.getMMR() + 25 + opponentProfile.getRank() - profile.getRank()); // Изменить MMR
                        profile.correctRank(); // Изменить ранг
                        bufferedWriter.write(profile.getRank().toString() + "/" + profile.getMMR().toString());
                        bufferedWriter.newLine();
                        break;
                    case 3: //Коррекция побед:
                        profile.setWin(profile.getWin() + 1);
                        bufferedWriter.write(profile.getWin());
                        bufferedWriter.newLine();
                        break;
                    case 5: //Коррекция побед за выбранного героя:
                        if (player.getHero().getClass().equals(HeroDevourer.class)){
                            profile.setWinForDevourer(profile.getWinForDevourer() + 1);
                            bufferedWriter.write(profile.getWinForDevourer());
                        }
                        bufferedWriter.newLine();
                        break;
                    case 6:
                        if (player.getHero().getClass().equals(HeroLordVamp.class)){
                            profile.setWinForDevourer(profile.getWinForLV() + 1);
                            bufferedWriter.write(profile.getWinForLV());
                        }
                        bufferedWriter.newLine();
                        break;
                    case 7:
                        if (player.getHero().getClass().equals(HeroOrcBasher.class)){
                            profile.setWinForDevourer(profile.getWinForOrcBacher() + 1);
                            bufferedWriter.write(profile.getWinForOrcBacher());
                        }
                        bufferedWriter.close();
                        break;
                    default:
                        bufferedWriter.newLine();
                        break;
                }
            }
        } else { // Если поражение:
            for (int i = 0; i < 5; i++){
                switch (i){
                    case 2:
                        profile.setMMR(profile.getMMR() - 20 - profile.getRank() + opponentProfile.getRank()); //Изменить MMR
                        profile.correctRank(); // Изменить ранг
                        bufferedWriter.write(profile.getRank().toString() + "/" + profile.getMMR().toString());
                        bufferedWriter.newLine();
                        break;
                    case 4: //Коррекция поражений
                        profile.setLose(profile.getLose() + 1);
                        bufferedWriter.write(profile.getLose());
                        bufferedWriter.close();
                    default:
                        bufferedWriter.newLine();
                        break;
                }
            }
        }
    }


    public void correctRank(Profile this){
        if (this.getMMR() >= 0 && this.getMMR() < 50){
            this.setRank((byte) 1);
        }  if (this.getMMR() >= 50 && this.getMMR() < 100){
            this.setRank((byte) 2);
        }
        if (this.getMMR() >= 100 && this.getMMR() < 150){
            this.setRank((byte) 3);
        }
        if (this.getMMR() >= 150 && this.getMMR() < 200){
            this.setRank((byte) 4);
        }
        if (this.getMMR() >= 200 && this.getMMR() < 250){
            this.setRank((byte) 5);
        }
        if (this.getMMR() >= 250 && this.getMMR() < 300){
            this.setRank((byte) 6);
        }
        if (this.getMMR() >= 300 && this.getMMR() < 355){
            this.setRank((byte) 7);
        }
        if (this.getMMR() >= 355 && this.getMMR() < 410){
            this.setRank((byte) 8);
        }
        if (this.getMMR() >= 410 && this.getMMR() < 465){
            this.setRank((byte) 9);
        }
        if (this.getMMR() >= 465 && this.getMMR() < 520){
            this.setRank((byte) 10);
        }
        if (this.getMMR() >= 520 && this.getMMR() < 580){
            this.setRank((byte) 11);
        }
        if (this.getMMR() >= 580 && this.getMMR() < 640){
            this.setRank((byte) 12);
    }
        if (this.getMMR() >= 640 && this.getMMR() < 700){
            this.setRank((byte) 13);
        }
        if (this.getMMR() >= 700 && this.getMMR() < 765){
            this.setRank((byte) 14);
        }
        if (this.getMMR() >= 765 && this.getMMR() < 830){
            this.setRank((byte) 15);
        }
        if (this.getMMR() >= 830 && this.getMMR() < 900){
            this.setRank((byte) 16);
    }
        if (this.getMMR() >= 900 && this.getMMR() < 1000){
            this.setRank((byte) 17);
        }
        if (this.getMMR() >= 1000 && this.getMMR() < 1250){
            this.setRank((byte) 18);
        }
        if (this.getMMR() >= 1250 && this.getMMR() < 1500){
            this.setRank((byte) 19);
        }
        if (this.getMMR() >= 1500 && this.getMMR() < 5000){
            this.setRank((byte) 20);
        }
        else throw new IllegalArgumentException();
}





    //Getters and Setters:

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getRank() {
        return rank;
    }

    public void setRank(Byte rank) {
        this.rank = rank;
    }

    public Integer getMMR() {
        return MMR;
    }

    public void setMMR(Integer MMR) {
        this.MMR = MMR;
    }

    public Integer getWin() {
        return win;
    }

    public void setWin(Integer win) {
        this.win = win;
    }

    public Integer getLose() {
        return lose;
    }

    public void setLose(Integer lose) {
        this.lose = lose;
    }

    public Integer getWinForDevourer() {
        return winForDevourer;
    }

    public void setWinForDevourer(Integer winForDevourer) {
        this.winForDevourer = winForDevourer;
    }

    public Integer getWinForLV() {
        return winForLV;
    }

    public void setWinForLV(Integer winForLV) {
        this.winForLV = winForLV;
    }

    public Integer getWinForOrcBacher() {
        return winForOrcBacher;
    }

    public void setWinForOrcBacher(Integer winForOrcBacher) {
        this.winForOrcBacher = winForOrcBacher;
    }
}
