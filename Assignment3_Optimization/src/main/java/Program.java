import utils.Timer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static java.util.stream.Collectors.toMap;

/**
 * This is our optimized implementation
 */
public class Program {
    // Original program
    public void runOriginal() throws FileNotFoundException, IOException {
        String fileName = "src/main/resources/FoundationSeries.txt";
        Reader reader = new FileReader(fileName);
        Map<Integer, Long> freq = new HashMap<>();
        tallyChars(reader, freq);
        print_tally(freq);
    }

    private void tallyChars(Reader reader, Map<Integer, Long> freq) throws IOException {
        int b;
        while ((b = reader.read()) != -1) {
            try {
                freq.put(b, freq.get(b) + 1);
            } catch (NullPointerException np) {
                freq.put(b, 1L);
            }
        }
    }

    private void tallyChars_optimized(String reader, Map<Integer, Long> freq)  {
//        int b;
//        while ((b = reader.read()) != -1) {
//            freq.put(b, freq.getOrDefault(b, 0L) + 1);
//        }
        for (int i = 0; i < reader.length(); i++) {
            int b = reader.charAt(i);
            freq.put(b, freq.getOrDefault(b, 0L) + 1);
        }
    }

    private void print_tally_optimized(Map<Integer, Long> freq) {
        int dist = 'a' - 'A';

        List<Map.Entry<Character, Long>> list = new ArrayList<>();
        for (Character c = 'A'; c <= 'Z'; c++) {
            list.add(new AbstractMap.SimpleEntry<>(c, freq.getOrDefault(c, 0L) + freq.getOrDefault(c + dist, 0L)));
        }
        list.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
//        for (Map.Entry entry : list) {
//            System.out.println("" + entry.getKey() + ": " + entry.getValue());;
//        }
    }

    private void print_tally(Map<Integer, Long> freq) {
        int dist = 'a' - 'A';
        Map<Character, Long> upperAndlower = new LinkedHashMap();
        for (Character c = 'A'; c <= 'Z'; c++) {
            upperAndlower.put(c, freq.getOrDefault(c, 0L) + freq.getOrDefault(c + dist, 0L));
        }
        Map<Character, Long> sorted = upperAndlower
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));
//        for (Character c : sorted.keySet()) {
//            System.out.println("" + c + ": " + sorted.get(c));;
//        }
    }

    public void Mark5(boolean isOptimized) throws IOException {
        int n = 10, count = 1;
        double runningTime = 0.0, st = 0.0, sst = 0.0;
        do {
            count *= 2;
            st = sst = 0.0;
            for (int j = 0; j < n; j++) {
                Timer t = new Timer();
                for (int i = 0; i < count; i++)
                    if(isOptimized) runOptimized();
                    else runOriginal();
                    runningTime = t.check();
                double time = runningTime * 1e9 / count;
                st += time;
                sst += time * time;
            }
            double mean = st / n, sdev = Math.sqrt((sst - mean * mean * n) / (n - 1));
            System.out.printf("%6.1f ns +/- %8.2f %10d%n", mean, sdev, count);
            // runningTime < 0.25 <-- original value in below while loop
        } while (runningTime < 1 && count < Integer.MAX_VALUE / 2);
    }
    
    // Optimized program
    private void runOptimized() throws IOException {
        //call optimized methods from here, just as in runOriginal() further above
        String fileName = "src/main/resources/FoundationSeries.txt";
//        Reader reader = new BufferedReader(new FileReader(fileName));
        Map<Integer, Long> freq = new HashMap<>();
        Files.lines(Paths.get(fileName)).forEach(line -> tallyChars_optimized(line, freq));
//        tallyChars_optimized(reader, freq);
        print_tally_optimized(freq);
    }


    public static void main(String[] args) throws IOException {
        Program program = new Program();
        // false runs the original program i.e. runOriginal()
        // true runs the optimized program i.e. runOptimized()
        program.Mark5(true);
        //program.runOptimized();
    }
}
