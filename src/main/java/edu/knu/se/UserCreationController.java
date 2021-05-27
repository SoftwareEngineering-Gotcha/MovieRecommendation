package edu.knu.se;
import java.io.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.*;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@RestController
@RequestMapping("")
public class UserCreationController {

    @PutMapping("/{userid}")
    String NewputUser(@PathVariable(name="userid") String uid, @RequestParam(name="passwd") String pwd) {
        String result = "FAILED";
        List<String> list = new ArrayList<String>();

        try{
            File file = new File("user.csv");
            FileReader filereader = new FileReader(file);
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = "";
            while((line = bufReader.readLine()) != null){
                System.out.println(line);
                list.add(line);
            }
            bufReader.close();
        }catch (FileNotFoundException e) {
            // TODO: handle exception
        }catch(IOException e){
            System.out.println(e);
        }

        String[] data;
        for(int i = 0 ; i < list.size(); i++){ // list에 있는 string의 data를 추출해서 uid를 비교
            data = list.get(i).split(",");
            System.out.println(list.get(i));
            System.out.println(data[0] + "," + data[1]);
            if (uid.equals(data[0])) { // 같은 게 있으면 안됨
                return "{\"result\":"+result+"\"}";
            }
        }

        list.add(uid + "," + pwd);
        // 필요하면 add하고 sort까지 넣을 것
        result = "SUCCESS";

        try{
            File file = new File("user.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

            if(file.isFile() && file.canWrite()){
                for(int i = 0; i < list.size() ; i++) {
                    System.out.println(list.get(i));
                    bufferedWriter.write(list.get(i));
                    bufferedWriter.newLine();
                    System.out.println("Write Success");
                }
                bufferedWriter.flush();
                bufferedWriter.close();
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        return "{\"result\":"+result+"\"}";
    }
}
