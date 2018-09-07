package klasa_anonimowa;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

//klasy anonimowej uzywamy jesli chcem utwozyc obiekt klasy nie podajac jej nazwy
//klasy anonimowe sa zwykle wykorzystywane z interfejsami
public class Main {

    public interface ButtonT {
        void click();
    }

    public static void action() {
        //tworzenie klasy anonimowej ktora bedize instancja tego interfejsu
        ButtonT button = new ButtonT() {
            @Override
            public void click() {
                System.out.println("Przycisk klikniety ");
            }
        };
        button.click();
    }

    public static void main(String[] args) {

        //wyrazenie lambda, przeciazanie metody(nie trzeba wczytywac calej metody action tylko przeciazyc np onclick)
        //zeby korzystac z lamdy w kontekscie interfejsow to interfejs musi byc funkcyjny, czyli miec jedna metode
        //button.click(); wykona tą lambde
        ButtonT button = () -> System.out.println("Przycisk klikniety");
        button.click();

        //podobna sytuacja jest z wątkami

        Runnable t1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Jestem w nowym wątku");
            }
        };
        t1.run();

        //to całe wyżej tez mozna skrócic do wyrazenia lambda
        //nawias okragly i strzalka informuje ze chcemy wykorzystac wyrazenie lambda
        //<lista parametrow> -> <ciało wyrażenia>
        Runnable r1 = () -> System.out.println("Jestem w kolejnym");
        r1.run();

        //przyklad z buttona javyfx

        Button btn = new Button();
        btn.setText("Test");

        //tworzenie akcji
        //setonaction przyjmuje EventHandler, a on jest interfejsem, ktory rozszerza eventy, np action event
        //wiec implementuje nam sie klasa anonimowa, ktora zmusza nas do implementacji metody handle
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Przycisk został klikniety");
            }
        });

        //całe to wykonanie klasy anonimowej mozna zamienic wyrazeniem lambda
        //event jest uchwytem to obiektu ActionEvent
        btn.setOnAction(event -> System.out.println(event));

    }
}
