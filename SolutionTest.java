import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * A test class to test the homework solution
 * Not using JUnit inorder to avoid any external libraries other than default Java8 libraries.
 */
public class SolutionTest {

    /*
    Get top 2 frequent paths based on a 2D string array.
     */
    public static void testGetTopNFrequentPaths() {

        /*{{"U1","/"},{"U1","/login"},{"U1","/home"},
                {"U2","/"},{"U2","/login"},{"U2","/dashboard"},
                {"U1","/"},{"U3","/"},{"U3","/login"},{"U3","/dashboard"},
                {"U1","/login"},{"U1","/home"},{"U1","/dashboard"},
                {"U4","/"},{"U4","/login"},{"U4","/dashboard"}}*/
        List<List<String>> userPaths = new ArrayList<>();
        userPaths.add(Arrays.asList(new String[]{"U1","/"}));
        userPaths.add(Arrays.asList(new String[]{"U1","/login"}));
        userPaths.add(Arrays.asList(new String[]{"U1","/home"}));
        userPaths.add(Arrays.asList(new String[]{"U2","/"}));
        userPaths.add(Arrays.asList(new String[]{"U2","/login"}));
        userPaths.add(Arrays.asList(new String[]{"U2","/dashboard"}));
        userPaths.add(Arrays.asList(new String[]{"U1","/dashboard"}));
        userPaths.add(Arrays.asList(new String[]{"U3","/"}));
        userPaths.add(Arrays.asList(new String[]{"U3","/login"}));
        userPaths.add(Arrays.asList(new String[]{"U3","/dashboard"}));
        userPaths.add(Arrays.asList(new String[]{"U4","/"}));
        userPaths.add(Arrays.asList(new String[]{"U4","/login"}));
        userPaths.add(Arrays.asList(new String[]{"U4","/dashboard"}));
        userPaths.add(Arrays.asList(new String[]{"U1","/login"}));
        userPaths.add(Arrays.asList(new String[]{"U1","/home"}));
        userPaths.add(Arrays.asList(new String[]{"U1","/dashboard"}));

        Map<String, Integer> finalMap = new Solution().getTopNFrequentPaths(userPaths, 2);

        System.out.println("Path pattern\tCount");
        finalMap.forEach((k, v) -> System.out.println((k + "\t" + v)));
    }

    /*
    Get top 2 frequent paths based on a 2D string array.
     */
    public static void testGetTop3FrequentPaths() {

        /*{{"U1","/"},{"U1","/login"},{"U1","/home"},
                {"U2","/"},{"U2","/login"},{"U2","/dashboard"},
                {"U1","/"},{"U3","/"},{"U3","/login"},{"U3","/dashboard"},
                {"U1","/login"},{"U1","/home"},{"U1","/dashboard"},
                {"U4","/"},{"U4","/login"},{"U4","/dashboard"}}*/
        List<List<String>> userPaths = new ArrayList<>();
        userPaths.add(Arrays.asList(new String[]{"U1","/"}));
        userPaths.add(Arrays.asList(new String[]{"U1","/login"}));
        userPaths.add(Arrays.asList(new String[]{"U1","/home"}));
        userPaths.add(Arrays.asList(new String[]{"U1","/"}));
        userPaths.add(Arrays.asList(new String[]{"U1","/login"}));
        userPaths.add(Arrays.asList(new String[]{"U1","/dashboard"}));
        userPaths.add(Arrays.asList(new String[]{"U1","/dashboard"}));
        userPaths.add(Arrays.asList(new String[]{"U1","/"}));
        userPaths.add(Arrays.asList(new String[]{"U1","/login"}));
        userPaths.add(Arrays.asList(new String[]{"U1","/dashboard"}));
        userPaths.add(Arrays.asList(new String[]{"U4","/"}));
        userPaths.add(Arrays.asList(new String[]{"U4","/login"}));
        userPaths.add(Arrays.asList(new String[]{"U4","/dashboard"}));
        userPaths.add(Arrays.asList(new String[]{"U1","/login"}));
        userPaths.add(Arrays.asList(new String[]{"U1","/home"}));
        userPaths.add(Arrays.asList(new String[]{"U1","/dashboard"}));

        Map<String, Integer> finalMap = new Solution().getTopNFrequentPaths(userPaths, 2);

        System.out.println("Path pattern\tCount");
        finalMap.forEach((k, v) -> System.out.println((k + "\t" + v)));
    }

