/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp3;

/**
 *
 * @author PERSONAL
 */
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.Codec;
import javax.media.ControllerEvent;
import javax.media.ControllerListener;
import javax.media.EndOfMediaEvent;
import javax.media.Format;
import javax.media.GainControl;
import javax.media.Manager;
import javax.media.Player;
import javax.media.PlugInManager;
import javax.media.Time;
import javax.media.format.AudioFormat;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;

//esta es la clase que reproduce el mp3
public class reproductor implements ControllerListener{
    private JTable table = new JTable();
    private long duration=1;
    private long bytes;
    private Player myPlayer;
    private URI r;
    private URL ru = null;
    
    private Timer tiempo ;
    private TimerTask task;
    private int speed = 1000;
    private int frame = 0;

    public reproductor() {
    }

    public void Play() throws Exception {
        //pone a reproducir la cancion 
        myPlayer.start();
    }
    
    //control de volumen recibe por parametro un float
    public void setVolumen(float a) {
        // se crea el control para el volumen
        GainControl gainControl = myPlayer.getGainControl();
        //se le añade el volumen
        float setLevel = gainControl.setLevel(a);
       
        
    }
    
    //metodo para abrir el archivo mp3
    public void AbrirFichero(String ruta) throws Exception {
        //crea un objeto de la clase file le envia por parametro la ruta de el archivo mp3
        File file = new File(ruta);
        //el url es otra forma de ver la ruta del archivo
        r=file.toURI();
        ru=r.toURL();
      //esto es importante para que la libreria funcione
      //codifica el audio
        String jffmpegAudioDecoder = "net.sourceforge.jffmpeg.AudioDecoder";
      Codec codecAudio = null;
        
      try {
            try {
                codecAudio = (Codec) Class.forName(jffmpegAudioDecoder).newInstance();
            } catch (InstantiationException ex) {
                
            } 
        } catch (ClassNotFoundException ex) {
            
        }
      PlugInManager.addPlugIn(jffmpegAudioDecoder, codecAudio.getSupportedInputFormats(), new Format[]{new AudioFormat("LINEAR")}, PlugInManager.CODEC);
        
      // a myPlayer se le asigna el url de la cancion
      try {
            myPlayer = Manager.createPlayer(ru);
        } catch (IOException ex) {
            
        }
      //se le añade un controlado
        myPlayer.addControllerListener(this);
    }
    
    //obtiene el tamaño en bytes del archivo mp3
    public long getBytes(){
        return bytes;
    }
    
    //duracion del archivo
    public long getDuracion(){
        return duration;
    }
    
    //le pone pausa a la cancion
    public void Pausa() throws Exception {
        myPlayer.stop();
    }
    //contunia con la cancion
    public void Continuar() throws Exception {
       myPlayer.start();
    }
    //detiene la cancion
    public void Stop() throws Exception {
        myPlayer.stop();
        myPlayer.close();
    }
    //metodo para adelantar la cancion
    public void adelantar(double b){
        myPlayer.setMediaTime(new Time(b));
    }

    @Override
    public synchronized void controllerUpdate(ControllerEvent ce) {
        
        if(ce instanceof EndOfMediaEvent){
            //buscar_sig();
        
        }
        
    }
    //obtioene en que segundo va la reproduccion de la cancion directamente de la libreria
    public double get_duracionActual(){
        return myPlayer.getMediaTime().getSeconds();
    }
    //OBTIENE la duracion de la cancion directamente de la libreria
    public double get_duracionTotal(){
        return myPlayer.getDuration().getSeconds();

    }
    

}
