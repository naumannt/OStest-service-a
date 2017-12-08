package service;

/**
 * Created by torstennaumann on 08.11.17.
 */
public class Data {

    private int id;

    private String content;

    public Data(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public Data(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
