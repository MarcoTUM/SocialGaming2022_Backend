package socialgaming2022.app.player;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Players")
public class Player {
    // Universally Unique Identifier
    @Id
    private String id;

    // Firebase UID
    @Indexed(unique = true)
    private final String firebaseUID;

    // Player nickname
    private String nickname;

    // Friend list
    private List<String> friendsFirebaseUIDs;

    // Games played
    private int gamesPlayed;

    // Games won
    private int gamesWon;

    // Constructor
    public Player(String id, String firebaseUID, String nickname, List<String> friendsFirebaseUIDs, int gamesPlayed, int gamesWon) {
        this.id = id;
        this.firebaseUID = firebaseUID;
        this.nickname = nickname;
        this.friendsFirebaseUIDs = friendsFirebaseUIDs;
        this.gamesPlayed = gamesPlayed;
        this.gamesWon = gamesWon;
    }

    public String getId() {
        return id;
    }

    public String getFirebaseUID() {
        return firebaseUID;
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

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }
}
