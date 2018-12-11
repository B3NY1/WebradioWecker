package sample;

import javafx.fxml.FXML;


import javafx.event.ActionEvent;
import javafx.scene.control.Label;

import java.io.IOException;

public class Controller {

    @FXML private Label lbl_playing;
    @FXML private Label lbl_volume;
    @FXML private Label lbl_date;
    private byte volume = 40;
    private boolean fullscreen = false;

    public void butplus(ActionEvent event){
        if(volume < 100){
            command("mpc volume " + (volume + 5));
            volume += 5;
            lbl_volume.setText(Integer.toString(volume));
        }
    }

    public void butplusplus(ActionEvent event){
        if(volume < 100){
            command("mpc volume " + (volume + 10));
            volume += 10;
            lbl_volume.setText(Integer.toString(volume));
        }
    }

    public void butminus(ActionEvent event){
        if(volume > 0){
            command("mpc volume " + (volume - 5));
            volume -= 5;
            lbl_volume.setText(Integer.toString(volume));
        }
    }

    public void butminusminus(ActionEvent event){
        if(volume > 0){
            command("mpc volume " + (volume - 10));
            volume -= 10;
            lbl_volume.setText(Integer.toString(volume));
        }
    }

    public void butplay(ActionEvent event)  {
        command("mpc play");
        command("mpc volume " + volume);
    }

    public void butstop(ActionEvent event){
        command("mpc stop");
    }

    public void butlast(ActionEvent event){
        command("mpc prev");
    }

    public void butnext(ActionEvent event){
        command("mpc next");
    }

    public void command(String command){
        try{
            Runtime.getRuntime().exec(command);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void butclose(ActionEvent event){
        System.exit(0);
    }

}
