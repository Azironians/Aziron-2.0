package Main;

import Match.Player;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

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

    public void rewriteFile() {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader("src\\Profiles\\" + this.getName() + ".hoa"));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] file = sb.toString().split("\n");
        file[2] = this.getRank() + "/" + this.getMMR();
        file[3] = this.getWin() + "";
        file[4] = this.getLose() + "";
        file[5] = this.getWinForDevourer() + "";
        file[6] = this.getWinForLV() + "";
        file[7] = this.getWinForOrcBacher() + "";

        try (FileWriter writer = new FileWriter("src\\Profiles\\" + this.getName() + ".hoa")) {
            for (String i : file)
                writer.write(i + "\n");
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
