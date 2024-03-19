import java.util.Scanner;

class CalculateTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите выражение:");
        String line = sc.nextLine();
        String result;
        try {
            result = calc(line);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return;
        }
        System.out.println(result);
    }

    private static String calc(String line) throws Exception {
        String[] s = line.split(" ");
        if (s.length == 1){
            throw new Exception("Cтрока не является математической операцией");
        }
        if (s.length > 3){
            throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[2]);
        if (a > 10 || b > 10) {
            throw new Exception("Один из аргументов больше 10");
        }
        int result = switch (s[1]) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> {
                if (b == 0) {
                    throw new Exception("На ноль делить нельзя");
                }
                yield a / b;
            }
            default -> throw new IllegalStateException("Указанная операция не поддерживается калькулятором: " + s[1]);
        };
        return String.valueOf(result);
    }
}

