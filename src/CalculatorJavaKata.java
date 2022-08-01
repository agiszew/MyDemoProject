import java.util.*;
import java.lang.Exception;
import java.util.HashMap;
import java.util.Map.Entry;

public class CalculatorJavaKata {
    static String input;//Эта строка введенная пользователем уйдет в метод калькулятора
    static boolean isRomanOrNot1, isRomanOrNot2, isArabOrNot1, isArabOrNot2; //фиксация в какой системе чисел работаем
    static int result; //результат арифДействия (потом превратить его в стринг calcResultAsString и вернуть из метода calc)
    static int roman1, roman2, firstNumber, secondNumber;// рабочие числа
    static String calcResultAsString; //этот стринг с результатом вернется к нам из калька

    public static void main(String[] args) throws Exception {
        System.out.println("Это калькулятор который может работать с арабскими и римскими цифрами. " +
                "\nВажно! Оба числа должны быть от 1 до 10, и в одном формате, либо только арабскими или только римскими " +
                "\nПроводимые операции могут быть только следующими (+)(-)(*)(/)");
        Scanner scan = new Scanner(System.in);
        input = scan.nextLine(); //получаем строку от пользователя
        String resultStr = calc(input);// строку input отправляем в метод Calc,  ответ придет в resultString
        System.out.println("Результат вычислений равен: "+resultStr);//это полученный результат для отображения
    }
    public static String calc(String input) throws Exception {
        String scannerInput1 = input.replaceAll("\\s+", ""); /*удаляем случайно набранные пользователем
     пробелы для юзабилити*/
        String inputFinal = scannerInput1.toUpperCase(); // переводим все символы в верхний разряд - унифицируем строку

        String[] strArr = inputFinal.split("[+-/*]"); // массив строк, разделитель-знак операции=>вытаскиваем операнды
        String firstValue = strArr[0];//получили строку с первым значением
        String secondValue = strArr[1];//строка со вторым значением
        int arrayLength=strArr.length;//int с количеством элементов массива

        if (firstValue.length() == inputFinal.length()) {
            throw new IllegalArgumentException("Вы не ввели требуемый оператор");
        } // проверка на наличие требуемого арифм-го оператора, по которому делим строку ввода, коли нет её=> вывод ошибки

        if (firstValue.equals("I") || firstValue.equals("II") || firstValue.equals("III") || firstValue.equals("IV") || firstValue.equals("V") || firstValue.equals("VI") ||
                firstValue.equals("VII") || firstValue.equals("VIII") || firstValue.equals("IX") || firstValue.equals("X")) {
            isRomanOrNot1 = true; //проверяем является ли первое число римским от 1 до 10
        } else {
            isRomanOrNot1 = false;
        }
        //начинаем работу со вторым значением
        if (secondValue.equals("I") || secondValue.equals("II") || secondValue.equals("III") || secondValue.equals("IV") || secondValue.equals("V") || secondValue.equals("VI") ||
                secondValue.equals("VII") || secondValue.equals("VIII") || secondValue.equals("IX") || secondValue.equals("X")) {
            isRomanOrNot2 = true;//проверяем является ли второе число римским и от 1 до 10
        } else {
            isRomanOrNot2 = false;
        }

//проверяем это арабские или нет.
        if (firstValue.equals("1") || firstValue.equals("2") || firstValue.equals("3") || firstValue.equals("4") || firstValue.equals("5") || firstValue.equals("6") ||
                firstValue.equals("7") || firstValue.equals("8") || firstValue.equals("9") || firstValue.equals("10")) {
            isArabOrNot1 = true;
        } else {
            isArabOrNot1 = false;
        }

        if (secondValue.equals("1") || secondValue.equals("2") || secondValue.equals("3") || secondValue.equals("4") || secondValue.equals("5") || secondValue.equals("6") ||
                secondValue.equals("7") || secondValue.equals("8") || secondValue.equals("9") || secondValue.equals("10")) {
            isArabOrNot2 = true;
        } else {
            isArabOrNot2 = false;
        }
       if (isRomanOrNot1!=isRomanOrNot2&&isArabOrNot1!=isArabOrNot2) {
           throw new RuntimeException("Вы не ввели нужный формат данных.");
       }

//Создадим мапу, так как надо гонять значения из рим в араб и обратно, мапа- удобнее чем enum. Ключ - римские, значение -арабские
        HashMap<String, Integer> map = new HashMap<>();

        map.put("I", 1);
        map.put("II", 2);
        map.put("III", 3);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("VI", 6);
        map.put("VII", 7);
        map.put("VIII", 8);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XI", 11);
        map.put("XII", 12);
        map.put("XIII", 13);
        map.put("XIV", 14);
        map.put("XV", 15);
        map.put("XVI", 16);
        map.put("XVII", 17);
        map.put("XVIII", 18);
        map.put("XIX", 19);
        map.put("XX", 20);
        map.put("XXI", 21);
        map.put("XXII", 22);
        map.put("XXIII", 23);
        map.put("XXIV", 24);
        map.put("XXV", 25);
        map.put("XXVI", 26);
        map.put("XXVII", 27);
        map.put("XXVIII", 28);
        map.put("XXIX", 29);
        map.put("XXX", 30);
        map.put("XXXI", 31);
        map.put("XXXII", 32);
        map.put("XXXIII", 33);
        map.put("XXXIV", 34);
        map.put("XXXV", 35);
        map.put("XXXVI", 36);
        map.put("XXXVII", 37);
        map.put("XXXVIII", 38);
        map.put("XXXIX", 39);
        map.put("XL", 40);
        map.put("XLI", 41);
        map.put("XLII", 42);
        map.put("XLIII", 43);
        map.put("XLIV", 44);
        map.put("XLV", 45);
        map.put("XLVI", 46);
        map.put("XLVII", 47);
        map.put("XLVIII", 48);
        map.put("XLIX", 49);
        map.put("L", 50);
        map.put("LI", 51);
        map.put("LII", 52);
        map.put("LIII", 53);
        map.put("LIV", 54);
        map.put("LV", 55);
        map.put("LVI", 56);
        map.put("LVII", 57);
        map.put("LVIII", 58);
        map.put("LIX", 59);
        map.put("LX", 60);
        map.put("LXI", 61);
        map.put("LXII", 62);
        map.put("LXIII", 63);
        map.put("LXIV", 64);
        map.put("LXV", 65);
        map.put("LXVI", 66);
        map.put("LXVII", 67);
        map.put("LXVIII", 68);
        map.put("LXIX", 69);
        map.put("LXX", 70);
        map.put("LXXI", 71);
        map.put("LXXII", 72);
        map.put("LXXIII", 73);
        map.put("LXXIV", 74);
        map.put("LXXV", 75);
        map.put("LXXVI", 76);
        map.put("LXXVII", 77);
        map.put("LXXVIII", 78);
        map.put("LXXIX", 79);
        map.put("LXXX", 80);
        map.put("LXXXI", 81);
        map.put("LXXXII", 82);
        map.put("LXXXIII", 83);
        map.put("LXXXIV", 84);
        map.put("LXXXV", 85);
        map.put("LXXXVI", 86);
        map.put("LXXXVII", 87);
        map.put("LXXXVIII", 88);
        map.put("LXXXIX", 89);
        map.put("XC", 90);
        map.put("XCI", 91);
        map.put("XCII", 92);
        map.put("XCIII", 93);
        map.put("XCIV", 94);
        map.put("XCV", 95);
        map.put("XCVI", 96);
        map.put("XCVII", 97);
        map.put("XCVIII", 98);
        map.put("XCIX", 99);
        map.put("C", 100);

        if (isRomanOrNot1 == true && isRomanOrNot2 == true) {

            roman1 = map.get(firstValue);
            roman2 = map.get(secondValue);
            firstNumber = roman1;//первое число для вычислений
            secondNumber = roman2;//второй int для вычеслений
        }//isRomanOrNot


        if (isArabOrNot1 == true && isArabOrNot2 == true) {
            firstNumber = Integer.parseInt(firstValue);//если арабские, то сразу парсим стринг в инт - первое число
            secondNumber = Integer.parseInt(secondValue);//то-же самое для второго числа

        }//isArabOrNot

        if (isRomanOrNot1 != isRomanOrNot2) {//если одно из чисел римское, а другое нет=>Exception
            throw new IllegalArgumentException("Вы не ввели требуемый формат чисел");
        }
        if (firstNumber>10||firstNumber<1||secondNumber>10||secondNumber<1) {//проверка на приемлимость диапазона операндов
            throw new IllegalArgumentException("Вы ввели числа вне приемлемого диапазона ");
        }

        char[] charArray = input.toCharArray();
        char operation='@'; // создаем char для значения оператора
           //Через цикл проверяем знак оператора и присваеваем его чару operation
        int minusSymbolCounter=0;
        int firstValueLengthInt = firstValue.length();

        for (int i = 0; i < input.length(); i++) {
            charArray[i] = input.charAt(i);
            if (charArray[0] == '-'){
                throw new IllegalArgumentException("требуются положительные числа");
            }
            if (charArray[firstValueLengthInt+1] == '-') {
                throw new IllegalArgumentException("требуются положительные числа");
            }
            if (charArray[i]=='-') {
                minusSymbolCounter++;
            }
        }

        if (minusSymbolCounter>1) {
            throw new IllegalArgumentException("требуются положительные числа");
        }
        if (arrayLength>2) {
            throw new IllegalArgumentException("Введите необходимый формат данных для вычисления");
        }//проверка на наличие правильного формата введенных данных

        for (int i = 0; i < input.length(); i++) {
            charArray[i] = input.charAt(i);
            if (charArray[i] == '-') {
                operation = '-';
                           }// if charArray[i]=='-'
            else if (charArray[i] == '+') {
                operation = '+';


            } //if (charArray[i] == '-')
            else if (charArray[i] == '*') {
                operation = '*';

            }//if (charArray[i] == '*')
            else if (charArray[i] == '/') {
                operation = '/';

            }//if (charArray[i] == '/')
            if (charArray[i] == '.' || charArray[i] == ',') {
                throw new IllegalArgumentException("требуются целые числа");
            }//if (charArray[i] == '.' || charArray[i] == ',') на целочисленность

        }//for (int i=0;i<input.length();i++) конец блока цикла поиска оператора и проверки на нецелые числа

        switch (operation) {//тут считаем результат, вся арифметика здесь
            case '+':
                result = firstNumber + secondNumber;
                break;
            case '-':
                result = firstNumber - secondNumber;
                break;
            case '*':
                result = firstNumber * secondNumber;
                break;
            case '/':
                if (secondNumber == 0) {
                    throw new ArithmeticException("на ноль делить нельзя");//поругаем, если юзер решит делить на ноль
                }
                result = firstNumber / secondNumber;
                break;
        }
        calcResultAsString=String.valueOf(result);

        if (isRomanOrNot1==true&&result<=0) {
            throw new IllegalArgumentException ("Результат невозможно отобразить.Римские числа не могут быть меньше 1");
        }
        if (isRomanOrNot1==true) {//если юзер вводил римскими, то загоняем результат обратно в римские, через HashMap
            for(Entry<String, Integer> entry: map.entrySet()) {

                if(entry.getValue() == result) {
                    calcResultAsString=entry.getKey();
                    break;
                }
            }
        }
        return calcResultAsString;
    }//static String calc

}//CalculatorJavaKata

