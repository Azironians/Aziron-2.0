package Main;

public class Profile {
    String name;
    Byte rank;
    Integer MMR;
    Integer win;
    Integer lose;
    Integer winForDevourer;
    Integer winForLV;
    Integer winForOrcBacher;

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
    //Getters and Setters:

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
