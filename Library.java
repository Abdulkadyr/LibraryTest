package OOP.LibraryManagementSystem;

import OOP.ShoolManSystem.School;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    public static void main(String[] args) throws IOException {


        //books object
        Book book1 = new Book(Reader.genUniqueID(), "Как устроена экономика", "Ха-Джун Чанг", true);
        Book book2 = new Book(Reader.genUniqueID(), "Война и мир", "Лев Толстой", true);
        Book book3 = new Book(Reader.genUniqueID(), "Государство", "Платон", true);
        Book book4 = new Book(Reader.genUniqueID(), "Найк", "Филл Найт", true);
        Book book5 = new Book(Reader.genUniqueID(), "Java 8", "Герберт Шилдт", true);
        Book book6 = new Book(Reader.genUniqueID(), "Евгений Онегин", "Александр Пушкин", true);
        Book book7 = new Book(Reader.genUniqueID(), "Государство_Правительство", "Платон", true);
        ArrayList<Book> bookArrayList = new ArrayList<>();
        bookArrayList.add(book1);
        bookArrayList.add(book2);
        bookArrayList.add(book3);
        bookArrayList.add(book4);
        bookArrayList.add(book5);
        bookArrayList.add(book6);
        bookArrayList.add(book7);

        //students object
        Reader ivan = new Reader(Reader.genUniqueID(), "Ivan", "ivan123", "ivan123", "student");
        Reader anton = new Reader(Reader.genUniqueID(), "Anton", "anton123", "anton123", "student");
        Reader beka = new Reader(Reader.genUniqueID(), "Beka", "beka123", "beka123", "student");

        //teachers object
        Reader anna = new Reader(Reader.genUniqueID(), "Anna", "anna123", "anna123", "teacher");
        Reader elena = new Reader(Reader.genUniqueID(), "Elena", "elena123", "elena123", "teacher");
        Reader vladimir = new Reader(Reader.genUniqueID(), "Vladimir", "vladimir123", "vladimir123", "teacher");
        //list readers
        ArrayList<Reader> readerList = new ArrayList<>();
        readerList.add(ivan);
        readerList.add(anton);
        readerList.add(beka);
        // ---------------
        readerList.add(anna);
        readerList.add(elena);
        readerList.add(vladimir);


        Reader readerAgaKhan = new Reader(readerList);
        Book bookAgaKhan = new Book(bookArrayList);

        Scanner scanner = new Scanner(System.in);
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));


        // Начало работы программы интерфейса
        System.out.println("Добро пожаловать в библиотеку школы Ага Хан");
        while (true) {
            System.out.println("1. Получить информацию о нашей библиотеке");
            System.out.println("2. Книги");
            System.out.println("3. Авторизоваться ");
            System.out.println("9. Выйти");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    getLibraryInfo(readerAgaKhan, bookAgaKhan);

                    System.out.println("9. Выйти в главное меню");
                    choice = scanner.nextInt();
                    switch (choice) {
                        case 9:
                            main(new String[]{" "});
                    }
                    break;
                case 2:
                    System.out.println("Наши книги......");
                    getBookList(bookAgaKhan);

                    break;
                case 3:
//                      Авторизация пользователя
                    authorization(readerAgaKhan, scanner);
//                    Расширенное меню для пользователя
                    usersMenu(readerAgaKhan, bookAgaKhan, scanner, buffReader);
                    break;

                case 9:
                    System.out.println("До свидания!");
                    System.exit(0);
            }


        }


    }

    public static void usersMenu(Reader reader, Book book, Scanner scanner, BufferedReader buffReader) throws IOException {
        Reader readerAgaKhan = new Reader(reader.getReaderList());
        Book bookAgaKhan = new Book(book.getBookArrayList());
        while (true) {
            System.out.println("1. Получить информацию о нашей библиотеке");
            System.out.println("2. Информация о книгах ");
            System.out.println("3. Информация о читателях");
            System.out.println("4. Поиск книг");
            System.out.println("5. Вернуть книгу");
            System.out.println("6. ");

            System.out.println("9. Выйти");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    getLibraryInfo(readerAgaKhan, bookAgaKhan);
                    while (true) {
                        System.out.println("9. Выйти в главное меню");
                        choice = scanner.nextInt();
                        switch (choice) {
                            case 9:
                                usersMenu(reader, book, scanner, buffReader);
                                break;
                        }
                    }

                case 2:
                    System.out.println("Наши книги...");
                    getBookList(bookAgaKhan);
                    break;
                case 3:
                    System.out.println("Наши читатели...");
                    getReaderList(readerAgaKhan);
                    break;
                case 4:
                    System.out.println("Введите названиеили имя автора книги, которую вы ищете...");
                    searchWord(bookAgaKhan, readerAgaKhan, buffReader);
                    takeBook(bookAgaKhan, readerAgaKhan, scanner, buffReader);
                    break;
                case 5:
                    System.out.println("");
//                    returnBook(readerAgaKhan, scanner, buffReader);
                    break;
                case 9:
                    System.out.println("До свидания!");
                    System.exit(0);
            }

        }


    }


    public static void getLibraryInfo(Reader reader, Book book) {
        List<Reader> readerListInfo = reader.getReaderList();
        List<Book> bookListInfo = book.getBookArrayList();

        System.out.println("В нашей библиотеке находятся " + bookListInfo.size() + " книг");
        System.out.println("Читателей " + readerListInfo.size() + " человек");

    }

    public static void authorization(Reader readerAgaKhan, Scanner scanner) {
        System.out.println("Авторизуйтесь");
        int count = 0;
        dataChecking(readerAgaKhan, scanner, count);
    }

    public static void getReaderList(Reader reader) {
        List<Reader> readerList = reader.getReaderList();
        for (Reader r : readerList) {

            if (r.getIssuedBook() != null) {
                System.out.println("ID: " + r.getId() + " |Name " + r.getName() + " |Login: " + r.getLogin() + " |Position: " + r.getPosition() + "| issuedBook" + r.getIssuedBook());
                System.out.println("----------------------------------------");
            } else {
                System.out.println("ID: " + r.getId() + " |Name " + r.getName() + " |Login: " + r.getLogin() + " |Position: " + r.getPosition() + "| issuedBook" + r.getIssuedBook());
                System.out.println("----------------------------------------");
            }

        }
    }

    public static void getBookList(Book book) {
        List<Book> bookList = book.getBookArrayList();
        for (Book b : bookList) {
            System.out.println("Имя книги:" + b.getName() + " | Автор:" + b.getAuthor() + " | ID:" + b.getId() + " | Наличие:" + b.isInStock());
            System.out.println("----------------------------------------");
        }
    }

    public static void dataChecking(Reader reader, Scanner scanner, int count) {
        String login;
        String password;

        System.out.println("Введите ваш логин...");
        login = scanner.next();
        System.out.println("Введите ваш пароль");
        password = scanner.next();

        Reader readerLogin = dataCheckingLogin(reader, login);
        Reader readerPassword = dataCheckingPassword(reader, password);

        if (count == 3) {
            System.out.println("Введены неверные данные!");
            System.out.println("Попробуйте позже");
            System.exit(0);
        } else if (login.equals(readerLogin.getLogin()) && password.equals(readerPassword.getLogin())) {
            System.out.println("Hello " + readerLogin.getName() + " чем могу помочь?");
        } else {
            System.out.println("неверные данные");
            count++;
            dataChecking(reader, scanner, count);
        }

    }


    public static Reader dataCheckingLogin(Reader reader, String login) {
        List<Reader> readerList = reader.getReaderList();
        Reader reader1 = new Reader();
        for (Reader r : readerList) {
            if (r.getLogin().equals(login)) {
                reader1 = r;
            }
        }
        return reader1;
    }

    public static Reader dataCheckingPassword(Reader reader, String password) {
        List<Reader> readerList = reader.getReaderList();
        Reader reader1 = new Reader();
        for (Reader r : readerList) {
            if (r.getPassword().equals(password)) {
                reader1 = r;
            }
        }
        return reader1;
    }

    public static Book searchWord(Book book, Reader reader, BufferedReader buffReader) throws IOException {
        Book book1 = new Book();
        List<Book> bookList = book.getBookArrayList();
        String search = buffReader.readLine().toLowerCase();

        System.out.println("Вы ищите?");
        for (Book b : bookList) {
            if (b.getName().toLowerCase().matches("(.*)" + search + "(.*)") || b.getAuthor().toLowerCase().matches("(.*)" + search + "(.*)")) {
                System.out.println("ID: " + b.getId() + " |Name " + b.getName() + " |Author " + b.getAuthor() + " | In stock :" + b.isInStock());
            }

        }

        return book1;
    }

    public static void takeBook(Book book, Reader reader, Scanner scanner, BufferedReader buffReader) throws IOException {
        List<Book> bookList = book.getBookArrayList();
        System.out.println("Для получения, введите айди книги");
        int idBook = scanner.nextInt();
        for (Book b : bookList) {
            if (idBook == b.getId()) {
                System.out.println("Хотие взять книгу " + b.getName() + "|Author " + b.getAuthor());
                System.out.println("1. Yes");
                System.out.println("2. No");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        b.setInStock(false);
                        b.setUser(reader);
                        reader.addIssuedBook(b);
                        System.out.println("Вы получили книгу" + " |Name" + b.getName() + " |Author " + b.getAuthor());
                        System.out.println("");
                        break;
                    case 2:
                        usersMenu(reader, book, scanner, buffReader);
                        break;
                }
            }
        }
    }


//    public static void returnBook( Reader reader, Scanner scanner, BufferedReader buffReader){
//        String bookList = reader.getIssuedBook();
//
//    }


}
