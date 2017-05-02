package Main;

import Match.Player;

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
