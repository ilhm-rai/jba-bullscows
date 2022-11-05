package bullscows;

public class CodeGenerator {

    static String oldGenerateSecretCode(int length) {
        String pseudoRandomNumber = String.valueOf(System.nanoTime());
        int pseudoLength = pseudoRandomNumber.length();
        StringBuilder secretCode = new StringBuilder();
        while (secretCode.length() < length) {
            for (int i = pseudoLength - 1; secretCode.length() < length && i >= 0; i--) {
                char psch = pseudoRandomNumber.charAt(i);
                if (secretCode.indexOf(String.valueOf(psch)) == -1) {
                    if (!(secretCode.isEmpty() && psch == '0')) {
                        secretCode.append(Character.getNumericValue(psch));
                    }
                }
            }
            pseudoRandomNumber = String.valueOf(System.nanoTime());
        }
        return secretCode.toString();
    }

    static String generateSecretCode(int secretCodeLength, int possibleSymbolLength) {
        StringBuilder secretCode = new StringBuilder();
        int possibleSymbol = possibleSymbolLength - 10;
        while (secretCode.length() != secretCodeLength) {
            String number = String.valueOf((int) (Math.random() * 10));
            if (!secretCode.toString().contains(number)) {
                secretCode.append(number);
            }
            if (possibleSymbol > 0) {
                String symbol = Character.toString((char) ((Math.random() * (possibleSymbol)) + 97));
                if (!secretCode.toString().contains(symbol)) {
                    secretCode.append(symbol);
                }
            }
        }

        String stars = "*".repeat(secretCodeLength);
        StringBuilder symbol = new StringBuilder();

        if (possibleSymbolLength > 10) {
            symbol.append(", a");
        }
        if (possibleSymbolLength > 11) {
            String lastCh = Character.toString((char) (97 + possibleSymbol - 1));
            symbol.append("-").append(lastCh);
        }

        System.out.printf("The secret is prepared: %s (0-9%s).\n", stars, symbol);
        return secretCode.toString();
    }

}
