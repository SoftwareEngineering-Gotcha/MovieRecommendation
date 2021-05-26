package edu.knu.se;
import java.io.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.*;
import java.util.*;

class user_movies {
    String name;
    int movie_id;
    int rating;
    String password;
}

@RestController
@RequestMapping("/users")
public class UserController {
    BufferedWriter bw = null;
    BufferedWriter bwuser = null;
    private final UserRepository repository;
    List<String> data; 
    UserController(UserRepository repository){
        this.repository = repository;
    }

    @GetMapping("")
    List<User> all(){
        return repository.findAll();
    }

    @GetMapping("/_count_")
    int count(){
        List<User> list = repository.findAll();
        return list.size();
    }

    @GetMapping("/")
    List<String> return_movie(@RequestParam String uid){
        try {
            File csv = new File("ratings.csv");
            data = new ArrayList<String>();
            BufferedReader br = new BufferedReader(new FileReader(csv));
            String line = "";
            while ((line = br.readLine()) != null){
                String[] token = line.split(",", -1);
                if(token[0].equals(uid))
                {
                    data.add(token[1]);
                }
            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
        return data;
    }

    @PutMapping("/{userid}")
    String putUser(@PathVariable(name="userid") String uid, @RequestParam(name="passwd") String pwd) {
        String result = "FAILED";
        try {
            File csv_user = new File("Users.csv");
            bwuser = new BufferedWriter(new FileWriter(csv_user));
            if (!(repository.existsById(uid))) {

                User newUser = new User();
                newUser.setUid(uid);
                newUser.setPasswd(pwd);
                repository.save(newUser);
                result = "SUCCESS";
            } else {
                repository.findById(uid)
                        .map(user -> {
                            user.setUid(uid);
                            user.setPasswd(pwd);
                            repository.save(user);
                            return "";
                        });
                result = "SUCCESS";
            }
        } catch(FileNotFoundException e){

        } catch(IOException e){

        }
        return "{\"result\":"+result+"\"}";
    }

    @PutMapping("/{uid}/ratings")
    String Testing(@PathVariable("uid")String uid,@RequestParam("movie") String movie_id,@RequestParam("rating") int rating){
        String result = "FAILED";


        if(!(rating >= 1 && rating <= 5)) return result;

        try {
            File csv_write = new File("User_Rating_DB.csv");
            File csv_user = new File("Users.csv");
            File csv = new File("movies.csv");
            bwuser = new BufferedWriter(new FileWriter(csv_user));
            bw = new BufferedWriter(new FileWriter(csv_write));
            BufferedReader brd = new BufferedReader((new FileReader(csv_write));

            BufferedReader br = new BufferedReader(new FileReader(csv));
            String line = "";
            String d_line = "";
            while ((line = br.readLine()) != null){
                String[] token = line.split(",", -1);
                if(token[0].equals(movie_id))
                {
                    bw.write(uid);
                    bw.write(',');
                    bw.write(rating);
                    bw.write('\n');
                }
            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
        return result;
    }



    @DeleteMapping("/{userid}")
    String deleteUid(@PathVariable(name="userid") String uid) {
        String result = "FAILED";
        if((repository.existsById(uid))) {
            repository.deleteById(uid);
            result = "SUCCESS";
        }
        return "{\"result\":\"" + result + "\"}";
    }
}
