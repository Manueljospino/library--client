package com.mycompany.library;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Customer> customers = new ArrayList<>();
    static Scanner enter = new Scanner(System.in);

  public static void createCustomers (){
      System.out.println("====Registro de clientes=====");
      System.out.println();
      System.out.print("Id       :  ");
      String id = enter.nextLine();
      System.out.print("Nombre   :  ");
      String name = enter.nextLine();
      System.out.print("Teléfono :  ");
      String phone = enter.nextLine();
      System.out.println("Correo:   ");
      String email = enter.nextLine();

      Customer c = new  Customer(id,name,phone,email);
      customers.add(c);
  }

    public static void main(String[] args) {


    }




}
