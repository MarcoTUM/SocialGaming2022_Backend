package socialgaming2022.app.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "player")
public class PlayerController {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @PostMapping
    public Player createPlayer(@RequestBody Player player) {
        // Put information from frontend into a new player object
        Player newPlayer = new Player(player.getId(), player.getFirebaseUID(), player.getNickname(), player.getFriendsFirebaseUIDs());

        // Auto-convert newPlayer to JSON and insert into database
        playerRepository.insert(newPlayer);

        // Return the new player that we created in the database
        return newPlayer;
    }

    @GetMapping(path = "{firebaseUID}")
    public Player findPlayerByFirebaseUID(@PathVariable String firebaseUID) {
        return playerRepository.findPlayerByFirebaseUID(firebaseUID)
                .orElseThrow(() -> new IllegalStateException("Error in findPlayerByFirebaseUID: No player with this firebaseUID " + firebaseUID + " in MongoDb database!"));
    }
}
