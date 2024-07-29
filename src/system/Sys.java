//package system;
//
//import Animals.*;
//import Mobility.Point;
//import Olympics.Medal;
//
//import java.util.InputMismatchException;
//import java.util.Scanner;
///**
// * Names: Segev Chen 322433400
// *        Yinon Alfasi 208810374
// * This class represents a system for creating and managing various types of animals.
// * It prompts the user to specify the number and types of animals to create, handling
// * input validation to ensure correct user input. After creating the animals, it provides
// * a menu to display information and interact with the created animals.
// * The main method of this class initializes a Scanner object to read user input. It
// * continuously prompts the user to input the number of animals they want to create,
// * ensuring that the input is a positive integer. Once the number is validated, it
// * prompts the user to specify the type of each animal (Air, Water, or Terrestrial),
// * handling input validation for the type selection as well. It then creates an array
// * of Animal objects based on user input and passes it to the infoAndTalkMenu method
// * for further interaction.
// */
//public class Sys {
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//
//        int numOfAnimals = 0;
//        while(true) {
//            try {
//                System.out.println("How much animals do you want to create?");
//               numOfAnimals = sc.nextInt();
//               if(numOfAnimals <= 0) {
//                   System.out.println("Please enter a positive number");
//                   continue;
//               }
//               break;
//            } catch (InputMismatchException e) {
//                System.out.println("Invalid input, Please enter valid number.");
//                sc.nextLine();
//            }
//        }
//
//        Animal[] animals = new Animal[numOfAnimals];
//
//        for (int i = 0; i < numOfAnimals; i++) {
//            System.out.println("What is the type of ["+ (i + 1) + "] animal?");
//            int option = 0;
//            while(true) {
//                    try {
//                        System.out.println("Choose type from the menu:");
//                        System.out.println("1) Create a Air Animal");
//                        System.out.println("2) Create a Water Animal");
//                        System.out.println("3) Create a Terrestrial Animals");
//                        option = sc.nextInt();
//                        if (option < 1 || option > 3) {
//                            System.out.println("invalid number, please enter a valid option");
//                            continue;
//                        } else {
//                            break;
//                        }
//                    }catch (InputMismatchException e){
//                        System.out.println("Invalid input, Please enter valid number.");
//                        sc.nextLine();
//                    }
//            }
//            animals[i] = animalsTypeSwitchCase(option);
//        }
//        infoAndTalkMenu(sc, animals);
//        sc.close();
//
//    }
//
//    /**
//     * Creates an instance of a specific animal based on the user's choice of animal type.
//     * Prompts the user to input details such as name, gender, weight, speed, medals,
//     * and specific attributes relevant to the chosen animal type (Air, Water, or Terrestrial).
//     *
//     * @param choice An integer representing the type of animal to create:
//     *               1 for Air Animal, 2 for Water Animal, and 3 for Terrestrial Animal.
//     * @return An instance of the created Animal based on user input.
//     */
//    public static Animal animalsTypeSwitchCase(int choice) {
//        Scanner sc = new Scanner(System.in);
//
//        String name;
//        Animal.gender gender;
//        double weight;
//        double speed;
//        Medal[] medals;
//        Point point;
//
//        name = animalNameInput(sc);
//        gender = animalGenderInput(sc);
//        weight = animalWeightInput(sc);
//        speed = animalSpeedInput(sc);
//        medals = medalTypeInput(sc);
//        point = animalPointInput(sc, choice);
//
//        int option = 0;
//
//        switch (choice) {
//            case 1: {
//                while (true) {
//                    try {
//                        System.out.println("Choose the specific air animal you want to create:");
//                        System.out.println("1) Eagle");
//                        System.out.println("2) Pigeon");
//                        option = sc.nextInt();
//
//                        if (option < 1 || option > 2) {
//                            System.out.println("Invalid choice. Please choose a number between 1 and 2.");
//                        } else {
//                            return airAnimalSwitchCase(option, name, gender, weight, speed, medals, point);
//                        }
//                    } catch (InputMismatchException e) {
//                        System.out.println("Invalid input. Please enter a valid number.");
//                        sc.nextLine(); // Clear the invalid input
//                    }
//                }
//            }
//            case 2: {
//                while (true) {
//                    try {
//                        System.out.println("Choose the specific water animal you want to create:");
//                        System.out.println("1) Alligator");
//                        System.out.println("2) Whale");
//                        System.out.println("3) Dolphin");
//                        option = sc.nextInt();
//
//                        if (option < 1 || option > 3) {
//                            System.out.println("Invalid choice. Please choose a number between 1 and 3.");
//                        } else {
//                            return waterAnimalSwitchCase(option, name, gender, weight, speed, medals, point);
//                        }
//                    } catch (InputMismatchException e) {
//                        System.out.println("Invalid input. Please enter a valid number.");
//                        sc.nextLine(); // Clear the invalid input
//                    }
//                }
//            }
//            case 3: {
//                while (true) {
//                    try {
//                        System.out.println("Choose the specific terrestrial animal you want to create:");
//                        System.out.println("1) Dog");
//                        System.out.println("2) Cat");
//                        System.out.println("3) Snake");
//                        option = sc.nextInt();
//
//                        if (option < 1 || option > 3) {
//                            System.out.println("Invalid choice. Please choose a number between 1 and 3.");
//                        } else {
//                            return terrestrialAnimalSwitchCase(option, name, gender, weight, speed, medals, point);
//                        }
//                    } catch (InputMismatchException e) {
//                        System.out.println("Invalid input. Please enter a valid number.");
//                        sc.nextLine(); // Clear the invalid input
//                    }
//                }
//            }
//            default:
//                System.out.println("Invalid choice.");
//                break;
//        }
//
//        sc.close();
//        return null;
//    }
//
//
//    /**
//     * Creates an instance of an air animal based on the specified choice.
//     * Prompts the user to input additional details specific to each type of air animal.
//     *
//     * @param choice An integer representing the specific type of air animal:
//     *               1 for Eagle, 2 for Pigeon.
//     * @param name The name of the animal.
//     * @param gender The gender of the animal (Animal.gender enum).
//     * @param weight The weight of the animal.
//     * @param speed The speed of the animal.
//     * @param medals The array of medals associated with the animal.
//     * @param point The point of the animal.
//     * @return An instance of the specific air animal based on user input.
//     */
//    public static Animal airAnimalSwitchCase(int choice, String name, Animal.gender gender, double weight, double speed, Medal[] medals, Point point) {
//
//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("what is the wingspan?");
//        double wingspan = 0;
//        while (true) {
//            try {
//                wingspan = sc.nextDouble();
//                if (wingspan <= 0) {
//                    System.out.println("Invalid input. Please enter a positive number for the wingspan.");
//                    sc.nextLine(); // צריכת הקלט הלא חוקי
//                } else {
//                    break;
//                }
//            } catch (InputMismatchException e) {
//                System.out.println("Invalid input. Please enter a valid number.");
//                sc.nextLine(); // צריכת הקלט הלא חוקי
//            }
//        }
//
//        switch (choice) {
//            case 1://eagle
//            {
//                System.out.println("What is the altitude of flight?");
//                double AltitudeOfFlight = 0;
//                while (true) {
//                    try {
//                        AltitudeOfFlight = sc.nextDouble();
//                        if (AltitudeOfFlight <= 0) {
//                            System.out.println("Invalid input. Please enter a positive number for the altitude of flight.");
//                            sc.nextLine(); // צריכת הקלט הלא חוקי
//                        } else {
//                            break;
//                        }
//                    } catch (InputMismatchException e) {
//                        System.out.println("Invalid input. Please enter a valid number.");
//                        sc.nextLine(); // צריכת הקלט הלא חוקי
//                    }
//                }
//                return new Eagle(name, gender, weight, speed, medals, point, wingspan, AltitudeOfFlight);
//            }
//            case 2://pigeon
//            {
//
//                System.out.println("What is the familiy?");
//                String familiy = sc.nextLine();
//
//                return new Pigeon(name, gender, weight, speed, medals, point, wingspan, familiy);
//            }
//            default:
//                System.out.println("Invalid choice. Please select a valid animal type.");
//                return null;
//        }
//
//    }
//
//    /**
//     * Creates an instance of a water animal based on the specified choice.
//     * Prompts the user to input additional details specific to each type of water animal.
//     *
//     * @param choice An integer representing the specific type of water animal:
//     *               1 for Alligator, 2 for Dolphin, 3 for Whale.
//     * @param name The name of the animal.
//     * @param gender The gender of the animal (Animal.gender enum).
//     * @param weight The weight of the animal.
//     * @param speed The speed of the animal.
//     * @param medals The array of medals associated with the animal.
//     * @param point The point of the animal.
//     * @return An instance of the specific water animal based on user input.
//     */
//    public static Animal waterAnimalSwitchCase(int choice, String name, Animal.gender gender, double weight, double speed, Medal[] medals, Point point){
//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("what is the diveDept?");
//        double diveDept = 0;
//        while (true) {
//            try {
//                diveDept = sc.nextDouble();
//                if (diveDept <= 0) {
//                    System.out.println("Invalid input. Please enter a positive number for the wingspan.");
//                    sc.nextLine(); // צריכת הקלט הלא חוקי
//                } else {
//                    break;
//                }
//            } catch (InputMismatchException e) {
//                System.out.println("Invalid input. Please enter a valid number.");
//                sc.nextLine(); // צריכת הקלט הלא חוקי
//            }
//        }
//
//        switch (choice) {
//            case 1://Alligator
//            {
//                System.out.println("What is the area of living?");
//                String areaOfLiving;
//                areaOfLiving = sc.nextLine();
//                return new Alligator(name, gender, weight, speed, medals, point, diveDept, areaOfLiving);
//            }
//            case 2://Dolphin
//            {
//                Dolphin.WaterType type = Dolphin.WaterType.Sea;
//                int typeOfWater = 0;
//                while (true) {
//                    try {
//                        typeOfWater = sc.nextInt();
//                        if (typeOfWater < 1 || typeOfWater > 2) {
//                            System.out.println("Invalid input. Please enter a positive number for the wingspan.");
//                            sc.nextInt(); // צריכת הקלט הלא חוקי
//                        } else {
//                            System.out.println("What is the waterType?");
//                            System.out.println("1) Sea");
//                            System.out.println("2) Sweet");
//                            if (typeOfWater == 1) {
//                                type = Dolphin.WaterType.Sea;
//                            }
//                            else {
//                                type = Dolphin.WaterType.Sweet;
//                            }
//                            break;
//                        }
//                    } catch (InputMismatchException e) {
//                        System.out.println("Invalid input. Please enter a valid number.");
//                        sc.nextLine(); // צריכת הקלט הלא חוקי
//                    }
//                }
//                return new Dolphin(name, gender, weight, speed, medals, point, diveDept, type);
//            }
//
//            case 3: //whale
//            {
//                System.out.println("What is the food type?");
//                String footType = sc.nextLine();
//                return new Alligator(name, gender, weight, speed, medals, point, diveDept, footType);
//            }
//            default:
//                System.out.println("Invalid choice. Please select a valid animal type.");
//                return null;
//        }
//    }
//
///**
// * Creates an instance of a terrestrial animal based on the specified choice.
// * Prompts the user to input additional details specific to each type of terrestrial animal.
// *
// * @param choice An integer representing the specific type of terrestrial animal:
// *               1 for Dog, 2 for Cat, 3 for Snake.
// * @param name The name of the animal.
// * @param gender The gender of the animal (Animal.gender enum).
// * @param weight The weight of the animal.
// * @param speed The speed of the animal.
// * @param medals The array of medals associated with the animal.
// * @param point The point of the animal.
// * @return An instance of the specific terrestrial animal based on user input. **/
//
//    public static Animal terrestrialAnimalSwitchCase(int choice, String name, Animal.gender gender, double weight, double speed, Medal[] medals, Point point){
//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("what is the number of legs?");
//        int numberOfLegs = 0;
//        while (true) {
//            try {
//                numberOfLegs = sc.nextInt();
//                if (numberOfLegs <= 0) {
//                    System.out.println("Invalid input. Please enter a positive number for the number of legs.");
//                    sc.nextLine(); // צריכת הקלט הלא חוקי
//                } else {
//                    break;
//                }
//            } catch (InputMismatchException e) {
//                System.out.println("Invalid input. Please enter a valid number.");
//                sc.nextLine(); // צריכת הקלט הלא חוקי
//            }
//        }
//
//        switch (choice) {
//            case 1://dog
//            {
//                System.out.println("What is the breed of the dog?");
//                String breed;
//                breed = sc.next();
//                return new Dog(name, gender, weight, speed, medals, point, numberOfLegs, breed);
//            }
//            case 2://cat
//            {
//                int ifCastrated;
//                boolean Castrated = false;
//
//                while (true) {
//                    try {
//                        System.out.println("the cat is Castrated?");
//                        System.out.println("1) Yes");
//                        System.out.println("2) No");
//                        ifCastrated = sc.nextInt();
//                        if (ifCastrated < 1 || ifCastrated > 2) {
//                            System.out.println("Invalid input. Please enter a positive number for the Castrated.");
//                            sc.nextInt(); // צריכת הקלט הלא חוקי
//                        } else {
//                            if (ifCastrated == 1) {
//                                Castrated = true;
//                            }
//                            else {
//                                Castrated = false;
//                            }
//                            break;
//                        }
//                    } catch (InputMismatchException e) {
//                        System.out.println("Invalid input. Please enter a valid number.");
//                        sc.nextLine(); // צריכת הקלט הלא חוקי
//                    }
//                }
//                return new Cat(name, gender, weight, speed, medals, point, numberOfLegs, Castrated);
//            }
//
//            case 3: //snake
//            {
//                double length;
//                Snake.poisonous poisonous;
//                int ifPoisonous = 0;
//
//                while (true) {
//                    try {
//                        System.out.println("the snake is poisonous?");
//                        System.out.println("1) Low");
//                        System.out.println("2) Medium");
//                        System.out.println("3) High");
//                        ifPoisonous = sc.nextInt();
//                        if (ifPoisonous < 1 || ifPoisonous > 3) {
//                            System.out.println("Invalid input. Please enter a positive number for the Castrated.");
//                            sc.nextInt(); // צריכת הקלט הלא חוקי
//                        } else {
//                            if (ifPoisonous == 1) {
//                                poisonous = Snake.poisonous.low;
//                            }
//                            if (ifPoisonous == 2){
//                                poisonous = Snake.poisonous.medium;
//                            }
//                            else{
//                                poisonous = Snake.poisonous.high;
//                            }
//                            System.out.println("What is the length of the snake?");
//                            while (true) {
//                                try {
//                                    length = sc.nextDouble();
//                                    if (length <= 0) {
//                                        System.out.println("Invalid input. Please enter a positive number for the length.");
//                                        sc.nextLine(); // צריכת הקלט הלא חוקי
//                                    } else {
//                                        break;
//                                    }
//                                } catch (InputMismatchException e) {
//                                    System.out.println("Invalid input. Please enter a valid number.");
//                                    sc.nextLine(); // צריכת הקלט הלא חוקי
//                                }
//                            }
//                            break;
//                        }
//                    } catch (InputMismatchException e) {
//                        System.out.println("Invalid input. Please enter a valid number.");
//                        sc.nextLine(); // צריכת הקלט הלא חוקי
//                    }
//                }
//                return new Snake(name, gender, weight, speed, medals, point, poisonous, length);
//            }
//            default:
//                System.out.println("Invalid choice. Please select a valid animal type.");
//                return null;
//        }
//    }
//
//    /**
//     * Prompts the user to input the name of the animal.
//     *
//     * @param sc The Scanner object used for input.
//     * @return The name of the animal entered by the user.
//     */
//    public static String animalNameInput(Scanner sc){
//        System.out.println("What is the name of the animal:");
//        return sc.next();
//    }
//
//    /**
//     * Prompts the user to input the gender of the animal and returns the corresponding Animal.gender value.
//     *
//     * @param sc The Scanner object used for input.
//     * @return The gender of the animal as an Animal.gender enum value (Male, Female, or Hermaphrodite).
//     */
//    public static Animal.gender animalGenderInput(Scanner sc){
//        int gender = 0;
//        while(true) {
//            try {
//                System.out.println("What is the gender of the animal:");
//                System.out.println("1) Male");
//                System.out.println("2) Female");
//                System.out.println("3) Hermaphrodite");
//                gender = sc.nextInt();
//                if (gender < 1 || gender > 3) {
//                    System.out.println("Invalid input. Please choose a number between 1 and 3.");
//                    continue;
//                }
//                else {
//                    if (gender == 1)
//                        return Animal.gender.Male;
//                    if (gender == 2)
//                        return Animal.gender.Female;
//                    return Animal.gender.Hermaphrodite;
//                }
//            }catch (InputMismatchException e){
//                System.out.println("Invalid input. Please enter a valid name.");
//                sc.nextLine();
//            }
//        }
//    }
//
//    /**
//     * Prompts the user to input the weight of the animal.
//     *
//     * @param sc The Scanner object used for input.
//     * @return The weight of the animal as a double.
//     */
//    public static double animalWeightInput(Scanner sc){
//        double weight = 0;
//        while (true) {
//            try {
//                System.out.println("What is the weight of the animal:");
//                weight = sc.nextDouble();
//                if (weight <= 0) {
//                    System.out.println("Invalid input. Please enter a positive number for the weight.");
//                    sc.nextLine(); // צריכת הקלט הלא חוקי
//                } else {
//                    break;
//                }
//            } catch (InputMismatchException e) {
//                System.out.println("Invalid input. Please enter a valid number.");
//                sc.nextLine(); // צריכת הקלט הלא חוקי
//            }
//        }
//        return weight;
//    }
//
//    /**
//     * Prompts the user to input the speed of the animal.
//     *
//     * @param sc The Scanner object used for input.
//     * @return The speed of the animal as a double.
//     */
//    public static double animalSpeedInput(Scanner sc){
//        double speed = 0;
//        while (true) {
//            try {
//                System.out.println("What is the speed of the animal:");
//                speed = sc.nextDouble();
//                if (speed <= 0) {
//                    System.out.println("Invalid input. Please enter a positive number for the speed.");
//                    sc.nextLine(); // צריכת הקלט הלא חוקי
//                } else {
//                    break;
//                }
//            } catch (InputMismatchException e) {
//                System.out.println("Invalid input. Please enter a valid number.");
//                sc.nextLine(); // צריכת הקלט הלא חוקי
//            }
//        }
//        return speed;
//    }
//
//    /**
//     * Prompts the user to input information about medals for the animal.
//     * If the animal has medals, it asks for the number of medals, their types (Bronze, Silver, Gold),
//     * the tournament name, and the year of each medal.
//     * If the animal has no medals, it returns an empty Medal array.
//     *
//     * @param sc The Scanner object used for input.
//     * @return An array of Medal objects representing the medals of the animal.
//     */
//    public static Medal[] medalTypeInput(Scanner sc) {
//        int ifHaveMedals = 0;
//        while (true) {
//            try {
//                System.out.println("Does the animal have medals?");
//                System.out.println("1) Yes");
//                System.out.println("2) No");
//                ifHaveMedals = sc.nextInt();
//                if (ifHaveMedals < 1 || ifHaveMedals > 2) {
//                    System.out.println("Invalid input. Please choose a number between 1 and 2.");
//                    continue;
//                } else {
//                    if (ifHaveMedals == 2) {
//                        return new Medal[0];
//                    } else {
//                        while (true) {
//                            try {
//                                System.out.println("How many medals?");
//                                int numOfMedals = sc.nextInt();
//                                if (numOfMedals <= 0) {
//                                    System.out.println("Please insert a positive number of medals!");
//                                    sc.nextLine();
//                                    continue;
//                                } else {
//                                    Medal[] medalArr = new Medal[numOfMedals];
//                                    int medalType = 0;
//                                    for (int i = 0; i < numOfMedals; i++) {
//                                        while (true) {
//                                            try {
//                                                System.out.println("Choose which type of medal is the " + (i + 1) + " medal:");
//                                                System.out.println("1) Bronze");
//                                                System.out.println("2) Silver");
//                                                System.out.println("3) Gold");
//                                                medalType = sc.nextInt();
//                                                if (medalType < 1 || medalType > 3) {
//                                                    System.out.println("Invalid input. Please enter a number between 1 and 3.");
//                                                    sc.nextLine();
//                                                    continue;
//                                                } else {
//                                                    int year;
//                                                    System.out.println("What is the tournament name of the medal?");
//                                                    String tournament = sc.next();
//                                                    while (true) {
//                                                        try {
//                                                            System.out.println("What is the year of the tournament of the medal?");
//                                                            year = sc.nextInt();
//                                                            if (year <= 0) {
//                                                                System.out.println("Invalid input. Please enter a positive number for year.");
//                                                                sc.nextLine(); // צריכת הקלט הלא חוקי
//                                                            } else {
//                                                                break;
//                                                            }
//                                                        } catch (InputMismatchException e) {
//                                                            System.out.println("Invalid input. Please enter a valid number.");
//                                                            sc.nextLine(); // צריכת הקלט הלא חוקי
//                                                        }
//                                                    }
//
//
//                                                    if (medalType == 1) {
//
//                                                        medalArr[i] = new Medal(tournament, Medal.Medaltype.BRONZE, year);
//                                                    }
//                                                    else if (medalType == 2)
//                                                        medalArr[i] = new Medal(tournament, Medal.Medaltype.SILVER, year);
//                                                    else medalArr[i] = new Medal(tournament, Medal.Medaltype.GOLD, year);
//                                                    break;
//                                                }
//                                            } catch (InputMismatchException e) {
//                                                System.out.println("Invalid input. Please enter a valid number.");
//                                                sc.nextLine();
//                                                continue;
//                                            }
//                                        }
//                                    }
//                                    return medalArr;
//                                }
//                            } catch (InputMismatchException e) {
//                                System.out.println("Invalid input. Please enter a number.");
//                                sc.nextLine();
//                                continue;
//                            }
//                        }
//                    }
//                }
//            } catch (InputMismatchException e) {
//                System.out.println("Invalid input. Please enter a valid number.");
//                sc.nextLine();
//            }
//        }
//    }
//
//    /**
//     * Prompts the user to input a point or set a default point based on the animal type.
//     *
//     * @param sc   The Scanner object used for input.
//     * @param type The type of animal (1 for air, 2 for water, any other for terrestrial).
//     * @return A Point object representing the coordinates of the animal's habitat.
//     */
//    public static Point animalPointInput(Scanner sc, int type){
//        int wantCreateOrDefault = 0;
//        int x = 0, y = 0;
//        while (true) {
//            try {
//                System.out.println("do you want to enter a point or set a default point?");
//                System.out.println("1) Enter a point");
//                System.out.println("2) Set a default point");
//                wantCreateOrDefault = sc.nextInt();
//                if (wantCreateOrDefault < 1 || wantCreateOrDefault > 2) {
//                    System.out.println("invalid input, please enter a number between 1 and 2.");
//                    sc.nextLine();
//                    continue;
//                }
//                else {
//                    if (wantCreateOrDefault == 2){
//                        if (type == 1){ //air
//                            return new Point(0,100);
//                        }
//                        if (type == 2){ //water
//                            return new Point(50,0);
//                        }
//                        return new Point(0,20);
//                    }
//
//                    while (true) {
//                        try {
//                            System.out.println("enter a x value;");
//                            x = sc.nextInt();
//                            if (x < 0) {
//                                System.out.println("invalid input, please enter a positive number");
//                                sc.nextLine();
//                                continue;
//                            } else {
//                                while (true) {
//                                    try {
//                                        System.out.println("enter a y value;");
//                                        y = sc.nextInt();
//                                        if (y < 0) {
//                                            System.out.println("invalid input, please enter a positive number");
//                                            sc.nextLine();
//                                            continue;
//                                        } else {
//                                            return new Point(x,y);
//                                        }
//                                    } catch (InputMismatchException e) {
//                                        System.out.println("invalid input, please enter a number between 1 and 2.");
//                                        sc.nextLine();
//                                        continue;
//                                    }
//                                }
//                            }
//                        } catch (InputMismatchException e) {
//                            System.out.println("invalid input, please enter a number between 1 and 2.");
//                            sc.nextLine();
//                        }
//                        break;
//                    }
//                }
//                return new Point(x, y);
//            }catch (InputMismatchException e){
//                System.out.println("invalid input, please enter a valid number.");
//                sc.nextLine();
//                continue;
//            }
//        }
//    }
//
//
//    /**
//     * Displays a menu for interacting with an array of animals.
//     * The menu allows the user to choose to view information about each animal,
//     * hear the sound each animal makes, or exit the program.
//     *
//     * @param sc        The Scanner object used for input.
//     * @param animalArr An array of Animal objects containing the animals to display.
//     */
//    public static void infoAndTalkMenu(Scanner sc, Animal[] animalArr){
//        int option = 0;
//        while(true)
//        {
//            while (true) {
//                try {
//                    System.out.println("Choose what you want to see:");
//                    System.out.println("1) info about every animal");
//                    System.out.println("2) talk sound of every animal");
//                    System.out.println("3) exit");
//                    option = sc.nextInt();
//                    if (option < 1 || option > 3) {
//                        System.out.println("invalid input, please enter a number between 1 and 3.");
//                        sc.nextLine();
//                        continue;
//                    } else {
//                        break;
//                    }
//                } catch (InputMismatchException e) {
//                    System.out.println("invalid input, please enter a number between 1 and 3.");
//                    sc.nextLine();
//                    continue;
//                }
//            }
//            switch (option) {
//                case 1: {
//                    for (Animal animal : animalArr) {
//                        System.out.println(animal.toString());
//                    }
//                    break;
//                }
//                case 2: {
//                    for (Animal animal : animalArr) {
//                        animal.makeSound();
//                    }
//                    break;
//                }
//                case 3: {
//                    System.out.println("Thank you bye,bye!");
//                    System.exit(0);
//                    break;
//                }
//                default: {
//                    System.out.println("Invalid choice.");
//                    break;
//                }
//            }
//        }
//
//    }
//}
//
//
