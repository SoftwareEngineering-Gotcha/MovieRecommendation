package edu.knu.se;
import java.io.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.*;

import java.nio.Buffer;
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
    BufferedReader read_bwuser = null;
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
        int count = 0;
        try{
            File csv_user = new File("user.csv");
            read_bwuser = new BufferedReader(new FileReader(csv_user));
            String line="";
            while((line = read_bwuser.readLine()) != null){
                count++;
            }
        }catch (FileNotFoundException e){

        }catch (IOException e){}

        count--;
        return count;
    }

    @GetMapping("/{userid}/ratings")
    List<String> return_movie(@PathVariable(name = "userid") String uid){
        boolean user_exist = false;
        try {
            File csv = new File("ratings.csv");
            File csv_user = new File("user.csv");
            data = new ArrayList<String>();
            BufferedReader br = new BufferedReader(new FileReader(csv));
            BufferedReader bru = new BufferedReader(new FileReader(csv_user));
            String line = "";
            String line_u = "";
            while((line_u = bru.readLine()) != null){
                String [] token = line.split(",", -1);
                if(token[0].equals(uid)) user_exist = true;
            }
            if(user_exist == false) return data;
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
            File csv_user = new File("user.csv");
            read_bwuser = new BufferedReader(new FileReader(csv_user));
            bwuser = new BufferedWriter(new FileWriter(csv_user,true));
            String line ="";
            while((line = read_bwuser.readLine()) != null){
                String[] token = line.split(",", -1);
                if(token[0].equals(uid)){
                    return "{\"result\":"+result+"\"}";
                }
            }
            bwuser.write(uid);
            bwuser.write(',');
            bwuser.write(pwd);
            bwuser.write('\n');
            result = "SUCCESS";
            bwuser.flush();
            bwuser.close();
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
            File csv_write = new File("ratings.csv");
            File csv_user = new File("Users.csv");
            File csv = new File("movies.csv");
            bwuser = new BufferedWriter(new FileWriter(csv_user));
            bw = new BufferedWriter(new FileWriter(csv_write,true));
            BufferedReader brd = new BufferedReader((new FileReader(csv_write)));

            BufferedReader br = new BufferedReader(new FileReader(csv));
            String line = "";
            String d_line = "";

            String s_rating = new String(Integer.toString(rating));
            while ((line = br.readLine()) != null){
                String[] token = line.split(",", -1);
                if(token[0].equals(movie_id))
                {
                    bw.write(uid);
                    bw.write(',');
                    bw.write(movie_id);
                    bw.write(',');
                    bw.write(s_rating);
                    bw.write(',');
                    bw.write('\n');
                    result = "SUCCESS";
                    bw.flush();
                    bw.close();
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
        try{
            File csv_user = new File("Users.csv");
            read_bwuser = new BufferedReader(new FileReader(csv_user));
            bwuser = new BufferedWriter(new FileWriter(csv_user,true));
            String buffer = "";
            while((buffer = read_bwuser.readLine()) != null){
                String[] token = buffer.split(",", -1);
            }
        } catch(FileNotFoundException e){

        } catch(IOException e){

        }
        if((repository.existsById(uid))) {
            repository.deleteById(uid);
            result = "SUCCESS";
        }
        return "{\"result\":\"" + result + "\"}";
    }
}
