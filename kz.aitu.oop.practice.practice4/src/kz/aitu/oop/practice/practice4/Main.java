package kz.aitu.oop.practice.practice4;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "root");

            Statement statement = connection.createStatement();
            ArrayList<Thing> bag = new ArrayList<Thing>();
            int total = 0;
            while (true){
                ResultSet rs;
                System.out.println("1. Fishes\n"+
                        "2. Reptiles\n"+
                        "3. Aquariums\n"+
                        "4. Toys\n"+
                        "5. Cart and total price");
                int id, price;
                String name;
                int act = scanner.nextInt();
                int inact;
                switch (act){
                    case 1:
                        rs = statement.executeQuery("select * from fishes");
                        while(rs.next()){
                            id = rs.getInt(1);
                            name = rs.getString(2);
                            price = rs.getInt(3);
                            System.out.println(id + ". Specie: " +name + " Price: " + price);
                        }
                        rs.close();
                        inact = scanner.nextInt();
                        rs = statement.executeQuery("select name, price from fishes where id = " + inact + ";");
                        while(rs.next()){
                            name = rs.getString(1);
                            price = rs.getInt(2);
                            bag.add(new Thing(name + " " + price));
                            total+=price;
                        }
                        break;
                    case 2:
                        rs = statement.executeQuery("select * from reptiles");
                        while(rs.next()){
                            id = rs.getInt(1);
                            name = rs.getString(2);
                            price = rs.getInt(3);
                            System.out.println(id + ". Specie: " +name + " Price: " + price);
                        }
                        rs.close();
                        inact = scanner.nextInt();
                        rs = statement.executeQuery("select name, price from reptiles where id = " + inact + ";");
                        while(rs.next()){
                            name = rs.getString(1);
                            price = rs.getInt(2);
                            bag.add(new Thing(name + " " + price));
                            total+=price;
                        }
                        break;
                    case 3:
                        rs = statement.executeQuery("select * from aquarium");
                        while(rs.next()){
                            id = rs.getInt(1);
                            name = rs.getString(2);
                            price = rs.getInt(3);
                            System.out.println(id + ". Specie: " +name + " Price: " + price);
                        }
                        rs.close();
                        inact = scanner.nextInt();
                        rs = statement.executeQuery("select name, price from aquarium where id = " + inact + ";");
                        while(rs.next()){
                            name = rs.getString(1);
                            price = rs.getInt(2);
                            bag.add(new Thing(name + " " + price));
                            total+=price;
                        }
                        break;
                    case 4:
                        rs = statement.executeQuery("select * from toys");
                        while(rs.next()){
                            id = rs.getInt(1);
                            name = rs.getString(2);
                            price = rs.getInt(3);
                            System.out.println(id + ". Specie: " +name + " Price: " + price);
                        }
                        rs.close();
                        inact = scanner.nextInt();
                        rs = statement.executeQuery("select name, price from toys where id = " + inact + ";");
                        while(rs.next()){
                            name = rs.getString(1);
                            price = rs.getInt(2);
                            bag.add(new Thing(name + " " + price));
                            total+=price;
                        }
                        break;
                    case 5:
                        for(int i = 0; i < bag.size(); i++) {
                            System.out.println(bag.get(i));
                        }
                        System.out.println(total);
                        break;
                    case 6:
                        System.exit(0);
                }
            }
        } catch (SQLException e) {
            System.err.println("error");
        }

    }
}
