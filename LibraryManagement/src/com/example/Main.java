package com.example;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.example.entity.Book;
import com.example.service.BookServiceImpl;
import com.example.entity.User;
import com.example.service.UserServiceImpl;
import com.example.service.LoanRecordServiceImpl;
import com.example.service.LoanRecordService;
import com.example.service.BookService;
import com.example.service.UserService;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BookService bookService = new BookServiceImpl();
        UserService userService = new UserServiceImpl();
        LoanRecordService loanService = new LoanRecordServiceImpl();

        int choice = -1;
        do {
            try {
                System.out.println("=== Library Management System ===");
                System.out.println("1. Book Section");
                System.out.println("2. User Section");
                System.out.println("3. LoanRecord Section ");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice! Please enter a valid number.");
                sc.nextLine();
                continue;
            }

            switch (choice) {
                case 1: {
                    int bookChoice = -1;
                    do {
                        try {
                            System.out.println("--------- Book Menu ---------");
                            System.out.println("1. Add Book");
                            System.out.println("2. Update Book Details");
                            System.out.println("3. Update Book Details(Multiple)");
                            System.out.println("4. Delete Book By Id");
                            System.out.println("5. Delete Book By Name");
                            System.out.println("6. View all books");
                            System.out.println("7. Search Book By Title");
                            System.out.println("0. Back");
                            System.out.print("Enter choice: ");
                            bookChoice = sc.nextInt();
                            sc.nextLine();
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input! Please enter a valid number.");
                            sc.nextLine();
                            continue;
                        }

                        switch (bookChoice) {
                            case 1: {
                                try {
                                    System.out.print("Enter ID: ");
                                    int id = sc.nextInt();
                                    sc.nextLine();
                                    System.out.print("Enter Title: ");
                                    String title = sc.nextLine();
                                    System.out.print("Enter Description: ");
                                    String desc = sc.nextLine();
                                    System.out.print("Enter Price: ");
                                    double price = sc.nextDouble();
                                    sc.nextLine();
                                    System.out.print("Enter Author: ");
                                    String author = sc.nextLine();
                                    System.out.print("Enter Publisher: ");
                                    String publisher = sc.nextLine();
                                    System.out.print("Enter Quantity: ");
                                    int qty = sc.nextInt();
                                    sc.nextLine();

                                    bookService.addBook(id, title, desc, price, author, publisher, qty);
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid data type entered! Please try again.");
                                    sc.nextLine();
                                }
                                break;
                            }
                            case 2: {
                                try {
                                    System.out.print("Enter ID you want to update: ");
                                    int id = sc.nextInt();
                                    sc.nextLine();

                                    System.out.println("What do you want to update?");
                                    System.out.println("1. Title");
                                    System.out.println("2. Description");
                                    System.out.println("3. Price");
                                    System.out.println("4. Author");
                                    System.out.println("5. Publisher");
                                    System.out.println("6. Quantity");
                                    System.out.println("7. All fields");
                                    System.out.print("Enter choice: ");
                                    int choiceup = sc.nextInt();
                                    sc.nextLine();

                                    Book bookup = bookService.get(id);

                                    if (bookup == null) {
                                        System.out.println("Book not found with the given ID");
                                        break;
                                    }
                                    System.out.println("Here is the book you want to update" + bookup);
                                    switch (choiceup) {
                                        case 1:
                                            System.out.print("Enter Title: ");
                                            bookup.setTitle(sc.nextLine());
                                            break;
                                        case 2:
                                            System.out.print("Enter Description: ");
                                            bookup.setDescription(sc.nextLine());
                                            break;
                                        case 3:
                                            System.out.print("Enter Price: ");
                                            bookup.setPrice(sc.nextDouble());
                                            sc.nextLine();
                                            break;
                                        case 4:
                                            System.out.print("Enter Author: ");
                                            bookup.setAuthor(sc.nextLine());
                                            break;
                                        case 5:
                                            System.out.print("Enter Publisher: ");
                                            bookup.setPublisher(sc.nextLine());
                                            break;
                                        case 6:
                                            System.out.print("Enter Quantity: ");
                                            bookup.setQuantity(sc.nextInt());
                                            sc.nextLine();
                                            break;
                                        case 7:
                                            System.out.print("Enter Title: ");
                                            bookup.setTitle(sc.nextLine());
                                            System.out.print("Enter Description: ");
                                            bookup.setDescription(sc.nextLine());
                                            System.out.print("Enter Price: ");
                                            bookup.setPrice(sc.nextDouble());
                                            sc.nextLine();
                                            System.out.print("Enter Author: ");
                                            bookup.setAuthor(sc.nextLine());
                                            System.out.print("Enter Publisher: ");
                                            bookup.setPublisher(sc.nextLine());
                                            System.out.print("Enter Quantity: ");
                                            bookup.setQuantity(sc.nextInt());
                                            sc.nextLine();
                                            break;
                                        default:
                                            System.out.println("Invalid choice!");
                                    }
                                    System.out.println("The book has been updated.");
                                    System.out.println(bookup);
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid input! Please try again.");
                                    sc.nextLine();
                                }
                                break;
                            }
                            case 3: {
                                try {
                                    System.out.print("Enter ID you want to update: ");
                                    int id = sc.nextInt();
                                    sc.nextLine();

                                    Book bookup = bookService.get(id);

                                    if (bookup == null) {
                                        System.out.println("Book not found with the given ID");
                                        break;
                                    }

                                    System.out.println("\nWhat do you want to update?");
                                    System.out.println("1. Title");
                                    System.out.println("2. Description");
                                    System.out.println("3. Price");
                                    System.out.println("4. Author");
                                    System.out.println("5. Publisher");
                                    System.out.println("6. Quantity");
                                    System.out.print("Enter choices (with commas in between): ");
                                    String[] choices = sc.nextLine().split(",");

                                    for (String ch : choices) {
                                        int choiceup;
                                        try {
                                            choiceup = Integer.parseInt(ch.trim());
                                        } catch (NumberFormatException e) {
                                            System.out.println("Invalid choice: " + ch);
                                            continue;
                                        }

                                        switch (choiceup) {
                                            case 1:
                                                System.out.print("Enter Title: ");
                                                bookup.setTitle(sc.nextLine());
                                                break;
                                            case 2:
                                                System.out.print("Enter Description: ");
                                                bookup.setDescription(sc.nextLine());
                                                break;
                                            case 3:
                                                System.out.print("Enter Price: ");
                                                bookup.setPrice(sc.nextDouble());
                                                sc.nextLine();
                                                break;
                                            case 4:
                                                System.out.print("Enter Author: ");
                                                bookup.setAuthor(sc.nextLine());
                                                break;
                                            case 5:
                                                System.out.print("Enter Publisher: ");
                                                bookup.setPublisher(sc.nextLine());
                                                break;
                                            case 6:
                                                System.out.print("Enter Quantity: ");
                                                bookup.setQuantity(sc.nextInt());
                                                sc.nextLine();
                                                break;
                                            default:
                                                System.out.println("Invalid choice: " + choiceup);
                                        }
                                    }

                                    System.out.println("Here is the updated book" + bookup);
                                    System.out.println("The book has been updated.");
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid input! Please try again.");
                                    sc.nextLine();
                                }
                                break;
                            }
                            case 4: {
                                try {
                                    System.out.print("Enter Book ID to delete: ");
                                    int delId = sc.nextInt();
                                    sc.nextLine();
                                    bookService.delete(delId);
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid ID entered!");
                                    sc.nextLine();
                                }
                                break;
                            }
                            case 5: {
                                System.out.print("Enter Book Name to delete: ");
                                String delName = sc.nextLine();
                                bookService.deleteBookByName(delName);
                                break;
                            }
                            case 6: {
                                System.out.println("All the books: ");
                                for (Book b : bookService.list()) {
                                    System.out.println(b);
                                }
                                break;
                            }
                            case 7: {
                                System.out.print("Enter Book Title to search: ");
                                String searchTitle = sc.nextLine();
                                System.out.println(bookService.searchBookByTitle(searchTitle));
                                break;
                            }
                        }
                    } while (bookChoice != 0);
                    break;
                }

                // USER SECTION 
                case 2: {
                    int userChoice = -1;
                    do {
                        try {
                            System.out.println("--- User Menu ---");
                            System.out.println("1. Add User");
                            System.out.println("2. Update User Details");
                            System.out.println("3. Update User Details(Multiple fields)");
                            System.out.println("4. Delete User By Id");
                            System.out.println("5. Delete User By Name");
                            System.out.println("6. Search User By Name");
                            System.out.println("7. List All Users");
                            System.out.println("0. Back");
                            System.out.print("Enter choice: ");
                            userChoice = sc.nextInt();
                            sc.nextLine();
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input! Please enter a valid number.");
                            sc.nextLine();
                            continue;
                        }

                        switch (userChoice) {
                            case 1: {
                                try {
                                    System.out.print("Enter ID: ");
                                    int uid = sc.nextInt();
                                    sc.nextLine();
                                    System.out.print("Enter Username: ");
                                    String uname = sc.nextLine();
                                    System.out.print("Enter Full Name: ");
                                    String fname = sc.nextLine();
                                    System.out.print("Enter Contact No: ");
                                    String contact = sc.nextLine();
                                    System.out.print("Enter Email: ");
                                    String email = sc.nextLine();
                                    System.out.print("Enter Password: ");
                                    String pass = sc.nextLine();
                                    System.out.print("Enter Role: ");
                                    String role = sc.nextLine();
                                    System.out.print("Enter DOB (yyyy-mm-dd): ");
                                    java.time.LocalDate dob = java.time.LocalDate.parse(sc.nextLine());

                                    userService.addUser(uid, uname, fname, contact, email, pass, role, dob);
                                } catch (Exception e) {
                                    System.out.println("Invalid input! Please try again.");
                                }
                                break;
                            }
                            case 2: {
                                try {
                                    System.out.print("Enter User ID to update: ");
                                    int upId = sc.nextInt();
                                    sc.nextLine();

                                    User existingUser = userService.get(upId);
                                    if (existingUser == null) {
                                        System.out.println("User not found!");
                                        break;
                                    }

                                    System.out.println("What do you want to update?");
                                    System.out.println("1. Username");
                                    System.out.println("2. Full Name");
                                    System.out.println("3. Contact No");
                                    System.out.println("4. Email");
                                    System.out.println("5. Password");
                                    System.out.println("6. Role");
                                    System.out.println("7. DOB");
                                    System.out.println("8. All fields");
                                    System.out.print("Enter choice: ");
                                    int updateChoice = sc.nextInt();
                                    sc.nextLine();

                                    switch (updateChoice) {
                                        case 1:
                                            System.out.print("Enter Username: ");
                                            existingUser.setUsername(sc.nextLine());
                                            break;
                                        case 2:
                                            System.out.print("Enter Full Name: ");
                                            existingUser.setFullName(sc.nextLine());
                                            break;
                                        case 3:
                                            System.out.print("Enter Contact No: ");
                                            existingUser.setContactNo(sc.nextLine());
                                            break;
                                        case 4:
                                            System.out.print("Enter Email: ");
                                            existingUser.setEmail(sc.nextLine());
                                            break;
                                        case 5:
                                            System.out.print("Enter Password: ");
                                            existingUser.setPassword(sc.nextLine());
                                            break;
                                        case 6:
                                            System.out.print("Enter Role: ");
                                            existingUser.setRole(sc.nextLine());
                                            break;
                                        case 7:
                                            System.out.print("Enter DOB (yyyy-mm-dd): ");
                                            existingUser.setDob(java.time.LocalDate.parse(sc.nextLine()));
                                            break;
                                        case 8:
                                            System.out.print("Enter Username: ");
                                            existingUser.setUsername(sc.nextLine());
                                            System.out.print("Enter Full Name: ");
                                            existingUser.setFullName(sc.nextLine());
                                            System.out.print("Enter Contact No: ");
                                            existingUser.setContactNo(sc.nextLine());
                                            System.out.print("Enter Email: ");
                                            existingUser.setEmail(sc.nextLine());
                                            System.out.print("Enter Password: ");
                                            existingUser.setPassword(sc.nextLine());
                                            System.out.print("Enter Role: ");
                                            existingUser.setRole(sc.nextLine());
                                            System.out.print("Enter DOB (yyyy-mm-dd): ");
                                            existingUser.setDob(java.time.LocalDate.parse(sc.nextLine()));
                                            break;
                                        default:
                                            System.out.println("Invalid choice.");
                                    }
                                } catch (Exception e) {
                                    System.out.println("Invalid input! Please try again.");
                                    sc.nextLine();
                                }
                                break;
                            }
                            case 3: { // Update User - Multiple Fields
                                try {
                                    System.out.print("Enter User ID you want to update: ");
                                    int id = sc.nextInt();
                                    sc.nextLine();

                                    User userUp = userService.get(id);

                                    if (userUp == null) {
                                        System.out.println("User not found with the given ID");
                                        break;
                                    }

                                    System.out.println("\nWhat do you want to update?");
                                    System.out.println("1. Username");
                                    System.out.println("2. Full Name");
                                    System.out.println("3. Contact No");
                                    System.out.println("4. Email");
                                    System.out.println("5. Password");
                                    System.out.println("6. Role");
                                    System.out.println("7. Date of Birth");
                                    System.out.print("Enter choices (with commas in between): ");
                                    String[] choices = sc.nextLine().split(",");

                                    for (String ch : choices) {
                                        int choiceup;
                                        try {
                                            choiceup = Integer.parseInt(ch.trim());
                                        } catch (NumberFormatException e) {
                                            System.out.println("Invalid choice: " + ch);
                                            continue;
                                        }

                                        switch (choiceup) {
                                            case 1:
                                                System.out.print("Enter Username: ");
                                                userUp.setUsername(sc.nextLine());
                                                break;
                                            case 2:
                                                System.out.print("Enter Full Name: ");
                                                userUp.setFullName(sc.nextLine());
                                                break;
                                            case 3:
                                                System.out.print("Enter Contact No: ");
                                                userUp.setContactNo(sc.nextLine());
                                                break;
                                            case 4:
                                                System.out.print("Enter Email: ");
                                                userUp.setEmail(sc.nextLine());
                                                break;
                                            case 5:
                                                System.out.print("Enter Password: ");
                                                userUp.setPassword(sc.nextLine());
                                                break;
                                            case 6:
                                                System.out.print("Enter Role: ");
                                                userUp.setRole(sc.nextLine());
                                                break;
                                            case 7:
                                                System.out.print("Enter Date of Birth (yyyy-MM-dd): ");
                                                userUp.setDob(java.time.LocalDate.parse(sc.nextLine()));
                                                break;
                                            default:
                                                System.out.println("Invalid choice: " + choiceup);
                                        }
                                    }

                                    System.out.println("Here is the updated user: " + userUp);
                                    System.out.println("The user has been updated.");
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid input! Please try again.");
                                    sc.nextLine();
                                }
                                break;
                            }
                            case 4: {
                                try {
                                    System.out.print("Enter User ID to delete: ");
                                    int delUid = sc.nextInt();
                                    sc.nextLine();
                                    userService.delete(delUid);
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid ID entered!");
                                    sc.nextLine();
                                }
                                break;
                            }
                            case 5: {
                                System.out.print("Enter User Name to delete: ");
                                String delUName = sc.nextLine();
                                userService.deleteUserByName(delUName);
                                break;
                            }
                            case 6: {
                                System.out.print("Enter User Name to search: ");
                                String searchUName = sc.nextLine();
                                System.out.println(userService.searchUserByName(searchUName));
                                break;
                            }
                            case 7: {
                                System.out.println("All Users: ");
                                System.out.println(userService.list());
                                break;
                            }
                        }
                    } while (userChoice != 0);
                    break;
                }

                // LOAN SECTION 
                case 3: {
                    int OrderChoice = -1;
                    do {
                        try {
                            System.out.println("--- Loan Menu ---");
                            System.out.println("1. Loan new Book");
                            System.out.println("2. View all the Loaned Books");
                            System.out.println("3. Return Book");
                            System.out.println("4. View by id");
                            System.out.println("0. Back");
                            System.out.print("Enter choice: ");
                            OrderChoice = sc.nextInt();
                            sc.nextLine();
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input! Please enter a number.");
                            sc.nextLine();
                            continue;
                        }

                        switch (OrderChoice) {
                            case 1: {
                                System.out.print("Enter the title of the book to be borrowed: ");
                                String loantitle = sc.nextLine();
                                try {
                                    System.out.print("Enter the id please: ");
                                    int idl = sc.nextInt();
                                    sc.nextLine();
                                    loanService.newRecord(loantitle, idl);
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid ID entered!");
                                    sc.nextLine();
                                }
                                break;
                            }
                            case 2: {
                                System.out.print(loanService.allrecords());
                                break;
                            }
                            case 3: {
                                System.out.print("Enter id of the book you want to return: ");
                                String Title = sc.nextLine();
                                loanService.newReturn(Title);
                                break;
                            }
                            case 4: {
                                try {
                                    System.out.print("Enter id of the user you want to check: ");
                                    int id1 = sc.nextInt();
                                    System.out.print(loanService.viewById(id1));
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid ID entered!");
                                    sc.nextLine();
                                }
                                break;
                            }
                        }
                    } while (OrderChoice != 0);
                    break;
                }
            }
        } while (choice != 0);

        sc.close();
    }
}
