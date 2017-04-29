package GulkinInterface;

public class Profile {
    String name;
    Byte rank;
    Integer MMR;
    Integer win;
    Integer lose;
    Integer winForDevourer;
    Integer winForLV;
    Integer winForOrcBacher;

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


}
