package bullscows;

public class Grader {

    static boolean validateAnswer(String secretCode, String answer) {
        int cows = 0;
        int bulls = 0;

        for (int i = 0; i < secretCode.length(); i++) {
            char as = answer.charAt(i);
            char sc = secretCode.charAt(i);
            if (as == sc) {
                bulls++;
            } else if (secretCode.contains(String.valueOf(as))) {
                cows++;
            }
        }

        String grade = findGrade(bulls, cows);
        System.out.printf("Grade: %s\n", grade);

        return bulls == secretCode.length();
    }

    static String findGrade(int bulls, int cows) {
        StringBuilder grade = new StringBuilder();
        if (bulls < 1 && cows < 1) {
            return "None";
        }

        if (bulls > 0) {
            grade.append(bulls).append(" bull(s)");
        }
        if (bulls > 0 && cows > 0) {
            grade.append(" and ");
        }
        if (cows > 0) {
            grade.append(cows).append(" cow(s)");
        }

        return grade.toString();
    }

}
