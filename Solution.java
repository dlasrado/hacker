import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main (String[] args) {

        System.out.println("Please provide the path for the CSV file.\n" +
                "(The CSV file should have 2 columns with NO header)\n" +
                "First column is Username and Second column is path accessed");

        Scanner in = new Scanner(System.in);
        String fileName = in.nextLine();

        List<List<String>> userAccessPaths = getStringArrayFromCSV(fileName);

        System.out.println("How many top ranked entries are you interested in?");
        int n = in.nextInt();

        Map<String, Integer> finalMap = new Solution().getTopNFrequentPaths(userAccessPaths, n);
        System.out.println("Path pattern\tCount");
        finalMap.forEach((k, v) -> System.out.println((k + "\t" + v)));
    }

    public Map<String, Integer> getTopNFrequentPaths(List<List<String>> userAccessPaths, int n) {

        Map<String, Queue<String>> usersPathMap = new HashMap<>();
        Map<String, Integer> successivePathMap = new HashMap<>();
        int numberOfPaths = 3; //Hard coded as the requirement is 3. But this one can be dynamic

        userAccessPaths.forEach(userAccessPath -> {
            String successivePath = getSuccessivePath(usersPathMap, userAccessPath, numberOfPaths);

            if (successivePath != null) {
                registerSuccessivePath(successivePathMap, successivePath);
            }
        });

        Map<String, Integer> topN =
                successivePathMap.entrySet().stream()
                        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                        .limit(n)
                        .collect(Collectors.toMap(
                            Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return topN;
    }

    private String getSuccessivePath (Map<String, Queue<String>> usersPathMap, List<String> userAccessPath, int n) {

        String successivePath = null;
        String user = userAccessPath.get(0);
        Queue<String> userPathList = null;

        if (!usersPathMap.containsKey(user)) {
            userPathList = new LinkedList<>();
            usersPathMap.put(user, userPathList);
        } else {
            userPathList = usersPathMap.get(user);
        }
        userPathList.add(userAccessPath.get(1));
        if (userPathList.size() == n) {
            successivePath = userPathList.stream().map(paths -> paths).collect(Collectors.joining("->"));
        }
        while (userPathList.size() > n-1)
            userPathList.poll(); //We dont need this element anymore
        return successivePath;
    }

    private void registerSuccessivePath(Map<String, Integer> successivePathMap, String successivePath) {

        if(successivePathMap.containsKey(successivePath)) {
            successivePathMap.put(successivePath, successivePathMap.get(successivePath)+1);
        } else {
            successivePathMap.put(successivePath, 1);
        }
    }

    private static List<List<String>> getStringArrayFromCSV(String fileName) {

        File file= new File(fileName);
        if (!"csv".equals(fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase())) {
            System.out.println("Please provide a CSV file :"+ fileName);
            System.exit(0);
        }

        // this gives you a 2-dimensional array of strings
        List<List<String>> lines = new ArrayList<>();

        try (Scanner inputStream = new Scanner(file)){

            while(inputStream.hasNext()){
                String line= inputStream.next();
                String[] values = line.split(",");
                // this adds the currently parsed line to the 2-dimensional string array
                lines.add(Arrays.asList(values));
            }

        }catch (FileNotFoundException e) {
            System.out.println("File is not found. Please specify the exact path. "+ e.getMessage());
            e.printStackTrace();
            System.exit(0);
        }
        return lines;
    }
}
