package chudovischtna.administracia2.v2;
import java.util.Random;
import java.util.Scanner;

public class ChudovishtnaAdministraciaV2 {
    boolean isProgramRunning = true;
    Scanner inputScanner = new Scanner(System.in);
    int numberOfElements = inputScanner.nextInt();

    public static void main(String[] args) {

        int menuOptions;
        System.out.println("Vavedete broya na elementite, koito ste zapisvate v masiva: \n" + numberOfElements);

        while (isProgramRunningRunning) {
            renderMenu();
            menuOptions = inputScanner.nextInt();
            if (menuOptions == 1) {
                renderNumsMenu();
            }
            if (menuOptions == 2) {
                renderWordsMenu();
            }
            if (menuOptions == 3) {
                isProgramRunning = false;
            }
        }
    }

    public static void renderMenu(){
        System.out.println("1. Rabota s chisla.");
        System.out.println("2. Rabota s dumi.");
        System.out.println("3. Izhod.");
    }

    public static void renderCollection(int[] collection) {
        System.out.print("[");
        for (int i = 0; i < collection.length; i++) {
            System.out.print(collection[i]);
            if (i != (collection.length - 1)) {
                System.out.print(",");
            }
        }
        System.out.println("];");
    }

    public static void renderNumsMenu() {
        int mathMenuOptions;

        System.out.println("Vavedete chisla po-golemi ot 0 i po-malki ot 10 000:\n");
        int[] chislovMasiv = new int[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            chislovMasiv[i] = allowedValue(inputScanner);
        }
        while (isProgramRunning) {
            renderMathMenu();
            System.out.println("Izberete opcia: ");
            mathMenuOptions = inputScanner.nextInt();
            if (mathMenuOptions == 1) {
                renderCollection(prostiChisla(int[] collection));
                renderMathMenu();
            }
            if (mathMenuOptions == 2) {
                renderCollection(naiChestoSreshtanoChislo(int[] collection, int num));
                renderMathMenu();
            }
            if (mathMenuOptions == 3) {
                renderCollection(maksimalnaRedicaOtVazhodyashtiChisla(int[] collection));
                renderMathMenu();
            }
            if (mathMenuOptions == 4) {
                renderCollection(maksimalnaRedicaOtNizhodyashtiChisla(int[] collection));
                renderMathMenu();
            }
            if (mathMenuOptions == 5) {
                renderCollection(maksimalnaRedicaOtEdnakviChisla(int[] collection));
                renderMathMenu();
            }
            if (mathMenuOptions == 6) {
                renderCollection(randomNumberSumSearch(int[] collection));
                renderMathMenu();
            }
            if (mathMenuOptions == 7) {
                renderMenu();
            }
        }
    }

    public static int allowedValue(Scanner scannerReference) {
        while (true) {
            System.out.println();
            int input = scannerReference.nextInt();
            if (input >= 0 && input <= 10000) {
                return input;
            }
            System.out.println("Greshka! Opitai pak.")
        }
    }

    public static void renderMathMenu() {
        System.out.println("1. Izvejdane na prosti chisla ot masiva.");
        System.out.println("2. Izvejdane na nai-chesto sreshtani elementi ot masiva.");
        System.out.println("3. Izvejdane na maksimalna redica ot narastvashti elementi ot masiva.");
        System.out.println("4. Izvejdane na maksimalna redica ot namalyavashti elementi ot masiva.");
        System.out.println("5. Izvejdane na maksimalna redica ot ednakvi elementi ot masiva.");
        System.out.println("6. Izvajdane na posledovatelnost ot chisla ot masiva, koito imat suma ravna na chislo, generirano na sluchaen princip.");
        System.out.println("7. Vrashtane gam glavno menu.");
    }

