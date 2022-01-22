package shelter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

    private Map<String, VirtualPet> shelterMap = new HashMap<>();

    public void addPet(VirtualPet animal) {
        shelterMap.put(animal.getPetName(), animal);
    }

    public void removePet(String petName) {
        shelterMap.remove(petName);
    }

    public Collection<VirtualPet> fetchingValuesOfAllPets() {
        return shelterMap.values();
    }

    public void feedAll(int fed) {
        for (VirtualPet hungryPet : shelterMap.values()) {
            hungryPet.feed(fed);
        }
    }

    public void sleepAll(int nap) {
        for (VirtualPet tirednessPet : shelterMap.values()) {
            tirednessPet.sleep(nap);
        }
    }

    public void playOnePet(String petName, int activity) {
        shelterMap.get(petName).play(activity);
    }

    public VirtualPet returnOnePet(String petName) {
        return shelterMap.get(petName);
    }

    public void receivePetNames() {
        for (VirtualPet nameOfPet : shelterMap.values()) {
            System.out.println(nameOfPet.getPetName() + ": " + nameOfPet.getDescription());
        }
    }

    public void tickAll() {
        for (VirtualPet tickForPet : shelterMap.values()) {
            tickForPet.tick();
        }
    }

    public boolean isAnimalInShelter(String petName) {
        return shelterMap.containsKey(petName);
    }
}