package homework1;

import java.util.List;

class Main {
    public static void main(String[] args) {
        Person alice = new Person("Alice", 25);
        Person bob = new Person("Bob", 50);
        Person charlie = new Person("Charlie", 33);
        Person harry = new Person("Harry", 24);
        Person betty = new Person("Betty", 3);
        Person dave = new Person("Dave", 26);
        Person eve = new Person("Eve", 49);
        Person frank = new Person("Frank", 50);
        Person steve = new Person("Steve", 33);

        FamilyTree familyTree = new FamilyTree(alice);
        familyTree.addConnection(alice, bob, "father");
        familyTree.addConnection(alice, eve, "mother");
        familyTree.addConnection(alice, charlie, "brother");
        familyTree.addConnection(charlie, harry, "son");
        familyTree.addConnection(alice, betty, "daughter");
        familyTree.addConnection(alice, steve, "brother");
        familyTree.addConnection(alice, dave, "husband");
        familyTree.addConnection(alice, frank, "father-in-law");


        System.out.println("--------------------------------");
        System.out.println("Get a root person:");
        System.out.println(familyTree.getRootPerson());

        printConnections(alice, familyTree);

        System.out.println("--------------------------------");
        System.out.println("Get all of relatives of person with relationship \"brother\"");
        FamilyTree.getRelativesWithRelationship(alice, "brother");

        System.out.println("--------------------------------");
        System.out.println("Saving the Family Tree to the file...");
        familyTree.saveFamilyTreeToFile("family_tree.txt");

    }

    public static void printConnections(Person person, FamilyTree familyTree) {
        List<FamilyTree.Node> aliceChildren = familyTree.getChildren(person);
        System.out.println("-----------------------------");
        System.out.println("Relatives of " + person.getName() + ":");
        for (FamilyTree.Node child : aliceChildren) {
            System.out.println("Name: " + child.getPerson().getName() + ", Relationship: " + child.getRelationship());
        }
    }
}
