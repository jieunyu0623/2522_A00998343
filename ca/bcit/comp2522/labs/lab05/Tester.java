package ca.bcit.comp2522.labs.lab05;
/*
 * Tester.java
 */

public class Tester {

    /** Creates a new instance of Tester */
    public Tester() {
        Garage mine = new Garage();

        mine.add(new Car("Porsche","911",2,300,15));
        mine.add(new Car("Ferrari","GTO",2,301,12));
        mine.add(new Car("Citroen","2CV",5,95,40));
        mine.add(new Submarine("Bayliner","Nemo",12,20,150));
        mine.add(new Motorcycle("Ducati","900SS",1,200,35,90));
        mine.add(new Motorcycle("Yamaha","Roadstar",2,150,55,120));
        mine.add(new Truck("VW","Microbus",2000,6,130,45));

        mine.report();
    }

    public static <SpyCar2> void main (String[] args) {

        Tester tester = new Tester();

        SpyCar.MakeSpyCar spycar = new SpyCar().new MakeSpyCar("submersible", "123", 4, 500, 150, 50);
        String spycarInfo = spycar.toString();
        System.out.println(spycarInfo);

    }
}
