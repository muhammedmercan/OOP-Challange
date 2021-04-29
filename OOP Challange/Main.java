package oop.challange;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Contact> contacts = new ArrayList<>(); //Contact sınıfından bir ArrayList oluşturuyoruz.
    private static ArrayList<Messages> messages = new ArrayList<>(); //Messages sınıfından bir ArrayList oluşturuyoruz.
    private static int id = 0;

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {


        System.out.println("Welcome.");
        showInıtıalOptions();

    }
    private static void showInıtıalOptions() {
        System.out.println("1.Manage Concats " +
                "\n2.Messages " +
                "\n3.Quit");
        switch (scanner.nextInt()) {
            case 1:
                manageContacts();
                break;

            case 2:
                manageMessages();
                break;

        }
    }
    private static void manageContacts() {
        System.out.println("1.Show all contacts " +
                "\n2.Add a new contact " +
                "\n3.Search for a contact " +
                "\n4.Delete a contact " +
                "\n5.Go back to the previous menu");

        switch (scanner.nextInt()) {
            case 1:
                try {
                    for (Contact c: contacts) { //contacts ArrayList indeki tüm verileri dönüyoruz ve
                        c.getAllContact();      //ekrana yazdırıyoruz.
                    }}
                    catch (Exception error) {
                        System.out.println("Kayıtlı kişi yok\n");
                    }
                    manageContacts();

            case 2:
                System.out.println("İsim:"); //Yeni oluşturulacak kayıt bilgilerini kullanıcıdan alıyoruz.
                String name = scanner.next();
                System.out.println("Numara");
                String number = scanner.next();
                System.out.println("E-Mail");
                String email = scanner.next();
                Contact contact = new Contact(name,number,email); // Contact sınıfından kullanıcının girdiği verileri
                                                                  // kullanarak bir obje oluşturuyoruz.

                contacts.add(contact);   //objeyi contacts ArrayListine dahil ediyoruz.
                manageContacts();

            case 3:
                System.out.println("Enter name to search");
                String nameSearch = scanner.next();
                for (Contact c: contacts) {                               //contacts ArrayList içindekileri dönüyoruz.
                    if (c.getName().equals(nameSearch)) {                 //Kullanıcının girdiği isimle ArrayListteki

                        System.out.println("Name: " + c.getName());       //isim eşleştiğinde o kullanıcının
                        System.out.println("Mail: " + c.getEmail());      //bilgilerini yazdırıyoruz.
                        System.out.println("Number: " + c.getNumber());
                    }
                }
                manageContacts();
            case 4:
                System.out.println("Enter name to delete");
                String nameDelete = scanner.next();            //Kullanıcıdan silincek kaydın ismini alıyoruz.
                for (Contact c: contacts) {                    //contacts ArrayList içindekileri dönüyoruz.

                    if (c.getName().equals(nameDelete)) {      //Kullanıcının girdiği isimle ArrayListteki
                        contacts.remove(c);                    //isim eşleştiğinde o kullanıcıyı Arraylistten siliyoruz.
                    }
                    }
                manageContacts();
            case 5:
                showInıtıalOptions();
                break;
        }
    }
    private static void manageMessages() {
        System.out.println("\n1.See the list of all messages " +
                "\n2.Send a new message " +
                "\n3.Go back to the previous menu");
        switch (scanner.nextInt()) {
            case 1:
               if (messages.size() > 0) {          //messages ArrayListindeki veri sayısı 0 dan fazlaysa yazdırıyoruz.
                   for (Messages m: messages) {
                       m.getDetails();
                   }
               }
               else{
                   System.out.println("Mesaj yok");
               }
                manageMessages();
            case 2:
                System.out.println("type the recipiant you want to send a message to");
                String recipiant = scanner.next();
                System.out.println("type a massage");
                String message = scanner.next();
                id++;
                Messages newMessage = new Messages(recipiant,message,id); //Kullanıcıdan aldığımız verilerle Messages
                                                                          //sınıfından bir obje oluşturuyoruz.

                for (Contact c: contacts) {                               //contacts Arraylistini dönüyoruz.

                    if (c.getName().equals(recipiant)) {                  //Kullanıcının verdiği isimle Arraylistteki
                       messages.add(newMessage);                          //isim eşleştiğinde yeni mesajı eşleşen
                       c.setMessages(messages);                           //kulanıcının mesajlarına ekliyoruz.
                    }
                }
                manageMessages();
            case 3:
                showInıtıalOptions();
        }
    }
}
