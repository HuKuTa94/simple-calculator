package com.hukuta94.simplecalculator.application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class JavaFXAppLauncher extends Application
{
    private static final short WIDTH = 750;
    private static final short HEIGHT = 480;

    @Override
    public void start( Stage stage )
    {
        // Setup window
        stage.setTitle( "Calculator Application" );
        stage.setScene( new Scene( new Pane(), WIDTH, HEIGHT ));
        stage.setMaxWidth( WIDTH * 1.5 );
        stage.setMaxHeight( HEIGHT * 2 );
        stage.setMinWidth( WIDTH );
        stage.setMinHeight( HEIGHT );
        stage.show();

        // Close program
        stage.setOnCloseRequest( e -> {
            Platform.exit();
            System.exit( 0 );
        });
    }

    public static void main( String[] args )
    {
        launch( args );
    }
}
