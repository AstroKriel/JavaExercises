package junit.BioLibrary;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;
import java.util.Random;

public class BioLibraryTests {
    private static Random random = new Random();
    Sequence Sequence;

    @BeforeEach
    public void setUp() {
        Sequence = null;
    }

    @Test
    public void TestDNA_Sequence_RightInputs() {
        // Variables being compared
        String expectedMessage = "";
        String message = "";
        // Parameters passed to "Sequence" constructor
        String sequence = "ACGT";
        Type type = Type.DNA;
        // Running test
        try {
            Sequence = new Sequence(sequence, type);
        } catch (Exception e) {
            message = e.getMessage();
        }
        // Comparing result of the test
        assertEquals(expectedMessage, message);
    }
    @Test
    public void TestDNA_Sequence_WrongInputsException() {
        // Variables being compared
        String expectedMessage = "DNA must contain only the letters A, C, G, and T.";
        String message = "";
        // Parameters passed to "Sequence" constructor
        String sequence = "TEST";
        Type type = Type.DNA;
        // Running test
        try {
            Sequence = new Sequence(sequence, type);
        } catch (Exception e) {
            message = e.getMessage();
        }
        // Comparing result of the test
        assertEquals(expectedMessage, message);
    }
    @Test
    public void TestDNA_toString_RightInputs() {
        // Unused exception message
        String message = "";
        // Parameters passed to "Sequence" constructor
        String sequence = "ACGT";
        Type type = Type.DNA;
        // Running Sequence constructor
        try {
            Sequence = new Sequence(sequence, type);
        } catch (Exception e) {
            message = e.getMessage(); // TODO: unused exception message
        }
        if (message.equals("")) {
            assertEquals(sequence, Sequence.toString());
        }
    }
    @Test
    public void TestDNA_getType_RightInputs() {
        String message = "";
        // Parameters passed to "Sequence" constructor
        String sequence = "ACGT";
        Type type = Type.DNA;
        // Running Sequence constructor
        try {
            Sequence = new Sequence(sequence, type);
        } catch (Exception e) {
            message = e.getMessage(); // TODO: unused exception message
        }
        if (message.equals("")) {
            assertEquals(type, Sequence.getType());
        }
    }
    @Test
    public void TestDNA_reverseComplement_RightInputs() {
        // Variables being compared
        String expectedCompliment = "TGCA";
        // Unused message
        String message = "";
        // Parameters passed to "Sequence" constructor
        String sequence = "ACGT";
        Type type = Type.DNA;
        // Instantiate Sequence
        try {
            Sequence = new Sequence(sequence, type);
        } catch (Exception e) {
            message = e.getMessage();
        }
        // If no exception thrown, then continue
        if (message.equals("")) {
            try {
                Sequence.reverseComplement();
            } catch (Exception e) {
                message = e.getMessage();
            }
            if (message.equals("")) {
                assertEquals(expectedCompliment, Sequence.toString());
            }
        }
    }
    @Test
    public void TestDNA_palindrome() {
        // Variables being compared
        Boolean expectedPalindrome = Boolean.TRUE;
        Boolean outputPalindrome = Boolean.FALSE;
        // Unused message
        String message = "";
        // Parameters passed to "Sequence" constructor
        String sequence = "ACCTAGGT";
        Type type = Type.DNA;
        // Instantiate Sequence
        try {
            Sequence = new Sequence(sequence, type);
        } catch (Exception e) {
            message = e.getMessage();
        }
        // If no exception thrown, then continue
        if (message.equals("")) {
            try {
                outputPalindrome = Sequence.palindrome();
            } catch (Exception e) {
                message = e.getMessage();
            }
            if (message.equals("")) {
                assertEquals(expectedPalindrome, outputPalindrome);
            }
        }
    }
    @Test
    public void TestDNA_transcribe_sequence() {
        // Expected output sequence
        String expectedSequence = "ACCUAGGU";
        // Unused message
        String message = "";
        // Parameters passed to "Sequence" constructor
        String sequence = "ACCTAGGT";
        Type type = Type.DNA;
        // Instantiate Sequence
        try {
            Sequence = new Sequence(sequence, type);
        } catch (Exception e) {
            message = e.getMessage();
        }
        // If no exception thrown, then continue
        if (message.equals("")) {
            try {
                Sequence.transcribe();
            } catch (Exception e) {
                message = e.getMessage();
            }
            if (message.equals("")) {
                assertEquals(expectedSequence, Sequence.toString());
            }
        }
    }
    @Test
    public void TestDNA_transcribe_type() {
        // Expected output sequence
        Type expectedType = Type.RNA;
        // Unused message
        String message = "";
        // Parameters passed to "Sequence" constructor
        String sequence = "ACCTAGGT";
        Type type = Type.DNA;
        // Instantiate Sequence
        try {
            Sequence = new Sequence(sequence, type);
        } catch (Exception e) {
            message = e.getMessage();
        }
        // If no exception thrown, then continue
        if (message.equals("")) {
            try {
                Sequence.transcribe();
            } catch (Exception e) {
                message = e.getMessage();
            }
            if (message.equals("")) {
                assertEquals(expectedType, Sequence.getType());
            }
        }
    }


