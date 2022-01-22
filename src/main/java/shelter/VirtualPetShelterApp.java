package shelter;

import java.util.Scanner;

public class VirtualPetShelterApp {
    public static void main(String[] args) {
        int usersSelectionNumber = 1;
        String userSelectionName;
        String userSelectionDescription;
        VirtualPetArt art = new VirtualPetArt();

        Scanner stringInput = new Scanner(System.in);
        Scanner userInput = new Scanner(System.in);

        VirtualPet pet1 = new VirtualPet("Fluffy", "He is an older, Tyrannosaurus Rex with am attitude. Slightly temperamental");
        VirtualPet pet2 = new VirtualPet("Peach", "She is a young Stegosaurus with long colorful plates. Loves to play.");
        VirtualPet pet3 = new VirtualPet("Cera", "She is fairly timid Triceratops. Loves open spaces and cool shade.");
        VirtualPet pet4 = new VirtualPet("Night", "She is a playful Velociraptor. Loves the thrill of the hunt.");

        VirtualPetShelter actualShelter = new VirtualPetShelter();
        actualShelter.addPet(pet1);
        actualShelter.addPet(pet2);
        actualShelter.addPet(pet3);
        actualShelter.addPet(pet4);

        welcomeStatement(actualShelter);

        gameLoop(usersSelectionNumber, art, stringInput, userInput, actualShelter);
    }

    private static void gameLoop(int usersSelectionNumber, VirtualPetArt art, Scanner stringInput, Scanner userInput, VirtualPetShelter actualShelter) {
        while (usersSelectionNumber != 0) {
            directions();
            usersSelectionNumber = userInput.nextInt();
            if (usersSelectionNumber == 1) {
                actualShelter.feedAll(30);
                System.out.println("The dinosaurs look well fed and watered. Thanks!");
            } else if (usersSelectionNumber == 2) {
                press2Play(stringInput, actualShelter);
            } else if (usersSelectionNumber == 3) {
                actualShelter.sleepAll(40);
                System.out.println("Shhh... never wake a sleeping dinosaur");
            } else if (usersSelectionNumber == 4) {
                press4Adopt(stringInput, actualShelter);
            } else if (usersSelectionNumber == 5) {
                press5TakeIn(stringInput, actualShelter);
            } else if (usersSelectionNumber == 6) {
                actualShelter.receivePetNames();
            }
            if (usersSelectionNumber != 0) {
                actualShelter.tickAll();
                animalsWellBeings(actualShelter);
            } else {
                System.out.println(art.exitGame + "\nThanks for surviving ..err helping today! We hope to have you back soon!");
            }
        }
    }

    private static void press5TakeIn(Scanner stringInput, VirtualPetShelter actualShelter) {
        String userSelectionName;
        String userSelectionDescription;
        System.out.println("Someone just found a dinosaur. What should we name it?");
        userSelectionName = stringInput.nextLine();
        System.out.println("Please fill out the type it is and a short description (Separate with a , please.");
        userSelectionDescription = stringInput.nextLine();
        VirtualPet newPet = new VirtualPet(userSelectionName, userSelectionDescription);
        actualShelter.addPet(newPet);
        System.out.println("Great! " + userSelectionName + " has been added.");
    }

    private static void press4Adopt(Scanner stringInput, VirtualPetShelter actualShelter) {
        String userSelectionName;
        actualShelter.receivePetNames();
        System.out.println("Put in the name of the dinosaur you are wanting to adopt :");
        userSelectionName = stringInput.nextLine();
        if (actualShelter.isAnimalInShelter(userSelectionName)) {
            System.out.println(actualShelter.returnOnePet(userSelectionName).getPetName() + " was just adopted.\n");
            actualShelter.removePet(userSelectionName);
        } else {
            System.out.println("Please pick from the names provided.\n");
        }
    }

