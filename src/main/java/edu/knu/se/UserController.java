package edu.knu.se;
import java.io.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.*;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
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
        Path path = Paths.get("user.csv");
        Charset cs = StandardCharsets.UTF_8;
        ArrayList<User> result = new ArrayList<>();
        List<String> list = new ArrayList<String>();
        User temp;

        try{
            list = Files.readAllLines(path,cs);
        }catch(IOException e){
            e.printStackTrace();
        }

        String[] data;
        for(int i = 0 ; i < list.size(); i++){
            data = list.get(i).split(",");
            // System.out.println(list.get(i));
            // System.out.println(data);
            if (i != 0) {
                temp = new User(data[0], data[1], null, null);
                result.add(temp);
            }
        }
        // return result;
        return result;
    }

    @GetMapping("/_count_")
    int count(){
        Path path = Paths.get("user.csv");
        Charset cs = StandardCharsets.UTF_8;
        ArrayList<User> result = new ArrayList<>();
        List<String> list = new ArrayList<String>();
        User temp;

        try{
            list = Files.readAllLines(path,cs);
        }catch(IOException e){
            e.printStackTrace();
        }

        String[] data;
        for(int i = 0 ; i < list.size(); i++){
            data = list.get(i).split(",");
            if (i != 0) {
                temp = new User(data[0], data[1], null, null);
                result.add(temp);
            }
        }

        int size = list.size() - 1;
        if(size == -1) size = 0;
        return size;
    }

    @GetMapping("/{userid}/ratings") // rating만 뜨도록 설정 완료
    List<String> return_movie(@PathVariable(name = "userid") String uid){
        try {
            File csv = new File("ratings.csv");
            data = new ArrayList<String>();
            BufferedReader br = new BufferedReader(new FileReader(csv));
            String line = "";
            while ((line = br.readLine()) != null){
                String[] token = line.split(",", -1);
                if(token[0].equals(uid))
                {
                    data.add(token[2]);
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
        List<String> list = new ArrayList<String>();

        try{
            File file = new File("user.csv");
            FileReader filereader = new FileReader(file);
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = "";
            while((line = bufReader.readLine()) != null){
                list.add(line);
            }
            bufReader.close();
        }catch (FileNotFoundException e) {
            return "{\"result\":"+result+"\"}";
        }catch(IOException e){
            return "{\"result\":"+result+"\"}";
        }

        String[] data;
        for(int i = 0 ; i < list.size(); i++){ // list에 있는 string의 data를 추출해서 uid를 비교
            data = list.get(i).split(",");
            if (uid.equals(data[0])) { // 같은 게 있으면 안됨
                return "{\"result\":"+result+"\"}";
            }
        }

        list.add(uid + "," + pwd);
        // 필요하면 add하고 sort까지 넣을 것

        try{
            File file = new File("user.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

            if(file.isFile() && file.canWrite()){
                for(int i = 0; i < list.size() ; i++) {
                    bufferedWriter.write(list.get(i));
                    bufferedWriter.newLine();
                }
                bufferedWriter.flush();
                bufferedWriter.close();
            }
        } catch (IOException e) {
            return "{\"result\":"+result+"\"}";
        }

        result = "SUCCESS";
        return "{\"result\":"+result+"\"}";
    }

    @PutMapping("/{uid}/ratings")
    String putRating(@PathVariable("uid")String uid,@RequestParam("movie") String movie_id,@RequestParam("rating") float rating){
        String result = "FAILED";
        List<String> movielist = new ArrayList<String>();

        if(!(rating >= 1 && rating <= 5)) return "{\"result\":"+result+"\"}";

        if((rating%0.5) != 0.0) return "{\"result\":"+result+"\"}";

        try{
            File file = new File("user.csv");
            FileReader filereader = new FileReader(file);
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = "";
            while((line = bufReader.readLine()) != null){
                movielist.add(line);
            }
            bufReader.close();
        }catch (FileNotFoundException e) {
            return "{\"result\":\"" + result + "\"}";
        }catch(IOException e){
            return "{\"result\":\"" + result + "\"}";
        }

        try {
            File csv_write = new File("ratings.csv");
            File csv = new File("movies.csv");
            bw = new BufferedWriter(new FileWriter(csv_write,true));
            BufferedReader brd = new BufferedReader((new FileReader(csv_write)));

            BufferedReader br = new BufferedReader(new FileReader(csv));
            String line = "";
            String d_line = "";

            String s_rating = new String(Float.toString(rating));
            while ((line = br.readLine()) != null){
                String[] token = line.split(",", -1);
                if(token[1].equals(movie_id) && token[0].equals(uid)) return "{\"result\":"+"FAILED"+"\"}";
                if(token[1].equals(movie_id)) {
                    bw.write(uid);
                    bw.write(',');
                    bw.write(movie_id);
                    bw.write(',');
                    bw.write(s_rating);
                    bw.write(',');
                    long temp = new Timestamp(System.currentTimeMillis()).getTime();
                    bw.write(Long.toString(temp / 1000));
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

        return "{\"result\":"+result+"\"}";
    }


    @DeleteMapping("/{userid}")
    String deleteUid(@PathVariable(name="userid") String uid) throws FileNotFoundException {
        String result = "FAILED";

        List<String> list = new ArrayList<String>();

        System.out.println("Starting Delete. Loading File");
        try{
            File file = new File("user.csv");
            FileReader filereader = new FileReader(file);
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = "";
            while((line = bufReader.readLine()) != null){
                list.add(line);
            }
            bufReader.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
            return "{\"result\":\"" + result + "\"}";
        }catch(IOException e){
            e.printStackTrace();
            return "{\"result\":\"" + result + "\"}";
        }

        String[] data;
        for(int i = 0 ; i < list.size(); i++){ // list에 있는 string의 data를 추출해서 uid를 비교
            data = list.get(i).split(",");
            if (uid.equals(data[0])) { // 같은 게 있으면 제거
                result = "SUCCESS";
                list.remove(i);
                break;
            }
        }

        try{
            File file = new File("user.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

            if(file.isFile() && file.canWrite()){
                for(int i = 0; i < list.size() ; i++) {
                    bufferedWriter.write(list.get(i));
                    bufferedWriter.newLine();
                }
                bufferedWriter.flush();
                bufferedWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "{\"result\":\"" + "FAILED" + "\"}";
        }

        return "{\"result\":\"" + result + "\"}";
    }
}
