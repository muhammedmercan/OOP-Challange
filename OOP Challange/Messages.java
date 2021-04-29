package oop.challange;

public class Messages {

    private String recipient;
    private String text;
    private int id;

    //Constructorleri oluşturuyoruz.

    public Messages(String recipient, String text, int id) {
        this.recipient = recipient;
        this.text = text;
        this.id = id;
    }

    public void getDetails() {        //Mesajın genel bilgisini ekrana yazacak bir fonksiyon ekliyoruz.
        System.out.println("Contact Name:" + recipient +
                "\nMessage: " + text +
                "\nId: " + id);
    }

    //getter ve setter metodlarını oluşturuyoruz

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}