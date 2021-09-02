/**
 * The StorageManager class tests the Storage class,
 * StorageTable class, and the methods inside them.
 * @author Yanhui Chen
 *      e-mail: yanhui.chen@stonybrook.edu
 * Data members: static StorageTable table
 */
import java.util.Scanner;
import java.io.*;
public class StorageManager {

    private static StorageTable table;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        File x = new File("storage.obj");
        if (x.exists()) {
            try {
                FileInputStream file = new FileInputStream("storage.obj");
                ObjectInputStream inStream = new ObjectInputStream(file);
                table = (StorageTable) inStream.readObject();
                inStream.close();
            }
            catch (FileNotFoundException e) {

            }
            catch(IOException e){

            }
            catch(ClassNotFoundException e){

            }
        } else {
            table = new StorageTable();
        }

        String[] menu = { "P - Print all storage boxes", "A - Insert into storage box",
                "R - Remove contents from a storage box", "C - Select all boxes owned by a " +
                "particular client", "F - Find a box by ID and display its owner and contents",
                "Q - Quit and save workspace", "X - Quit and delete workspace"
        };

        for (String a : menu) {
            System.out.println(a);
        }

        String choice = "";
        String vChoice = "";
        do {
            System.out.print("\nPlease select an option: ");
            choice = input.next();
            input.nextLine();
            vChoice = choice.toUpperCase();

            switch(vChoice) {
                case "P" : {
                    System.out.print(table.toString());
                    break;
                }
                case "A" : {
                    System.out.print("\nPlease enter id: ");
                    int id = input.nextInt();
                    input.nextLine();
                    System.out.print("Please enter client: ");
                    String client = input.nextLine();
                    System.out.print("Please enter contents: ");
                    String contents = input.nextLine();
                    Storage storage = new Storage(id,client,contents);
                    table.putStorage(id,storage);
                    System.out.print("\nStorage " + id + " set!\n");
                    break;
                }
                case "R" : {
                    System.out.print("\nPlease enter ID: ");
                    int id = input.nextInt();
                    table.remove(id);
                    System.out.print("\nBox " + id + " is now removed.\n");
                    break;
                }
                case "F" : {
                    System.out.print("\nPlease enter ID: ");
                    int id = input.nextInt();
                    Storage storage = table.getStorage(id);
                    System.out.print("\nBox " + id);
                    System.out.print("\nContents: " + storage.getContents());
                    System.out.print("\nOwner: " + storage.getClient() + "\n");
                    break;
                }
                case "C" : {
                    System.out.print("Please enter the client's name: ");
                    String client = input.nextLine();

                    String intro = String.format("%-15s%-35s%-35s\n","Box#", "Contents", "Owner");
                    String line = "-----------------------------------------------------------------------\n";

                    String contents = "";
                    Storage storage;
                    for (int key : table.keySet()) {
                        if(table.getStorage(key).getClient().equalsIgnoreCase(client)) {

                            storage = table.getStorage(key);
                            contents += storage.toString();
                        }
                    }
                    System.out.print("\n" + intro + line + contents);
                    break;
                }
                case "Q" : {
                    try {
                        FileOutputStream file = new FileOutputStream("storage.obj");
                        ObjectOutputStream outStream = new ObjectOutputStream(file);
                        outStream.writeObject(table);
                        outStream.close();
                        System.out.print("\nStorage Manager is quitting, " +
                                "current storage is saved for next session.");
                        System.exit(0);
                    }
                    catch (FileNotFoundException e) {

                    }
                    catch (IOException e) {

                    }
                    break;
                }
                case "X" : {
                    x.delete();
                    System.out.print("\nAll data erased, terminating program");
                    System.exit(0);
                    break;
                }

            }

        } while (!vChoice.equalsIgnoreCase("Q") || !vChoice.equalsIgnoreCase("X"));
    }
}