    // NEW SET OF TESTS
    @Test
    public void TestDNA_Sequence_PeptideInput() {
        // Variables being compared
        String expectedMessage = "";
        String message = "";
        // Parameters passed to "Sequence" constructor
        String sequence = "TEST";
        Type type = Type.Peptide;
        // Running test
        try {
            Sequence = new Sequence(sequence, type);
        } catch (Exception e) {
            message = e.getMessage();
        }
        // Comparing result of the test
        assertEquals(expectedMessage, message);
    }
    @Test
    public void Test_reverseComplement_PeptideInput() {
        // Variables being compared
        String expectedMessage = "Undefined sequence type for reverse complement.";
        // Unused message
        String message = "";
        // Parameters passed to "Sequence" constructor
        String sequence = "TEST";
        Type type = Type.Peptide;
        // Instantiate Sequence
        try {
            Sequence = new Sequence(sequence, type);
        } catch (Exception e) {
            message = e.getMessage();
        }
        // If no exception thrown, then continue
        if (message.equals("")) {
            try {
                Sequence.reverseComplement();
            } catch (Exception e) {
                message = e.getMessage();
            }
            assertEquals(expectedMessage, message);
        }
    }


    // NEW SET OF TESTS
    @Test
    public void TestRNA_Sequence_RightInputs() {
        // Variables being compared
        String expectedMessage = "";
        String message = "";
        // Parameters passed to "Sequence" constructor
        String sequence = "AUGC";
        Type type = Type.RNA;
        // Running test
        try {
            Sequence = new Sequence(sequence, type);
        } catch (Exception e) {
            message = e.getMessage();
        }
        // Comparing result of the test
        assertEquals(expectedMessage, message);
    }
    @Test
    public void TestRNA_Sequence_WrongInputsException() {
        // Variables being compared
        String expectedMessage = "RNA must contain only the letters A, U, G, and C.";
        String message = "";
        // Parameters passed to "Sequence" constructor
        String sequence = "TEST";
        Type type = Type.RNA;
        // Running test
        try {
            Sequence = new Sequence(sequence, type);
        } catch (Exception e) {
            message = e.getMessage();
        }
        // Comparing result of the test
        assertEquals(expectedMessage, message);
    }
    @Test
    public void TestRNA_toString_RightInputs() {
        // Unused exception message
        String message = "";
        // Parameters passed to "Sequence" constructor
        String sequence = "AUGC";
        Type type = Type.RNA;
        // Running Sequence constructor
        try {
            Sequence = new Sequence(sequence, type);
        } catch (Exception e) {
            message = e.getMessage(); // TODO: unused exception message
        }
        if (message.equals("")) {
            assertEquals(sequence, Sequence.toString());
        }
    }
    @Test
    public void TestRNA_getType_RightInputs() {
        String message = "";
        // Parameters passed to "Sequence" constructor
        String sequence = "AUGC";
        Type type = Type.RNA;
        // Running Sequence constructor
        try {
            Sequence = new Sequence(sequence, type);
        } catch (Exception e) {
            message = e.getMessage(); // TODO: unused exception message
        }
        if (message.equals("")) {
            assertEquals(type, Sequence.getType());
        }
    }
    @Test
    public void TestRNA_reverseComplement_RightInputs() {
        // Variables being compared
        String expectedCompliment = "UACG";
        // Unused message
        String message = "";
        // Parameters passed to "Sequence" constructor
        String sequence = "AUGC";
        Type type = Type.RNA;
        // Instantiate Sequence
        try {
            Sequence = new Sequence(sequence, type);
        } catch (Exception e) {
            message = e.getMessage();
        }
        // If no exception thrown, then continue
        if (message.equals("")) {
            try {
                Sequence.reverseComplement();
            } catch (Exception e) {
                message = e.getMessage();
            }
            if (message.equals("")) {
                assertEquals(expectedCompliment, Sequence.toString());
            }
        }
    }
    @Test
    public void TestRNA_palindrome() {
        // Variables being compared
        Boolean expectedPalindrome = Boolean.FALSE;
        Boolean outputPalindrome = Boolean.FALSE;
        // Unused message
        String message = "";
        // Parameters passed to "Sequence" constructor
        String sequence = "AUGC";
        Type type = Type.RNA;
        // Instantiate Sequence
        try {
            Sequence = new Sequence(sequence, type);
        } catch (Exception e) {
            message = e.getMessage();
        }
        // If no exception thrown, then continue
        if (message.equals("")) {
            try {
                outputPalindrome = Sequence.palindrome();
            } catch (Exception e) {
                message = e.getMessage();
            }
            if (message.equals("")) {
                assertEquals(expectedPalindrome, outputPalindrome);
            }
        }
    }
    @Test
    public void TestRNA_transcribe_sequence() {
        // Expected output sequence
        String expectedSequence = "ATGC";
        // Unused message
        String message = "";
        // Parameters passed to "Sequence" constructor
        String sequence = "AUGC";
        Type type = Type.RNA;
        // Instantiate Sequence
        try {
            Sequence = new Sequence(sequence, type);
        } catch (Exception e) {
            message = e.getMessage();
        }
        // If no exception thrown, then continue
        if (message.equals("")) {
            try {
                Sequence.transcribe();
            } catch (Exception e) {
                message = e.getMessage();
            }
            if (message.equals("")) {
                assertEquals(expectedSequence, Sequence.toString());
            }
        }
    }
    @Test
    public void TestRNA_transcribe_type() {
        // Expected output sequence
        Type expectedType = Type.DNA;
        // Unused message
        String message = "";
        // Parameters passed to "Sequence" constructor
        String sequence = "ACCTAGGT";
        Type type = Type.RNA;
        // Instantiate Sequence
        try {
            Sequence = new Sequence(sequence, type);
        } catch (Exception e) {
            message = e.getMessage();
        }
        // If no exception thrown, then continue
        if (message.equals("")) {
            try {
                Sequence.transcribe();
            } catch (Exception e) {
                message = e.getMessage();
            }
            if (message.equals("")) {
                assertEquals(expectedType, Sequence.getType());
            }
        }
    }
}
