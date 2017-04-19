/**
 * Created by мсиайнина on 19.04.2017.
 */
public interface AzironGameLauncher {
    public void windowInitialization(); // Инциализация (загрузка)
    public void windowMenu();
    public void windowLocMch();
    public void panelLocMch();
    public void windowAutorization();
    public void signIn();
    public void signUp();
    public void getProfile();
    public void choiceHero();
    public void choicePanel();
    public void loadingMch();
    public void matchmaking(); //берет класс MatchMaking
    public void getWinner();
    public void getTotalScore();
}
