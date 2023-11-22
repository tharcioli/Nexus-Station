package view;

import controller.PlayerController;

public class PlayerView {

    private PlayerController playerController;

    public PlayerView() {
        playerController = new PlayerController(this);
    }

}
