package socialgaming2022.app.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "player")
public class PlayerController {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @GetMapping
    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    @GetMapping
    public Player findPlayerById(@RequestParam String id) {
        return playerRepository.findPlayerById(id)
                .orElseThrow(() -> new IllegalStateException("Error in findPlayerById: No player with this id " + id + " in MongoDb database!"));
    }

    @GetMapping(path = "{firebaseUID}")
    public Player findPlayerByFirebaseUID(@PathVariable String firebaseUID) {
        return playerRepository.findPlayerByFirebaseUID(firebaseUID)
                .orElseThrow(() -> new IllegalStateException("Error in findPlayerByFirebaseUID: No player with this firebaseUID " + firebaseUID + " in MongoDb database!"));
    }

    @PostMapping
    public Player createPlayer(@RequestBody Player player) {
        // Put information from frontend into a new player object
        Player newPlayer = new Player(player.getId(), player.getFirebaseUID(), player.getNickname(), player.getFriendsFirebaseUIDs(), 0, 0);

        // Auto-convert newPlayer to JSON and insert into database
        playerRepository.insert(newPlayer);

        // Return the new player that we created in the database
        return newPlayer;
    }

    @PutMapping(path = "{firebaseUID}")
    public Player updatePlayerByFirebaseUID(@PathVariable String firebaseUID, @RequestBody Player player) {
        // Put information from frontend into a new player object
        Player updatedPlayer = playerRepository.findPlayerByFirebaseUID(firebaseUID)
                .orElseThrow(() -> new IllegalStateException("Error in updatePlayerByFirebaseUID: No player with this firebaseUID " + firebaseUID + " in MongoDb database!"));

        updatedPlayer.setNickname(player.getNickname());

        // Auto-convert updatedPlayer to JSON and save into database
        playerRepository.save(updatedPlayer);

        // Return the updated player
        return updatedPlayer;
    }

    @DeleteMapping(path = "{firebaseUID}")
    public void deletePlayerByFirebaseUID(@PathVariable String firebaseUID) {
        // Put information from frontend into a new player object
        Player player = playerRepository.findPlayerByFirebaseUID(firebaseUID)
                .orElseThrow(() -> new IllegalStateException("Error in deletePlayerByFirebaseUID: No player with this firebaseUID " + firebaseUID + " in MongoDb database!"));

        // Delete player from MongoDB database
        playerRepository.delete(player);
    }
}
