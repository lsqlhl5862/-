package MessageChat.Model;

import java.util.Date;

public class Message {




    private String date;
    private String text;
    private String translation;

    public Message(String date,String text,String translation)
    {
        setDate(date);
        setText(text);
        setTranslation(translation);
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    public String getTranslation() {
        return translation;
    }


    public void setText(String text) {
        this.text = text;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }
}
