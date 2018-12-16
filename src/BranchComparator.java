import java.util.Comparator;

class BranchComparator {
    Comparator<String> branchComparator = (branch1, branch2) -> {
        String[] branches1 = branch1.split("\\\\");
        String[] branches2 = branch2.split("\\\\");

        // to sort for task: 1 compare branches lengths (less length => higher level),
        // then compare last offices in branch
        int result = 0;
        for (int i = 0; i < branches1.length || i < branches2.length; i++) {
            if (i >= branches1.length) return -1;
            else if (i >= branches2.length) return 1;

            result = -1 * branches1[i].compareTo(branches2[i]);
            if (result != 0)
                return result;
        }
        return result;
    };
}