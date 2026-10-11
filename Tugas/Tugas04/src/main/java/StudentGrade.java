
public class StudentGrade {

    public static String calculateGrade(int score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException(
                "Nilai harus antara 0 sampai 100"
            );
        }

        if (score >= 80) return "A";
        if (score >= 70) return "B";
        if (score >= 60) return "C";
        if (score >= 50) return "D";

        return "E";
    }

    public static boolean isPassed(int score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException(
                "Nilai harus antara 0 sampai 100"
            );
        }

        return score >= 60;
    }
}
