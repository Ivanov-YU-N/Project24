import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[] ids = {1, 2, 3, 4, 5};
        ArrayList<Toy> toys = new ArrayList<>();
        for (int i = 0; i < ids.length; i++) {
            Random rand = new Random();
            int rand1 = rand.nextInt(30,100);
            System.out.println("Input to name toy");
            Scanner console = new Scanner(System.in);
            String name1 = console.nextLine();
            Toy toy = new Toy(ids[i], name1, rand1);
            toys.add(toy);
        }


        System.out.println();

        Iterator iterator = toys.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next() + " ");

        }


        String fileName = "result.txt";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))){
            for(Toy toy: toys){
                writer.write(String.format("%d, название %s частота выподания %d",
                 toy.getId(), toy.getName(), toy.getFrequency()));
            }
        } catch (IOException e) {
            System.err.format("IOExeption %d%s%d" + e);
        }
    }
}
