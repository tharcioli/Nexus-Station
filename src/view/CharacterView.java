package view;

import controller.CharacterController;

public class CharacterView {

    private CharacterController characterController;

    public CharacterView() {
        characterController = new CharacterController(this);
    }
}
