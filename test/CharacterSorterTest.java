import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CharacterSorterTest {

    @Test
    void testCharacterSorterSortsSingleWords() {
        String word = "word";
        CharacterSorter characterSorter = new CharacterSorter();
        assertEquals("dorw", characterSorter.sort(word), "Not sorted correctly");
    }

    @Test
    void testCharacterSorterSortsSentences() {
        String sentence = "This is a sentence.";
        CharacterSorter characterSorter = new CharacterSorter();
        assertEquals("aceeehiinnssstt", characterSorter.sort(sentence), "Not sorted correctly");
    }

    @Test
    void testCharacterSorterSortsAllyExampleString() {
        String allyExample = "When not studying nuclear physics, Bambi likes to play" +
                " beach volleyball.";
        CharacterSorter characterSorter = new CharacterSorter();
        assertEquals("aaaaabbbbcccdeeeeeghhhiiiiklllllllmnnnnooopprsssstttuuvwyyyy",
                characterSorter.sort(allyExample), "Not sorted correctly");
    }
}