    public static int prostiChisla(int[] collection) {
        for (int i = 0; i <= collection.length; i++) {
            boolean isPrimeNumber = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrimeNumber = false;
                    break;
                }
                if (isPrime) {
                    System.out.println(i + " sa prosti chisla v masiva.\n");
                }
            }
        }
    }

    public static int naiChestoSreshtanoChislo(int[] collection, int num) {
        int maxCount = 1, res = collection[0], currentCount = 1;
        for (int i = 1; i < num; i++) {
            if (collection[i] == collection[i - 1]) {
                curr_count++;
            }
            if (currentCount > maxCount) {
                maxCount = currentCount;
                res = collection[i - 1];
                System.out.println("Nai-chesto sreshtanoto chislo e:\n" + res);
            }

            if (currentCount > maxCount) {
                maxCount = currentCount;
                res = collection[num - 1];
                System.out.println("Nai-chesto sreshtanoto chislo e:\n" + res);
            }
            currentCount = 1;
            System.out.println("Nyama povtaryashti se chisla.");
        }
    }

    public static int maksimalnaRedicaOtVazhodyashtiChisla(int[] collection) {
        int count = 1, tempCount = 1, number = 0;
        for (int i = 0; i < collection.length; i++) {
            if (collection[i] < collection[i + 1]) {
                tempCount++;
            } else tempCount = 1;
            if (tempCount > count) {
                count = tempCount;
                number = collection[i];
            }
        }
        System.out.println("Maksimalnata redica ot vazhodyashti chisla e:\n" + number);
    }

    public static int maksimalnaRedicaOtNizhodyashtiChisla(int[] collection) {
        int count = 1, tempCount = 1, number = 0;
        for (int i = 0; i < collection.length; i++) {
            if (collection[i] > collection[i + 1]) {
                tempCount++;
            } else tempCount = 1;
            if (tempCount > count) {
                count = tempCount;
                number = collection[i];
            }
        }
        System.out.println("Maksimalnata redica ot nizhodyashti chisla e:\n" + number);
    }

    public static int maksimalnaRedicaOtEdnakviChisla(int[] collection) {
        int count = 1, tempCount = 1, number = 0;
        for (int i = 0; i < collection.length; i++) {
            if (collection[i] == collection[i + 1]) {
                tempCount++;
            } else tempCount = 1;
            if (tempCount > count) {
                count = tempCount;
                number = collection[i];
            }
        }
        System.out.println("Maksimalnata redica ot ednakvi chisla e:\n" + number);
    }

    public static int randomNumberSumSearch(int[] collection) {
        Random rand = new Random();
        int value = rand.nextInt(51);
        System.put.println("Sluchaino chislo: " + value);
        int sum=0, nextElement;
        for (int i = 0; i<=collection.length; i++){
//                if (collection[i] == value){
//                    System.out.println("Chisloto ot masiva, ravno na sluchainoto e:\n" + i);
//                }
//                if (collection[i]<value){
//                    sum=collection[i];
//                    collection[i]=collection[i-1];
//                    nextElement=collection[i-1];
//
//                    System.out.println("Chisloto ot masiva, ravno na sluchainoto e:\n" + sum);
//                }
            System.out.println("Ne se poluchava!");
        }
    }

    public static void renderWordsMenu(){
        int wordMenuOptions;

        System.out.println("Vavedete dumi:\n");
        String[] wordsMasiv = new String[numberOfElements];

        while(isProgramRunning){
            renderWordsOptions();
            System.out.println("Izberete opcia: ");
            wordMenuOptions = inputScanner.nextInt();
            if (wordMenuOptions == 1){
                renderCollection(reverseWords(int[] collection));
                renderWordsOptions();
            }
            if (wordMenuOptions == 2){
                renderCollection(povtaryshtiSeSimvoliDumi(String[] collection);
                renderWordsOptions();
            }
            if (wordMenuOptions == 3){
                renderWordsOptions();
            }
            if (wordMenuOptions == 4){
                renderCollection(broiPovtaryashtiSeDumi(int[] collection));
                renderWordsOptions();
            }
            if (wordMenuOptions == 5){
                renderMenu();
            }
        }
    }

    public static String reverseWords(String[] collection){
        String[] reversed = String[] collection;
        int begin = 0;
        int end =reversed.length-1;
        char temp;
        while(end>begin) {
            temp = reversed[begin];
            reversed[begin] = reversed[end];
            reversed[end] = temp;
            end--;
            begin++;
        }
        System.out.println("Obarnati dumi:\n" + reversed);
    }

    public static void povtaryshtiSeSimvoliDumi(String[] collection){
        List<String> words = collection;
        for (String s : words){
            System.out.println(repeatingLetters(s));
        }
    }
    private static String repeatingLetters(String s){
        String output = s;
        String temp;
        while (true) {
            temp = output.replaceAll("(.+)\\1", "$1");
            if (temp.equals(output)) break;
            output = temp;
        }
        return output;
    }

    public static void simvoliVavString(String[] collection){
        for(int i = 0 ; i < collection.length; i++){
            char [] eachLetterinArray =  collection[i].toCharArray();
            for (int j = 0,count = 0 ; j < eachLetterinArray.length; j++){
                if((eachLetterinArray[j]+'a'-97 >=65 && eachLetterinArray[j]+'a'-97 <=90 )
                        || (eachLetterinArray[j]+'a'-97 >=97 && eachLetterinArray[j]+'a'-97 <=122 )  ){
                    count++;
                }
                System.out.print("Broi na simvoli:\n" + count);
            }
        }

        public static int broiPovtaryashtiSeDumi(String[] collection){
            int count = 0, initCount = 0;
            for (int i = 0; i<collection.length; i++){
                if (collection[i] == collection[i-1]){
                    count++;
                }
                if (count > initCount){
                    System.out.println("Broyat na povtaryashtite se dumi e: \n" + count);
                }
                System.out.println("Nyama povtaryashti se dumi.")
            }
        }

        public static void renderWordsOptions(){
            System.out.println("1. Obarnete i vizualiziraite bukvite ot masiva.");
            System.out.println("2. Izvejane na povtaryashti se simvoli ot dumi v masiva.");
            System.out.println("3. Izvejdane na broya na simvolite vav vsyaka duma ot masiva.");
            System.out.println("4. Izvedete broya na povtaryashti se dumi v masiva.");
            System.out.println("5. Vrashtane kam osnovno menu.");
        }
}