    private static void press2Play(Scanner stringInput, VirtualPetShelter actualShelter) {
        String userSelectionName;
        actualShelter.receivePetNames();
        System.out.println("Please type in dinosaurs name you would like to play with:");
        userSelectionName = stringInput.nextLine();
        if (actualShelter.isAnimalInShelter(userSelectionName)) {
            actualShelter.returnOnePet(userSelectionName).play(25);
            System.out.println(actualShelter.returnOnePet(userSelectionName).getPetName() + " didn't eat you! err i mean, had fun playing with you!");
        } else {
            System.out.println("Please pick from the names provided.\n");
        }
    }

    private static void directions() {
        System.out.println("What would you like to do?\nPress 1 to feed & water all dinos\nPress 2 to play with individual dino\nPress 3 to put all dino's to bed\nPress 4 to sign adoption and waiver paper work\nPress 5 to take in a new dinosaur\nPress 6 to read dinosaur bios\nPress 0 to end shift and exit");
    }

    private static void welcomeStatement(VirtualPetShelter actualShelter) {
        System.out.println("");
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$**''''`` ````'''#*R$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$*''      ..........      `'#$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("$$$$$$$$$$$$$$$$$$$#`    .ue@$$$********$$$$Weu.   ``*$$$$$$$$$$$$$$$$$$$");
        System.out.println("$$$$$$$$$$$$$$$$#''   ue$$*#''               `'**$$N.  *R$$$$$$$$$$$$$$$$");
        System.out.println("$$$$$$$$$$$$$P    u@$**`                          #$$o.  ^*$$$$$$$$$$$$$$");
        System.out.println("$$$$$$$$$$$P  .o$R``               . .WN.           #$Nu  '#$$$$$$$$$$$$$");
        System.out.println("$$$$$$$$$$`  .@$#`       'ou  .oeW$$$$$$$$W           `$$u  '$$$$$$$$$$$$");
        System.out.println("$$$$$$$$#   o$#`      ueL  $$$$$$$$$$$$$$$$ku.           $$u  $$$$$$$$$$$");
        System.out.println("$$$$$$$  x$P`        `$$u$$$$$$$$$$$$$$#####$$$L            $o  #*$$$$$$$");
        System.out.println("$$$$$$  d$        #$u.2$$$$$$$$$$$$$$$$  #$$$Nu#$            $$.  #$$$$$$");
        System.out.println("$$$$$  @$          $$$$$$$$$$$$$$$$$$$$k  $#$$#*$$u           #$L  #$$$$$");
        System.out.println("$$$$  d$         #Nu@$$$$$$$$$$$$$$$$$$   $x$$L #$$$o.         #$c  #$$$$");
        System.out.println("$$$F  d$          .$$$$$$$$$$$$$$$$$$$$N  $d$$$$  $$$$$u        #$L  #$$$");
        System.out.println("$$$  :$F        ..`$$$$$$$$$$$$$$$$$$$$$$$$$$$`    R$$$$$eu.     $$   $$$");
        System.out.println("$$!  $$        . R$$$$$$$$$$$$$$$$$$$$$$$$$$$$$.   @$$$$$$$$Nu   '$N  `$$");
        System.out.println("$$  x$`        Re$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$uu@````$$$$$$$i   #$:  $$");
        System.out.println("$E  $$       c 8$$$$$$$$$$$$$$$$$$$$$G(   ``^*$$$$$$$WW$$$$$$$$N   $$  4$");
        System.out.println("$~ :$$N. tL i)$$$$$$$$$$$$$$$$$$$$$$$$$N       ^#R$$$$$$$$$$$$$$$   9$ '$");
        System.out.println("$  t$$$$u$$W$$$$$$$$$$$$$$!$$$$$$$$$$$$$&       . c?'*$$$R$$$$$$$  '$k  $");
        System.out.println("$  $$$$$$$$$$$$$$$$$$$$$'E F#$$$$$$$$$$.#        +.V#;*#x#.##*$$$   $B  $");
        System.out.println("$  $$$$$$$$$$$$$$$$`$)#F     $$$$$$$$$$$           `  -d>x`*=.``    $$  $");
        System.out.println("$  $$$$$$$$$$?$$R'$ `#d$``    #$$$$$$$$$ > .                '       $$  $");
        System.out.println("$  $$$$$$$($$@$'` P *@$.@#'!    '*$$$$$$$L!.                        $$  $");
        System.out.println("$  9$$$$$$$L#$L  ! * <$$`          **$$$$$NL:'z  f                  $E  $");
        System.out.println("$> ?$$$$ $$$b$^      .$c .ueu.        `#$$$$b'x'# ''                x$  $");
        System.out.println("$k  $$$$N$  $$L:$oud$$$` d$ .u.         #$$$$$o.'' #f.              $$  $");
        System.out.println("$$  R$''$$o.$'$$$$'''' ue$$$P'''c          '$$$$$$Wo'              :$F  $");
        System.out.println("$$: '$&  $*$$u$$$$u.ud$R  `    ^            `#*****                @$  $$");
        System.out.println("$$N  #$: E 3$$$$$$$$$                                             d$  x$$");
        System.out.println("$$$k  $$   F *$$$$*                                             :$P   $$$");
        System.out.println("$$$$  '$b                                                      .$P   $$$$");
        System.out.println("$$$$b  `$b                                                    .$$   @$$$$");
        System.out.println("$$$$$N  `$N                                                  .$P   @$$$$$");
        System.out.println("$$$$$$$$.  $N.                                            .@$    $$$$$$$$");
        System.out.println("$$$$$$$$$o   #$N.                                       .@$#  .@$$$$$$$$$");
        System.out.println("$$$$$$$$$$$u  `#$Nu                                   u@$#   u$$$$$$$$$$$");
        System.out.println("$$$$$$$$$$$$$u   `R$o.                             ue$R    u$$$$$$$$$$$$$");
        System.out.println("$$$$$$$$$$$$$$$o.  ^#$$bu.                     .uW$P`   .u$$$$$$$$$$$$$$$");
        System.out.println("$$$$$$$$$$$$$$$$$$u   ``#R$$Wou..... ....uueW$$*#`   .u@$$$$$$$$$$$$$$$$$");
        System.out.println("$$$$$$$$$$$$$$$$$$$$Nu.    ``##***$$$$$***##``    .o$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$eu..               ...ed$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$NWWeeeeedW@$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("\n");
        System.out.println("Welcome to Jurassic Park Dino Rescue Center. We are excited to have your help, \nour previous volunteers had some unfortunate accidents. " +
                "We will need help with feeding, watering, playing \nwith each one individually, and putting them to bed. " +
                "Below is a list of \nthe dino's and their current well being status. " +
                "The well being status tracks \neach dinosaurs hunger, boredom, and tiredness levels.\n");
        animalsWellBeings(actualShelter);
        System.out.println("\nSelecting 1-3 will help take care of the Dinosaurs needs. The higher the number, the" +
                "\nmore attention he/she may need. Select 4 to adopt a Dinosaur. (you must sign a liability waiver. ) and select 5 to admit a dinosaur " +
                "\ninto the shelter. If you are curious to learn about each pet in the shelter select 6." +
                "\nSelect 0 once your shift is complete.\n");
    }

    private static void animalsWellBeings(VirtualPetShelter actualShelter) {
        System.out.println("\t\t\t\t\t\t Well Being Levels\n" +
                "\tName:\t|\tHunger/thirst :\t|\tBoredom :\t\t|\tTiredness :\t\n" +
                "------------|-------------------|-------------------|-------------------");
        for (VirtualPet animalPets : actualShelter.fetchingValuesOfAllPets()) {
            System.out.println(animalPets.getPetName() + "\t\t|\t\t" + animalPets.getHungry() + "\t\t\t|  \t\t"
                    + animalPets.getBoredom() + "\t\t\t|\t\t\t" + animalPets.getTiredness());
        }
    }
}