    /*
    Get top 2 frequent paths based on a 2D string array.
     */
    public static void testWithNullPaths() {

        /*{{"U1","/"},{"U1","/login"},{"U1","/home"},
                {"U2","/"},{"U2","/login"},{"U2","/dashboard"},
                {"U1","/"},{"U3","/"},{"U3","/login"},{"U3","/dashboard"},
                {"U1","/login"},{"U1","/home"},{"U1","/dashboard"},
                {"U4","/"},{"U4","/login"},{"U4","/dashboard"}}*/
        List<List<String>> userPaths = new ArrayList<>();
        userPaths.add(Arrays.asList(new String[]{"U1","/"}));
        userPaths.add(Arrays.asList(new String[]{"U1","/login"}));
        userPaths.add(Arrays.asList(new String[]{"U1","/home"}));
        userPaths.add(Arrays.asList(new String[]{"U1","/"}));
        userPaths.add(Arrays.asList(new String[]{"U1","/login"}));
        userPaths.add(Arrays.asList(new String[]{"U1","/dashboard"}));
        userPaths.add(Arrays.asList(new String[]{"U1","/dashboard"}));
        userPaths.add(Arrays.asList(new String[]{"U1","/"}));
        userPaths.add(Arrays.asList(new String[]{"U1",null}));
        userPaths.add(Arrays.asList(new String[]{"U1","/dashboard"}));
        userPaths.add(Arrays.asList(new String[]{"U4","/"}));
        userPaths.add(Arrays.asList(new String[]{"U4","/login"}));
        userPaths.add(Arrays.asList(new String[]{"U4","/dashboard"}));
        userPaths.add(Arrays.asList(new String[]{"U1","/login"}));
        userPaths.add(Arrays.asList(new String[]{"U1","/home"}));
        userPaths.add(Arrays.asList(new String[]{"U1","/dashboard"}));

        Map<String, Integer> finalMap = new Solution().getTopNFrequentPaths(userPaths, 2);

        System.out.println("Path pattern\tCount");
        finalMap.forEach((k, v) -> System.out.println((k + "\t" + v)));
    }

    /*
    Get top 2 frequent paths based on a 2D string array.
     */
    public static void testWithRepeatedPaths() {

        /*{{"U1","/"},{"U1","/login"},{"U1","/home"},
                {"U2","/"},{"U2","/login"},{"U2","/dashboard"},
                {"U1","/"},{"U3","/"},{"U3","/login"},{"U3","/dashboard"},
                {"U1","/login"},{"U1","/home"},{"U1","/dashboard"},
                {"U4","/"},{"U4","/login"},{"U4","/dashboard"}}*/
        List<List<String>> userPaths = new ArrayList<>();
        userPaths.add(Arrays.asList(new String[]{"U1","/"}));
        userPaths.add(Arrays.asList(new String[]{"U1","/login"}));
        userPaths.add(Arrays.asList(new String[]{"U1","/home"}));
        userPaths.add(Arrays.asList(new String[]{"U1","/home"}));
        userPaths.add(Arrays.asList(new String[]{"U1","/home"}));
        userPaths.add(Arrays.asList(new String[]{"U1","/home"}));
        userPaths.add(Arrays.asList(new String[]{"U1","/home"}));
        userPaths.add(Arrays.asList(new String[]{"U1","/home"}));
        userPaths.add(Arrays.asList(new String[]{"U1","/home"}));
        userPaths.add(Arrays.asList(new String[]{"U1","/home"}));
        userPaths.add(Arrays.asList(new String[]{"U4","/"}));
        userPaths.add(Arrays.asList(new String[]{"U4","/login"}));
        userPaths.add(Arrays.asList(new String[]{"U4","/dashboard"}));
        userPaths.add(Arrays.asList(new String[]{"U1","/home"}));
        userPaths.add(Arrays.asList(new String[]{"U1","/home"}));
        userPaths.add(Arrays.asList(new String[]{"U1","/home"}));

        Map<String, Integer> finalMap = new Solution().getTopNFrequentPaths(userPaths, 2);

        System.out.println("Path pattern\tCount");
        finalMap.forEach((k, v) -> System.out.println((k + "\t" + v)));
    }

    public static void main(String[] args) {
        System.out.println("************* testGetTopNFrequentPaths*************");
        testGetTopNFrequentPaths();
        System.out.println("*************testGetTop3FrequentPaths*************");
        testGetTop3FrequentPaths();
        System.out.println("*************testWithNullPaths*************");
        testWithNullPaths();
        System.out.println("*************testWithRepeatedPaths*************");
        testWithRepeatedPaths();
    }
}
