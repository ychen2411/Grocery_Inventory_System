/**
 * The Storage class creates a Storage object with
 * specified id, client, and contents.
 * @author Yanhui Chen
 *      e-mail: yanhui.chen@stonybrook.edu
 * Data members: String client
 *               String contents
 *               int id
 *               static long serialVersionUID
 */
import java.io.Serializable;


public class Storage implements Serializable {

    private int id;
    private String client;
    private String contents;
    public static long serialVersionUID;

    /**
     * return an instance of Storage object
     *
     * @param id
     *      id of the storage
     * @param client
     *      specified client
     * @param contents
     *      specified contents
     *
     * @postcondition
     *      an instance created with specified
     *      id, client, and contents
     */
    public Storage(int id, String client, String contents) {
        this.id = id;
        this.client = client;
        this.contents = contents;
    }

    /**
     * set the id of the Storage instance
     *
     * @param newId
     *      id of the instance, it cannot be
     *      less than 1
     */
    public void setId(int newId) {
        id = newId;
    }

    /**
     * return the id of the instance
     *
     * @return
     *      the id of the object
     */
    public int getId() {
        return id;
    }

    /**
     * set the client of the instance
     *
     * @param newClient
     *      client of the instance
     */
    public void setClient(String newClient){
        client = newClient;
    }

    /**
     * return the client of the instance
     *
     * @return
     *      client of the instance
     */
    public String getClient() {
        return client;
    }

    /**
     * set the contents of the instance
     *
     * @param newContents
     *      contents to be set
     */
    public void setContents(String newContents){
        contents = newContents;
    }

    /**
     * return the contents of the instance
     *
     * @return
     *      contents of the instance
     */
    public String getContents() {
        return contents;
    }

    /**
     * return a String representation of the class
     *
     *
     * @return
     *      the id, contents, client of the instance
     *      in a line
     */
    public String toString(){
        String str = "";
        str = str.format("%-15d%-35s%-35s\n",id,contents,client);
        return str;
    }
}
