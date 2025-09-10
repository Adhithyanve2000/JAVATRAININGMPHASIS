package com.example;

import java.util.Scanner;
import com.example.entity.Book;
import com.example.service.BookServiceImpl;
import java.util.Scanner;
import com.example.entity.User;
import com.example.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookServiceImpl bookService = new BookServiceImpl();
        UserServiceImpl userService = new UserServiceImpl();
        LoanServiceImpl loanService = new LoanServiceImpl();

        int choice;
        do {
            System.out.println("=== Library Management System ===");
            System.out.println("1. Book");
            System.out.println("2. User");
            System.out.println("3. LoanRecord (Not implemented yet)");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: {
                    int bookChoice;
                    do {
                        System.out.println("--- Book Menu ---");
                        System.out.println("1. Add Book");
                        System.out.println("2. Update Book Details");
                        System.out.println("3. Delete Book By Id");
                        System.out.println("4. Delete Book By Name");
                        System.out.println("5. View all books");
                        System.out.println("6. Search Book By Title");
                        System.out.println("0. Back");
                        System.out.print("Enter choice: ");
                        bookChoice = sc.nextInt();
                        sc.nextLine();

                        switch (bookChoice) {
                            case 1: {
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
                                break;
                            }
                            case 2: {
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

                                switch (choiceup) {
                                    case 1: {
                                        System.out.print("Enter Title: ");
                                        bookup.setTitle(sc.nextLine());
                                        bookService.update(bookup);
                                        break;
                                    }
                                    case 2: {
                                        System.out.print("Enter Description: ");
                                        bookup.setDescription(sc.nextLine());
                                        bookService.update(bookup);
                                        break;
                                    }
                                    case 3: {
                                        System.out.print("Enter Price: ");
                                        bookup.setPrice(sc.nextDouble());
                                        sc.nextLine();
                                        bookService.update(bookup);
                                        break;
                                    }
                                    case 4: {
                                        System.out.print("Enter Author: ");
                                        bookup.setAuthor(sc.nextLine());
                                        bookService.update(bookup);
                                        break;
                                    }
                                    case 5: {
                                        System.out.print("Enter Publisher: ");
                                        bookup.setPublisher(sc.nextLine());
                                        bookService.update(bookup);
                                        break;
                                    }
                                    case 6: {
                                        System.out.print("Enter Quantity: ");
                                        bookup.setQuantity(sc.nextInt());
                                        sc.nextLine();
                                        bookService.update(bookup);
                                        break;
                                    }
                                    case 7: {
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
                                        bookService.update(bookup);
                                        break;
                                    }
                                    default: {
                                        System.out.println("Invalid choice!");
                                        break;
                                    }
                                }
                                System.out.println("The book has been updated.");
                                break;
                            }
                            case 3: {
                                System.out.print("Enter Book ID to delete: ");
                                int delId = sc.nextInt();
                                sc.nextLine();
                                bookService.delete(delId);
                                break;
                            }
                            case 4: {
                                System.out.print("Enter Book Name to delete: ");
                                String delName = sc.nextLine();
                                bookService.deleteBookByName(delName);
                                break;
                            }
                            case 5: {
                                System.out.println("All the books: ");
                                System.out.print(bookService.list());
                                break;
                            }
                            case 6: {
                                System.out.print("Enter Book Title to search: ");
                                String searchTitle = sc.nextLine();
                                System.out.println(bookService.searchBookByTitle(searchTitle));
                                break;
                            }
                            case 0: {
                                break;
                            }
                            default: {
                                System.out.println("Invalid choice.");
                                break;
                            }
                        }
                    } while (bookChoice != 0);
                    break;
                }
                case 2: {
                    int userChoice;
                    do {
                        System.out.println("--- User Menu ---");
                        System.out.println("1. Add User");
                        System.out.println("2. Update User Details");
                        System.out.println("3. Delete User By Id");
                        System.out.println("4. Delete User By Name");
                        System.out.println("5. Search User By Name");
                        System.out.println("6. List All Users");
                        System.out.println("0. Back");
                        System.out.print("Enter choice: ");
                        userChoice = sc.nextInt();
                        sc.nextLine();

                        switch (userChoice) {
                            case 1: {
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
                                break;
                            }
                            case 2: {
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
                                    case 1: {
                                        System.out.print("Enter Username: ");
                                        existingUser.setUsername(sc.nextLine());
                                        break;
                                    }
                                    case 2: {
                                        System.out.print("Enter Full Name: ");
                                        existingUser.setFullName(sc.nextLine());
                                        break;
                                    }
                                    case 3: {
                                        System.out.print("Enter Contact No: ");
                                        existingUser.setContactNo(sc.nextLine());
                                        break;
                                    }
                                    case 4: {
                                        System.out.print("Enter Email: ");
                                        existingUser.setEmail(sc.nextLine());
                                        break;
                                    }
                                    case 5: {
                                        System.out.print("Enter Password: ");
                                        existingUser.setPassword(sc.nextLine());
                                        break;
                                    }
                                    case 6: {
                                        System.out.print("Enter Role: ");
                                        existingUser.setRole(sc.nextLine());
                                        break;
                                    }
                                    case 7: {
                                        System.out.print("Enter DOB (yyyy-mm-dd): ");
                                        existingUser.setDob(java.time.LocalDate.parse(sc.nextLine()));
                                        break;
                                    }
                                    case 8: {
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
                                    }
                                    default: {
                                        System.out.println("Invalid choice.");
                                        break;
                                    }
                                }
                                break;
                            }
                            case 3: {
                                System.out.print("Enter User ID to delete: ");
                                int delUid = sc.nextInt();
                                sc.nextLine();
                                userService.delete(delUid);
                                break;
                            }
                            case 4: {
                                System.out.print("Enter User Name to delete: ");
                                String delUName = sc.nextLine();
                                userService.deleteUserByName(delUName);
                                break;
                            }
                            case 5: {
                                System.out.print("Enter User Name to search: ");
                                String searchUName = sc.nextLine();
                                System.out.println(userService.searchUserByName(searchUName));
                                break;
                            }
                            case 6: {
                                System.out.println("All Users: ");
                                System.out.println(userService.list());
                                break;
                            }
                            case 0: {
                                break;
                            }
                            default: {
                                System.out.println("Invalid choice.");
                                break;
                            }
                        }
                    } while (userChoice != 0);
                    break;
                }
                case 3: {
                    int OrderChoice;
                    do {
                        System.out.println("--- Loan Menu ---");
                        System.out.println("1. Loan new Book");
                        System.out.println("2. View all the Loaned Books");
                        System.out.println("0. Back");
                        System.out.print("Enter choice: ");
                        OrderChoice = sc.nextInt();
                        sc.nextLine();

                        switch (OrderChoice) {
                            case 1: {
                                System.out.print("Enter Title of the book ");
                                String Title= sc.nextLine();
                                loanService.newRecord(Title);
                                break;
                            }
                            case 2: {
                            	System.out.print(loanService.allrecords());
                            	break;  
                            }
                            case 3: {
                                System.out.print("Enter Title of the book you want to return ");
                                String Title= sc.nextLine();
                                loanService.newReturn(Title);
                                break;
                            }
                            
                            
                            

                case 0: {
                    System.out.println("Exiting...");
                    break;
                }
                default: {
                    System.out.println("Invalid choice.");
                    break;
                }
            }
        } while (choice != 0);

        sc.close();
    }
}

