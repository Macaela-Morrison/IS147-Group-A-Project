import java.util.Scanner;

public abstract class Settings {
    private String type;

    public Settings()
    {

    }

    public Settings(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public abstract void editSettings();

}
