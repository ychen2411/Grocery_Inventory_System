/**
 * The StorageTable class inherited an HashMap structure
 * to create a table of storage objects
 * @author Yanhui Chen
 *      e-mail: yanhui.chen@stonybrook.edu
 * Data members: static int serialVersionUID
 */
import java.util.HashMap;
import java.io.Serializable;
import java.util.Set;
import java.util.*;
public class StorageTable extends HashMap<Integer,Storage> implements Serializable {

    public static int serialVersionUID;

    /**
     * inserts a Storage object into the table
     * using specified key
     *
     * @param storageId
     *      key for the Storage object
     * @param storage
     *      the Storage object to be inserted
     * @precondition
     *      storage id cannot be less than 1 and
     *      storage does not equal null
     * @postcondition
     *      the storage has been inserted into the
     *      table with the indicated key
     * @throws IllegalArgumentException
     *      thrown when precondition is violated
     */
    public void putStorage(int storageId, Storage storage) {
        if (this.containsKey(storageId) || storageId <= 0 ||
                storage == null)
            throw new IllegalArgumentException();

        this.put(storageId,storage);
    }

    /**
     * returns the storage based on indicated key
     *
     * @param storageId
     *      the id of the storage object
     * @return
     *      storage object with the given key or
     *      null otherwise
     *
     */
    public Storage getStorage(int storageId) {
        return this.get(storageId);
    }

    /**
     * return a String representation of the
     * StorageTable object
     *
     * @return
     *      the storage table with each and every storage's
     *      id, client, and content.
     */
    public String toString(){
        String intro = String.format("%-15s%-35s%-35s\n","Box#", "Contents", "Owner");
        String line = "-----------------------------------------------------------------------\n";
        String str ="";
        Set<Integer> contents = this.keySet();
        List<Integer> list = new ArrayList<>(contents);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            str += this.get(list.get(i)).toString();
        }

        return intro + line + str;
    }
}
