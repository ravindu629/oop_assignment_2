import java.util.ArrayList;
import java.util.List;


// animal categories
interface Walker {
    void walk();
}

interface Flyer {
    void fly();
}

interface Swimmer {
    void swim();
}

// abstract animal class
abstract class Animal {
    protected String name;
    
    public Animal(String name) {
        this.name = name;
    }
    
    public abstract void makeSound();
    
    public abstract void eat();
    
    public void sleep() {
        System.out.println(name + " is sleeping.");
    }
    
    public void wakeUp() {
        System.out.println(name + " woke up.");
    }
    
    // functions for check walker, flyer or swimmer
    public boolean isWalker() {
        return this instanceof Walker;
    }
    
    public boolean isFlyer() {
        return this instanceof Flyer;
    }
    
    public boolean isSwimmer() {
        return this instanceof Swimmer;
    }
    
    public String getName() {
        return name;
    }
    
}

// sub classes

// elephant
class Elephant extends Animal implements Walker {
    public Elephant(String name) {
        super(name);
    }
    
    public void makeSound() {
        System.out.println(name + " makes elephant sound.");
    }
    
    public void eat() {
        System.out.println(name + " eats vegitables and fruits.");
    }
    
    public void walk() {
        System.out.println(name + " is walking.");
    }
    
}

// fish
class Fish extends Animal implements Swimmer {
    public Fish(String name) {
        super(name);
    }
    
    public void makeSound() {
        System.out.println(name + " makes fish sound.");
    }
    
    public void eat() {
        System.out.println(name + " eats fish food.");
    }
    
    public void swim() {
        System.out.println(name + " is swimming.");
    }
    
}

// sea bird
class SeaBird extends Animal implements Flyer, Swimmer {
    public SeaBird(String name) {
        super(name);
    }
    
    public void makeSound() {
        System.out.println(name + " makes sea bird sound.");
    }
    
    public void eat() {
        System.out.println(name + " eats small fish.");
    }
    
    public void fly() {
        System.out.println(name + " is flying.");
    }
    
    public void swim() {
        System.out.println(name + " is swimming.");
    }
    
}

// parrot
class Parrot extends Animal implements Flyer, Walker {
    public Parrot(String name) {
        super(name);
    }
    
    public void makeSound() {
        System.out.println(name + " makes parrot sound.");
    }
    
    public void eat() {
        System.out.println(name + " eats seeds.");
    }
    
    public void fly() {
        System.out.println(name + " is flying.");
    }
    
    public void walk() {
        System.out.println(name + " is walking.");
    }
    
}

// zoo 
class Zoo {
    private List<Animal> animals = new ArrayList<>();
    
    public void addAnimal(Animal animal) {
        animals.add(animal);
        System.out.println(animal.getName() + " added to the zoo.");
    }
    
    // method for get all animals count
    public int getTotalAnimalsCount() {
        return animals.size();
    } 
    
    // method for make all animals eat
    public void makeAllEat() {
        for (Animal animal: animals) {
            animal.eat();
        }
    }
    
    // method for make all animals sleep
    public void makeAllSleep() {
        for (Animal animal : animals) {
            animal.sleep();
        }
    }

    // method for make all animals wake up
    public void wakeAllAnimals() {
        for (Animal animal : animals) {
            animal.wakeUp();
        }
    }
    
    // methods for swim, fly or walk animal according to category
    public void getAllSwimmersAndMakeSwim() {
        for (Animal animal : animals) {
            if (animal instanceof Swimmer) {
                ((Swimmer) animal).swim();
            }
        }
    }

    public void getAllFlyersAndMakeFly() {
        for (Animal animal : animals) {
            if (animal instanceof Flyer) {
                ((Flyer) animal).fly();
            }
        }
    }

    public void getAllWalkersAndMakeWalk() {
        for (Animal animal : animals) {
            if (animal instanceof Walker) {
                ((Walker) animal).walk();
            }
        }
    }
    
    // methods for count walkers, flyers and swimmers
     public int countWalkers() {
        int count = 0;
        for (Animal animal : animals) {
            if (animal instanceof Walker) {
                count++;
            }
        }
        return count;
    }

    public int countFlyers() {
        int count = 0;
        for (Animal animal : animals) {
            if (animal instanceof Flyer) {
                count++;
            }
        }
        return count;
    }

    public int countSwimmers() {
        int count = 0;
        for (Animal animal : animals) {
            if (animal instanceof Swimmer) {
                count++;
            }
        }
        return count;
    }
}


public class Oop {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();

        Animal elephant = new Elephant("elephant");
        Animal fish = new Fish("fish");
        Animal seaBird = new SeaBird("seabird");
        Animal parrot = new Parrot("parrot");

        zoo.addAnimal(elephant);
        zoo.addAnimal(fish);
        zoo.addAnimal(seaBird);
        zoo.addAnimal(parrot);

        // all animals eat
        System.out.println("\nEat");
        zoo.makeAllEat();
        
        // all animals wake up
        System.out.println("\nWake Up");
        zoo.wakeAllAnimals();

        // all animals sleep
        System.out.println("\nSlepp");
        zoo.makeAllSleep();

        // get all swimmers and make them swim
        System.out.println("\nSwimmers swim");
        zoo.getAllSwimmersAndMakeSwim();

        // get all flyers and make them fly
        System.out.println("\nFlyers fly");
        zoo.getAllFlyersAndMakeFly();

        // get all walkers and make them walk
        System.out.println("\nWalkers walk");
        zoo.getAllWalkersAndMakeWalk();

        System.out.println("\nTotal Animals: " + zoo.getTotalAnimalsCount());
        System.out.println("Number of Walkers: " + zoo.countWalkers());
        System.out.println("Number of Flyers: " + zoo.countFlyers());
        System.out.println("Number of Swimmers: " + zoo.countSwimmers());
        
        //check animal isSwimmer,isWalker,isFlyer
        System.out.println("\n" + elephant.isWalker());
        System.out.println(fish.isSwimmer());
        System.out.println(seaBird.isFlyer());
    }
}

