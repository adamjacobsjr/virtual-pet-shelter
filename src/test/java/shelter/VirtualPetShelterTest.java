package shelter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class virtualPetShelterTest {

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addPet() {
    }

    @Test
    void removePet() {
    }

    @Test
    void fetchingValuesOfAllPets() {
    }

    @Test
    void feedAll() {
        VirtualPetShelter shelter = new VirtualPetShelter();
        shelter.addPet(new VirtualPet("fluffy", "Is not really fluffy at all",50,50,50));
        shelter.addPet(new VirtualPet("spike", "has lots of spikes",50,50,50));
        for (VirtualPet pet : shelter.fetchingValuesOfAllPets()){
            pet.feed(30);
        }
        assertEquals(20, shelter.returnOnePet("fluffy").getHungry());
        assertEquals(20, shelter.returnOnePet("spike").getHungry());
    }

    @Test
    void sleepAll() {
        VirtualPetShelter shelter = new VirtualPetShelter();
        shelter.addPet(new VirtualPet("fluffy", "Is not really fluffy at all",50,50,50));
        shelter.addPet(new VirtualPet("spike", "has lots of spikes",50,50,50));
        for (VirtualPet pet : shelter.fetchingValuesOfAllPets()){
            pet.sleep(40);
        }
        assertEquals(10, shelter.returnOnePet("fluffy").getTiredness());
        assertEquals(10, shelter.returnOnePet("spike").getTiredness());
    }

    @Test
    void playOnePet() {
        VirtualPetShelter shelter = new VirtualPetShelter();
        shelter.addPet(new VirtualPet("fluffy", "Is not really fluffy at all",50,50,50));
        for (VirtualPet pet : shelter.fetchingValuesOfAllPets()){
            pet.play(25);
        }
        assertEquals(25, shelter.returnOnePet("fluffy").getBoredom());

    }

    @Test
    void returnOnePet() {
        VirtualPetShelter shelter = new VirtualPetShelter();
        shelter.addPet(new VirtualPet("fluffy", "Is not really fluffy at all",50,50,50));
        shelter.addPet(new VirtualPet("spike", "has lots of spikes",50,50,50));
        for (VirtualPet pet : shelter.fetchingValuesOfAllPets()){
        }
        assertEquals(50, shelter.returnOnePet("fluffy").getBoredom());
    }

    @Test
    void receivePetNames() {
    }

    @Test
    void tickAll() {
    }

    @Test
    void isAnimalInShelter() {
    }
}