class CharacterSorter {

    String sort(String sentence) {
        String everythingButLettersAndNumbersRegex = "[^A-Za-z0-9]";
        char[] charArray = sentence
                .replaceAll(everythingButLettersAndNumbersRegex, "")
                .toLowerCase()
                .toCharArray();
        quickSort(charArray, 0, charArray.length -1);
        return new String(charArray);
    }

    private void quickSort(char[] array, int start, int end) {
        // If there are any issues with the array, return, nothing to do.
        if (array == null || array.length == 0) return;
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
