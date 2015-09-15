/**
 * Created by brad on 9/14/15.
 */

import java.util.ArrayList;

import static spark.Spark.*;
import com.google.gson.Gson;

public class TodoService {

    public static class TodoItem {
        public String name;
        public boolean completed;

        TodoItem(String name, boolean completed) {
            this.name = name;
            this.completed = completed;
        }
    }

    public static void main(String[] args){
        ArrayList<TodoItem> list = new ArrayList<>();
        Gson gson = new Gson();

        get("/", (req, res) -> {
            return "Hello World";
        });

        get("/todos", (req, res) -> {
            return gson.toJson(list);
        });

        get("/todo/:id", (req, res) -> {
            int id = Integer.parseInt(req.params("id")) - 1;
            if(list.size() < id) {
                res.status(404);
                return "";
            } else {
                TodoItem item = list.get((id));
                return gson.toJson(item);
            }
        });

        post("/todo/", (req, res) -> {
            System.out.println(req.body());
            if (req.queryParams("name").length() < 1) {
                res.status(400);
                return "";
            } else {
                list.add(new TodoItem(req.queryParams("name"), false));
                res.status(201);
                return "";
            }
        });

        delete("/todo/:id", (req, res) -> {
            int id = Integer.parseInt(req.params("id")) - 1;
            list.remove(id);
            return gson.toJson(list);
        });
    }
}
