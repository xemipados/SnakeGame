module snakegame {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens snakegame to javafx.fxml;

    exports snakegame;
}
