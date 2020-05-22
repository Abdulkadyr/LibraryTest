package OOP.LibraryManagementSystem;


import java.util.ArrayList;
import java.util.List;

public class Reader {
    private int id;
    private String name;
    private String  login;
    private String password;
    private String position;
    private List<Book>  issuedBook;

    private ArrayList<Reader> readerList;


    public List<Book> getIssuedBook() {
        return issuedBook;
    }

    public void addIssuedBook(Book book) {
        this.issuedBook.add(book);
    }



    //генерация уникального айди для читателя
    private static ArrayList<Integer> ids = new ArrayList<>();
    public static int genUniqueID(){
        int id = 0;
        while (true){
            id = (int)(Math.random() * 899) + 100;
            if(checkForDuplicatesId(id)){
                ids.add(id);
                break;
            }
        }
        return id;
    }
    public static boolean checkForDuplicatesId(int id){
        for (int i: ids) {
            if(i == id){
                return false;
            }
        }
        return true;
    }

    public Reader() {}
    public Reader(ArrayList<Reader> readerList) {
        this.readerList = readerList;
    }

    public Reader(int id, String name, String login, String password, String position) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.position = position;
    }
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Reader> getReaderList() {
        return readerList;
    }

    public void setReaderList(ArrayList<Reader> readerList) {
        this.readerList = readerList;
    }


}
