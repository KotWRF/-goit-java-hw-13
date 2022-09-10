import java.io.IOException;
import java.net.URI;
import java.util.List;

public class Main {
    private static final String POSTS = "https://jsonplaceholder.typicode.com/posts";
    private static final String USERS = "https://jsonplaceholder.typicode.com/users";


    public static void main(String[] args) throws IOException, InterruptedException {
        User defaultUser = new User(1,
                "Aisling Duval", "empire princess", "duval_aisling@empir.net", new Address("Cubeo", "Cubeo 2",
                "Adelman Station", "2559-7702", new Geo("46.2420",
                "30.4237")), "096-800-0000 x400",
                "https://elite-dangerous.fandom.com/ru/wiki/%D0%90%D0%B9%D1%81%D0%BB%D0%B8%D0%BD%D0%B3_%D0%94%D1%8E%D0%B2%D0%B0%D0%BB%D1%8C",
                new Company("Empire", "everything will be Ukraine",
                        "finance and interactions"));

        //создание нового объекта
        User createdUser = HttpUtil.putUser(URI.create(USERS), defaultUser);
        System.out.println(createdUser);

        //обновление объекта
        User updatedUser = HttpUtil.postUser(URI.create(USERS), defaultUser);
        System.out.println(updatedUser);

        //удаление объекта
        HttpUtil.deleteUser(URI.create(USERS), 11);

        //получение информации обо всех пользователях
        List<User> allUsers = HttpUtil.getUsers(URI.create(USERS));
        System.out.println(allUsers);

        //получение информации о пользователе с определенным id
        User userById = HttpUtil.getUserById(URI.create(USERS),4);
        System.out.println(userById);

        //получение информации о пользователе с опредленным username
        User userName = HttpUtil.getUserByUserName(URI.create(USERS), "Delphine");
        System.out.println(userName);





        //Task 2
        HttpUtil.getUserComments(2);




        //Task 3
        List<Todo> allTodos = HttpUtil.getUserTodos(URI.create(USERS), 1);
        System.out.println(allTodos);

    }

}
