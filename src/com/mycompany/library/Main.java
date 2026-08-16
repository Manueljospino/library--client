package com.mycompany.library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static ArrayList<Customer> customers = new ArrayList<>();
    static Scanner enter = new Scanner(System.in);
    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Loan> loans = new ArrayList<>();

  public static void createCustomer (){
      System.out.println("====Registro de clientes=====");
      System.out.println();
      System.out.print("Id       :  ");
      String id = enter.nextLine();
      System.out.print("Nombre   :  ");
      String name = enter.nextLine();
      System.out.print("Teléfono :  ");
      String phone = enter.nextLine();
      System.out.print("Correo:   ");
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



  // operation CRUD for Book
    public static void createBook () {
        System.out.println("====Registro de libros=====");
        System.out.println();
        System.out.print("Código                     :  ");
        String code = enter.nextLine();
        System.out.print("Título                     :  ");
        String title = enter.nextLine();
        System.out.print("Año en el que se publicó   :  ");
        int publicationYear = enter.nextInt();
        enter.nextLine();
        System.out.print("Autor                      :   ");
        String author = enter.nextLine();
        String availableInput;
        do {
            System.out.println("Disponible si o no? (S/N): ");
            availableInput = enter.nextLine().toUpperCase();
            if (!availableInput.equals("S") && !availableInput.equals("N")) {
                System.out.println("Respuesta inválida. Escriba S o N.");
            }


        } while (!availableInput.equals("S") && !availableInput.equals("N"));
        boolean available = availableInput.equals("S");

        Book b = new Book(code, title, publicationYear, author, available);
        books.add(b);
        System.out.println("Libro registrado exitosamente!");
        System.out.println();

    }

    public static ArrayList<Book> getBooks() {
      return books;
    }

    public static void showBooks(){
        if(books.isEmpty()){
            System.out.println("Error.. no hay libros registrados");
            return;
        }

        books.forEach(System.out::println);
    }

    public static Book getBook(String code){
        for(Book b : books){
            if(b.getCode().equals(code)){
                return b;
            }
        }
        return null;
    }

    public static void updateBook(){
        System.out.println("===Actualizar Libro===");
        System.out.println();
        System.out.println("Ingrese el codigo del libro: ");
        String code = enter.nextLine();

        Book b = getBook(code);
        if(b == null){
            System.out.println("Error.... el libro no existe");
            return;
        }

        System.out.println("Ingrese el titulo del libro: ");
        String title = enter.nextLine();
        System.out.println("Ingrese el Año en el que se publicó : ");
        int publicationYear = enter.nextInt();
        enter.nextLine();
        System.out.print("Ingrese el autor:   ");
        String author = enter.nextLine();
        String availableInput;
        do {
            System.out.println("Disponible si o no? (S/N): ");
            availableInput = enter.nextLine().toUpperCase();
            if (!availableInput.equals("S") && !availableInput.equals("N")) {
                System.out.println("Respuesta inválida. Escriba S o N.");
            }
        } while (!availableInput.equals("S") && !availableInput.equals("N"));
        boolean available = availableInput.equals("S");

        b.setAuthor(author);
        b.setAvailable(available);
        b.setPublicationYear(publicationYear);
        b.setTitle(title);
        System.out.println("Libro actualizado exitosamente!");
    }

    public static void deleteBook(){
        System.out.println("===Eliminar libro===");
        System.out.println();
        System.out.println("Ingrese el código del libro: ");
        String code = enter.nextLine();
        Book b = getBook(code);
        if(b == null){
            System.out.println("Error.... el libro no existe");
            return;
        }
        books.remove(b);
        System.out.println("libro eliminado exitosamente!");

    }

   //operations CRUD for Loan

    public static Loan getLoan(String id) {
        for (Loan l : loans) {
            if (l.getId().equals(id)) {
                return l;
            }
        }
        return null;
    }

    public static void createLoan() {
        System.out.println("===Registro de préstamos===");
        System.out.println();

        String id;
        do {
            System.out.print("Ingrese el id del préstamo: ");
            id = enter.nextLine();
            if (getLoan(id) != null) {
                System.out.println("Ese id ya existe. Intente con otro.");
            }
        } while (getLoan(id) != null);

        System.out.print("Ingrese el id del cliente: ");
        String customerId = enter.nextLine();
        Customer customer = getCustomer(customerId);
        if (customer == null) {
            System.out.println("Error.... el cliente no existe");
            return;
        }

        System.out.print("Ingrese el código del libro: ");
        String bookCode = enter.nextLine();
        Book book = getBook(bookCode);
        if (book == null) {
            System.out.println("Error.... el libro no existe");
            return;
        }

        LocalDate date = LocalDate.now();
        String status = "Activo";

        Loan loan = new Loan(id, customer, book, date, status);
        loans.add(loan);
        System.out.println("Préstamo registrado exitosamente!");
        System.out.println();
    }

    public static void returnLoan() {
        System.out.println("===Registrar devolución===");
        System.out.println();

        System.out.print("Ingrese el id del préstamo: ");
        String id = enter.nextLine();

        Loan loan = getLoan(id);
        if (loan == null) {
            System.out.println("Error.... el préstamo no existe");
            return;
        }

        loan.setStatus("Devuelto");
        System.out.println("Devolución registrada exitosamente!");
        System.out.println();
    }

    public static void showActiveLoans() {
        if (loans.isEmpty()) {
            System.out.println("No hay préstamos registrados.");
            return;
        }

        boolean hayActivos = false;
        for (Loan l : loans) {
            if (l.getStatus().equals("Activo")) {
                System.out.println(l);
                hayActivos = true;
            }
        }

        if (!hayActivos) {
            System.out.println("No hay préstamos activos.");
        }
    }



    public static void main(String[] args) {

            int option;
            do {
                System.out.println("========================================");
                System.out.println("   SISTEMA DE GESTIÓN DE BIBLIOTECA");
                System.out.println("========================================");
                System.out.println("--- Clientes ---");
                System.out.println("1. Registrar cliente");
                System.out.println("2. Listar clientes");
                System.out.println("3. Buscar cliente");
                System.out.println("4. Actualizar cliente");
                System.out.println("5. Eliminar cliente");
                System.out.println("--- Libros ---");
                System.out.println("6. Registrar libro");
                System.out.println("7. Listar libros");
                System.out.println("8. Buscar libro");
                System.out.println("9. Actualizar libro");
                System.out.println("10. Eliminar libro");
                System.out.println("--- Préstamos ---");
                System.out.println("11. Registrar préstamo");
                System.out.println("12. Registrar devolución");
                System.out.println("13. Listar préstamos activos");
                System.out.println("--- Otros ---");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");

                option = Integer.parseInt(enter.nextLine());

                switch (option) {
                    case 1 -> createCustomer();
                    case 2 -> showCustomers();
                    case 3 -> {
                        System.out.print("Ingrese el id del cliente a buscar: ");
                        String id = enter.nextLine();
                        Customer c = getCustomer(id);
                        System.out.println(c != null ? c : "Cliente no encontrado.");
                    }
                    case 4 -> updateCustomer();
                    case 5 -> deleteCustomer();
                    case 6 -> createBook();
                    case 7 -> showBooks();
                    case 8 -> {
                        System.out.print("Ingrese el código del libro a buscar: ");
                        String code = enter.nextLine();
                        Book b = getBook(code);
                        System.out.println(b != null ? b : "Libro no encontrado.");
                    }
                    case 9 -> updateBook();
                    case 10 -> deleteBook();
                    case 11 -> createLoan();
                    case 12 -> returnLoan();
                    case 13 -> showActiveLoans();
                    case 0 -> System.out.println("Saliendo del sistema...");
                    default -> System.out.println("Opción inválida.");
                }
                System.out.println();

            } while (option != 0);
        }






}
