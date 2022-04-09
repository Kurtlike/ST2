package st.csv;


import java.io.*;
import java.util.ArrayList;

public class CsvWriter {
    public static void write(String path, ArrayList<Dot> dots){
        try {
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "utf-8"));
            try {
                writer.write("x;y\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
            dots.forEach((dot)->{
                try {
                    if(dot.y > 100) dot.y = 100;
                    if(dot.y < -100) dot.y = -100;
                    writer.write(dot.x + ";" + dot.y +"\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
                writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
