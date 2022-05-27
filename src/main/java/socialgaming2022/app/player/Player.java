package socialgaming2022.app.player;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Players")
public class Player {
    // Universally Unique Identifier
    @Id
    private String id;

    // Firebase UID
    private String firebaseUID;

    // Player nickname
    private String nickname;

    // Friendlist
    private List<String> friendsFirebaseUIDs;

    // Constructor
    public Player(String id, String firebaseUID, String nickname, List<String> friendsFirebaseUIDs) {
        this.id = id;
        this.firebaseUID = firebaseUID;
        this.nickname = nickname;
        this.friendsFirebaseUIDs = friendsFirebaseUIDs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirebaseUID() {
        return firebaseUID;
    }

    public void setFirebaseUID(String firebaseUID) {
        this.firebaseUID = firebaseUID;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<String> getFriendsFirebaseUIDs() {
        return friendsFirebaseUIDs;
    }

    public void setFriendsFirebaseUIDs(List<String> friendsFirebaseUIDs) {
        this.friendsFirebaseUIDs = friendsFirebaseUIDs;
    }
}
