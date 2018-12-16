import java.util.*;
import java.lang.String;

public class Main {
    public static void main(String[] args) {
        // ! remove this to make input from input.txt
        String[] branchArray = new String[]{"K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2", "K1\\SK1",
                "K1\\SK2", "K1\\SK1\\SSK1",};

        List<String> branchArraySorted = SortBranchArray(branchArray);

        System.out.println(branchArraySorted);
        // [K2, K2\SK1, K2\SK1\SSK2, K2\SK1\SSK1, K1, K1\SK2, K1\SK1, K1\SK1\SSK2, K1\SK1\SSK1]
    }

    private static List<String> SortBranchArray(String[] branchArray) {
        HashSet<String> branchHashSet = new HashSet<>();
        String delimiter = "\\";

        for (String element : branchArray) {
            String[] branchOfficesSplit = element.split("\\\\");
            String office = branchOfficesSplit[0];
            branchHashSet.add(office);

            for (int i = 1; i < branchOfficesSplit.length; i++) {
                office = office + delimiter + branchOfficesSplit[i];
                branchHashSet.add(office);
            }
        }

        List<String> branchList = new ArrayList<>(branchHashSet);

        BranchComparator branchComparator = new BranchComparator();
        Collections.sort(branchList, branchComparator.branchComparator);
        return branchList;
    }
}
