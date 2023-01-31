package homework1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * The FamilyTree class is a data structure that represents a family tree.
 * It's main responsibility is to store and manage relationships between people represented by the Person class.
 * It has a root node, which is the first person added to the tree, and each node in the tree represents a person
 * and has a list of children nodes representing their children.
 *
 * @author  Oleg Razin
 */
class FamilyTree {
    /**
     * The Node class is used to represent a person in the family tree.
     * It contains fields for the person's name, relationship and a list of children nodes.
     */
    static class Node {
        private final Person person;
        private String relationship;
        private final List<Node> children;

        /**
         * Constructor for creating a new Node with a Person
         *
         * @param person the Person object
         */
        public Node(Person person) {
            this.person = person;
            this.children = new ArrayList<>();
        }

        public Person getPerson() {
            return person;
        }

        public String getRelationship() {
            return relationship;
        }

        public List<Node> getChildren() {
            return children;
        }

        public void addChild(Node child, String relationship) {
            children.add(child);
            child.relationship = relationship;
        }
    }

    private static Node root;

    /**
     * Constructor for creating a new FamilyTree
     */
    public FamilyTree(Person rootPerson) {
        root = new Node(rootPerson);
    }

    public Person getRootPerson() {
        return root.getPerson();
    }

    public List<Node> getChildren(Person person) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        queue.add(root);
        visited.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.getPerson().getName().equals(person.getName())) {
                return current.getChildren();
            }
            for (Node child : current.getChildren()) {
                if (!visited.contains(child)) {
                    queue.add(child);
                    visited.add(child);
                }
            }
        }
        return null;
    }

    /**
     *  Method to add a connection for the person
     * @param parent the Person object representing the parent of the Person to be added
     * @param child the Person object to be added
     * @param relationship the relationship of the Person to be added in relation to the parent
     */
    public void addConnection(Person parent, Person child, String relationship) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        queue.add(root);
        visited.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.getPerson().getName().equals(parent.getName())) {
                Node childNode = new Node(child);
                current.addChild(childNode, relationship);
                return;
            }
            for (Node childNode : current.getChildren()) {
                if (!visited.contains(childNode)) {
                    queue.add(childNode);
                    visited.add(childNode);
                }
            }
        }
    }

    public void saveFamilyTreeToFile(String filePath) {
        try (PrintWriter writer = new PrintWriter(filePath)) {
            saveFamilyTreeToFileHelper(root, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveFamilyTreeToFileHelper(Node node, PrintWriter writer) {
        for (Node child : node.getChildren()) {
            writer.println(node.getPerson().getName() + ":" + child.getPerson().getName() + ":" + child.getRelationship());
            saveFamilyTreeToFileHelper(child, writer);
        }
    }

    public static void getRelativesWithRelationship(Person person, String relationship) {
        Node node = getNodeByPerson(root, person);
        if(node != null) {
            getRelativesWithRelationshipHelper(node, relationship);
        }else{
            System.out.println(person.getName() + " not found in the tree.");
        }
    }

    private static void getRelativesWithRelationshipHelper(Node node, String relationship) {
        for (Node child : node.getChildren()) {
            if (child.getRelationship().equals(relationship)) {
                System.out.println("Name: " + child.getPerson().getName() + " Relationship: " + child.getRelationship());
            }
            getRelativesWithRelationshipHelper(child, relationship);
        }
    }

    private static Node getNodeByPerson(Node node, Person person) {
        if (node.getPerson().getName().equals(person.getName())) {
            return node;
        }
        for (Node child : node.getChildren()) {
            Node result = getNodeByPerson(child, person);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

}