class CharacterSorter {

    String sort(String sentence) throws Exception {
        if (sentence == null || sentence.length() == 0) { throw new Exception("String cannot be null or empty"); }
        String everythingButLettersAndNumbersRegex = "[^A-Za-z]";

        char[] charArray = sentence
                .replaceAll(everythingButLettersAndNumbersRegex, "")
                .toLowerCase()
                .toCharArray();

        quickSort(charArray, 0, charArray.length -1);

        return new String(charArray);
    }

    // Best case time complexity is O(nlogn)
    // Worst case time complexity is O(n^2). In my case this is unlikely, but it is still possible.
    private void quickSort(char[] array, int start, int end) {
        // Make sure the start is less than the end to avoid issues when sorting
        if (start >= end) return;

        // pick the pivot
        int middle = start + (end - start) / 2;
        int pivot = array[middle];

        // partition the two halves based on the pivot
        int i = start, j = end;
        while (i <= j) {
            while (array[i] < pivot) { i++; }
            while (array[j] > pivot) { j--; }

            if (i <= j) {
                char temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // finish sorting the two halves
        if (start < j) quickSort(array, start, j);
        if (end > i) quickSort(array, i, end);
    }
}
