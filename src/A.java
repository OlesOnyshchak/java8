import java.util.HashMap;
import java.util.Map;

/**
 * Created by ono on 22.06.2017.
 */
public class A {
    public static void main(String[] args) {
        Map<Status,Message> messageMap = new HashMap<>();
        messageMap.put(Status.SUCCESS,new Message(Status.SUCCESS,"name1"));
        messageMap.put(Status.FAIL,new Message(Status.FAIL,"fail1"));
        messageMap.put(Status.SUCCESS,new Message(Status.SUCCESS,"name2"));
        messageMap.put(Status.FAIL,new Message(Status.FAIL,"fail2"));
        messageMap.put(Status.FAIL,new Message(Status.FAIL,"fail3"));

        System.out.println(messageMap);
    }
}

enum Status {
    SUCCESS,FAIL;
}

class Message {
    private Status status;
    private String name;

    public Message(Status status, String name) {
        this.status = status;
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Message{" +
                "status=" + status +
                ", name='" + name + '\'' +
                '}';
    }
}
