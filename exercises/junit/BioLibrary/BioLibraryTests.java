package junit.BioLibrary;

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

    /**
     Test: Sequence Method
     */
    // Test: correct inputs -> no error
    @Test
    public void Test_Sequence_RightInput_DNA() {
        String exp_message = "";
        String message = "";
        String sequence = "ACGT";
        Type type = Type.DNA;
        try {
            Sequence = new Sequence(sequence, type);
        } catch (Exception e) {
            message = e.getMessage();
        }
        assertEquals(exp_message, message);
    }
    @Test
    public void Test_Sequence_RightInput_RNA() {
        String exp_message = "";
        String message = "";
        String sequence = "AUGC";
        Type type = Type.RNA;
        try {
            Sequence = new Sequence(sequence, type);
        } catch (Exception e) {
            message = e.getMessage();
        }
        assertEquals(exp_message, message);
    }
    // Test: wrong sequence -> correct exception message
    @Test
    public void Test_Sequence_WrongSequence_DNA() {
        String exp_message = "DNA must contain only the letters A, C, G, and T.";
        String message = "";
        String sequence = "wrong input";
        Type type = Type.DNA;
        try {
            Sequence = new Sequence(sequence, type);
        } catch (Exception e) {
            message = e.getMessage();
        }
        assertEquals(exp_message, message);
    }
    @Test
    public void Test_Sequence_WrongSequence_RNA() {
        String exp_message = "RNA must contain only the letters A, U, G, and C.";
        String message = "";
        String sequence = "wrong input";
        Type type = Type.RNA;
        try {
            Sequence = new Sequence(sequence, type);
        } catch (Exception e) {
            message = e.getMessage();
        }
        assertEquals(exp_message, message);
    }
    // Test: no inputs -> correct exception message
    @Test
    public void Test_Sequence_MissingSequence_DNA() {
        String exp_message = "DNA must contain only the letters A, C, G, and T.";
        String message = "";
        String sequence = "";
        Type type = Type.DNA;
        try {
            Sequence = new Sequence(sequence, type);
        } catch (Exception e) {
            message = e.getMessage();
        }
        assertEquals(exp_message, message);
    }
    @Test
    public void Test_Sequence_MissingSequence_RNA() {
        String exp_message = "RNA must contain only the letters A, U, G, and C.";
        String message = "";
        String sequence = "";
        Type type = Type.RNA;
        try {
            Sequence = new Sequence(sequence, type);
        } catch (Exception e) {
            message = e.getMessage();
        }
        assertEquals(exp_message, message);
    }


    /**
     Test: toString Method
     */
    // Test: returns correct sequence
    @Test
    public void Test_toString_RightInput_DNA() {
        String message = "";
        String sequence = "ACGT";
        Type type = Type.DNA;
        try {
            Sequence = new Sequence(sequence, type);
        } catch (Exception e) {
            message = e.getMessage();
        }
        if (message.equals("")) {
            assertEquals(sequence, Sequence.toString());
        }
    }
    @Test
    public void Test_toString_RightInput_RNA() {
        String message = "";
        String sequence = "AUGC";
        Type type = Type.RNA;
        try {
            Sequence = new Sequence(sequence, type);
        } catch (Exception e) {
            message = e.getMessage();
        }
        if (message.equals("")) {
            assertEquals(sequence, Sequence.toString());
        }
    }

    /**
     Test: getType Method
     */
    // Test: returns correct type
    @Test
    public void Test_getType_RightInput_DNA() {
        String message = "";
        String sequence = "ACGT";
        Type type = Type.DNA;
        try {
            Sequence = new Sequence(sequence, type);
        } catch (Exception e) {
            message = e.getMessage();
        }
        if (message.equals("")) {
            assertEquals(type, Sequence.getType());
        }
    }
    @Test
    public void Test_getType_RightInput_RNA() {
        String message = "";
        String sequence = "AUGC";
        Type type = Type.RNA;
        try {
            Sequence = new Sequence(sequence, type);
        } catch (Exception e) {
            message = e.getMessage();
        }
        if (message.equals("")) {
            assertEquals(type, Sequence.getType());
        }
    }


    /**
     Test: reverseComplement Method
     */
    // Test: provided peptide -> throws correct exception
    @Test
    public void Test_reverseComplement_PeptideInput() {
        String exp_message = "Undefined sequence type for reverse complement.";
        String message = "";
        String sequence = "PEPTIDE";
        Type type = Type.Peptide;
        try {
            Sequence = new Sequence(sequence, type);
        } catch (Exception e) {
            message = e.getMessage();
        }
        if (message.equals("")) {
            try {
                Sequence.reverseComplement();
            } catch (Exception e) {
                message = e.getMessage();
            }
            assertEquals(exp_message, message);
        }
    }
    // Test: after running -> sequence is in fact compliment
    @Test
    public void Test_reverseComplement_RightInput_DNA() {
        String message = "";
        String exp_sequence = "TTAACCGG";
        String sequence = "AATTGGCC";
        Type type = Type.DNA;
        try {
            Sequence = new Sequence(sequence, type);
        } catch (Exception e) {
            message = e.getMessage();
        }
        if (message.equals("")) {
            try {
                Sequence.reverseComplement();
            } catch (Exception e) {
                message = e.getMessage();
            }
            if (message.equals("")) {
                assertEquals(exp_sequence, Sequence.toString());
            }
        }
    }
    @Test
    public void Test_reverseComplement_RightInput_RNA() {
        String message = "";
        String exp_sequence = "UUAACCGG";
        String sequence = "AAUUGGCC";
        Type type = Type.RNA;
        try {
            Sequence = new Sequence(sequence, type);
        } catch (Exception e) {
            message = e.getMessage();
        }
        if (message.equals("")) {
            try {
                Sequence.reverseComplement();
            } catch (Exception e) {
                message = e.getMessage();
            }
            if (message.equals("")) {
                assertEquals(exp_sequence, Sequence.toString());
            }
        }
    }


    /**
     Test: palindrome Method
     */
    // Test: sequence is palindrome -> return true
    @Test
    public void Test_palindrome_isPalindrome_DNA() {
        String message = "";
        Boolean out_palindrome = Boolean.FALSE;
        String sequence = "ACGT";
        Type type = Type.DNA;
        try {
            Sequence = new Sequence(sequence, type);
        } catch (Exception e) {
            message = e.getMessage();
        }
        if (message.equals("")) {
            try {
                out_palindrome = Sequence.palindrome();
            } catch (Exception e) {
                message = e.getMessage();
            }
            if (message.equals("")) {
                assertEquals(Boolean.TRUE, out_palindrome);
            }
        }
    }
    @Test
    public void Test_palindrome_isPalindrome_RNA() {
        String message = "";
        Boolean out_palindrome = Boolean.FALSE;
        String sequence = "AUAU";
        Type type = Type.RNA;
        try {
            Sequence = new Sequence(sequence, type);
        } catch (Exception e) {
            message = e.getMessage();
        }
        if (message.equals("")) {
            try {
                out_palindrome = Sequence.palindrome();
            } catch (Exception e) {
                message = e.getMessage();
            }
            if (message.equals("")) {
                assertEquals(Boolean.TRUE, out_palindrome);
            }
        }
    }
    // Test: sequence is not palindrome -> return false
    @Test
    public void Test_palindrome_notPalindrome_DNA() {
        String message = "";
        Boolean out_palindrome = Boolean.FALSE;
        String sequence = "AAAA";
        Type type = Type.DNA;
        try {
            Sequence = new Sequence(sequence, type);
        } catch (Exception e) {
            message = e.getMessage();
        }
        if (message.equals("")) {
            try {
                out_palindrome = Sequence.palindrome();
            } catch (Exception e) {
                message = e.getMessage();
            }
            if (message.equals("")) {
                assertEquals(Boolean.FALSE, out_palindrome);
            }
        }
    }
    @Test
    public void Test_palindrome_notPalindrome_RNA() {
        String message = "";
        Boolean out_palindrome = Boolean.FALSE;
        String sequence = "AAAA";
        Type type = Type.RNA;
        try {
            Sequence = new Sequence(sequence, type);
        } catch (Exception e) {
            message = e.getMessage();
        }
        if (message.equals("")) {
            try {
                out_palindrome = Sequence.palindrome();
            } catch (Exception e) {
                message = e.getMessage();
            }
            if (message.equals("")) {
                assertEquals(Boolean.FALSE, out_palindrome);
            }
        }
    }
    // Test: construction of reverse complement fails -> throws exception
    @Test
    public void Test_palindrome_PeptideInput() {
        String exp_message = "Undefined sequence type for reverse complement.";
        String message = "";
        String sequence = "PEPTIDE";
        Type type = Type.Peptide;
        try {
            Sequence = new Sequence(sequence, type);
        } catch (Exception e) {
            message = e.getMessage();
        }
        if (message.equals("")) {
            try {
                Sequence.palindrome();
            } catch (Exception e) {
                message = e.getMessage();
            }
            assertEquals(exp_message, message);
        }
    }

    /**
     Test: transcribe Method
     */
    // Test: after successful run -> type successfully changed
    @Test
    public void Test_transcribe_DNAtoRNA_type() {
        String message = "";
        String sequence = "AACCGGTT";
        Type exp_type = Type.RNA;
        Type type = Type.DNA;
        try {
            Sequence = new Sequence(sequence, type);
        } catch (Exception e) {
            message = e.getMessage();
        }
        if (message.equals("")) {
            try {
                Sequence.transcribe();
            } catch (Exception e) {
                message = e.getMessage();
            }
            if (message.equals("")) {
                assertEquals(exp_type, Sequence.getType());
            }
        }
    }
    @Test
    public void Test_transcribe_RNAtoDNA_type() {
        String message = "";
        String sequence = "AAUUGGCC";
        Type exp_type = Type.DNA;
        Type type = Type.RNA;
        try {
            Sequence = new Sequence(sequence, type);
        } catch (Exception e) {
            message = e.getMessage();
        }
        if (message.equals("")) {
            try {
                Sequence.transcribe();
            } catch (Exception e) {
                message = e.getMessage();
            }
            if (message.equals("")) {
                assertEquals(exp_type, Sequence.getType());
            }
        }
    }
    // Test: after successful run -> sequence successfully changed
    @Test
    public void Test_transcribe_DNAtoRNA_sequence() {
        String message = "";
        String exp_sequence = "AACCGGUU";
        String sequence = "AACCGGTT";
        Type type = Type.DNA;
        try {
            Sequence = new Sequence(sequence, type);
        } catch (Exception e) {
            message = e.getMessage();
        }
        if (message.equals("")) {
            try {
                Sequence.transcribe();
            } catch (Exception e) {
                message = e.getMessage();
            }
            if (message.equals("")) {
                assertEquals(exp_sequence, Sequence.toString());
            }
        }
    }
    @Test
    public void Test_transcribe_RNAtoDNA_sequence() {
        String message = "";
        String exp_sequence = "AATTGGCC";
        String sequence = "AAUUGGCC";
        Type type = Type.RNA;
        try {
            Sequence = new Sequence(sequence, type);
        } catch (Exception e) {
            message = e.getMessage();
        }
        if (message.equals("")) {
            try {
                Sequence.transcribe();
            } catch (Exception e) {
                message = e.getMessage();
            }
            if (message.equals("")) {
                assertEquals(exp_sequence, Sequence.toString());
            }
        }
    }
    // Test: type is not RNA or DNA -> throws exception
    @Test
    public void Test_transcribe_PeptideException() {
        String message = "";
        String exp_message = "Undefined sequence type for transcription.";
        String sequence = "PEPTIDE";
        Type type = Type.Peptide;
        try {
            Sequence = new Sequence(sequence, type);
        } catch (Exception e) {
            message = e.getMessage();
        }
        if (message.equals("")) {
            try {
                Sequence.transcribe();
            } catch (Exception e) {
                message = e.getMessage();
            }
            assertEquals(exp_message, message);
        }
    }
}
