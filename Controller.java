import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller {
    @FXML private ImageView phil0, phil1, phil2, phil3, phil4;

    private final Image thinking = new Image(getClass().getResourceAsStream("thinking.png"));
    private final Image eating = new Image(getClass().getResourceAsStream("eating.png"));

    private final Chopstick[] chopsticks = new Chopstick[5];
    private final Philosopher[] philosophers = new Philosopher[5];

    @FXML
    public void initialize() {
        for (int i = 0; i < 5; i++) chopsticks[i] = new Chopstick();

        ImageView[] images = {phil0, phil1, phil2, phil3, phil4};

        for (int i = 0; i < 5; i++) {
            philosophers[i] = new Philosopher(i, chopsticks[i], chopsticks[(i + 1) % 5], this);
            final int index = i;
            Platform.runLater(() -> images[index].setImage(thinking));
            philosophers[i].start();
        }
    }

    public void setThinking(int id) {
        updateImage(id, thinking);
    }

    public void setEating(int id) {
        updateImage(id, eating);
    }

    private void updateImage(int id, Image img) {
        Platform.runLater(() -> {
            switch (id) {
                case 0:
                    phil0.setImage(img);
                    break;
                case 1:
                    phil1.setImage(img);
                    break;
                case 2:
                    phil2.setImage(img);
                    break;
                case 3:
                    phil3.setImage(img);
                    break;
                case 4:
                    phil4.setImage(img);
                    break;
            }
        });
    }

}
