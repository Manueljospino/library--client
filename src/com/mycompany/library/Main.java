package com.mycompany.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static ArrayList<Customer> customers = new ArrayList<>();
    static Scanner enter = new Scanner(System.in);

  public static void createCustomer (){
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
      System.out.println("Paciente registrado exitosamente!");
      System.out.println();

  }

      public static ArrayList<Customer> getCustomers() {
        return customers;
      }

      public static void showCustomers(){
           if(customers.isEmpty()){
               System.out.println("Error.... lista vacía");
               return;
           }

          customers.forEach(System.out::println);
        }

       public static Customer getCustomer(String id){
        for(Customer c : customers){
            if(c.getId().equals(id)){
                return c;
            }
        }
        return null;

       }

     public static void updateCustomer(){
         System.out.println("===Actualizar cliente===");
         System.out.println();
         System.out.println("Ingrese el id del cliente: ");
         String id = enter.nextLine();

         Customer c = getCustomer(id);
         if(c == null){
             System.out.println("Error.... el cliente no existe");
             return;
         }

         System.out.println("Ingrese el nombre del cliente: ");
         String name = enter.nextLine();
         System.out.println("Ingrese el telefono del cliente: ");
         String phone = enter.nextLine();
         System.out.println("Ingrese el correo del cliente: ");
         String email = enter.nextLine();

         c.setName(name);
         c.setPhone(phone);
         c.setEmail(email);

         System.out.println("cliente actualizado exitosamente!");
     }

     public static void deleteCustomer(){
         System.out.println("===Eliminar cliente===");
         System.out.println();
         System.out.println("Ingrese el id del cliente: ");
         String id = enter.nextLine();
         Customer c = getCustomer(id);
         if(c == null){
             System.out.println("Error.... el cliente no existe");
             return;
         }
         customers.remove(c);
         System.out.println("cliente eliminado exitosamente!");

     }

    public static void main(String[] args) {


    }




}
