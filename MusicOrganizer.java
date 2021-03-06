import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * This version can play the files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;
        
    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<String>();
        player = new MusicPlayer();
    }
    
    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }
    
    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }
    
    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }
    
    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        String filename = files.get(index);
        player.startPlaying(filename);
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }
    
    /**
     * Metodo que imprimir por pantalla todos los nombres de archivos MP3s
     * almacenados en el organizador 
     */
    public void listAllFiles()
    {
        int posicion = 1;
        for (String filename : files)
        {
            System.out.println(posicion + "." + filename);
            posicion = posicion + 1;
        }
    }
    
    /**
     * Metodo que lista solo determinados archivos que contengan una cadena
     */
    public void listMaching(String searchString)
    {
        boolean notSearching = false;
        for(String filename : files)
        {
            if(filename.contains(searchString))
            {
                System.out.println(filename);
                notSearching = true;
            }
            
        }
        if(notSearching == false)
        {
            System.out.println("Error:la cadena introducida no aparece en la lista");
        }
    }
    
    /**
     * m�todo que reproduzca los primeros segundos de todas las canciones
     * de un determinado artista pasado como par�metro.
     */
    public void playingFiles(String artist)
    {
        for(String filename : files)
        {
            if(filename.contains(artist))
            {
                player.playSample(filename);
            }
        }
    }
    
    /**
     * Metodo que devuelve el primer archivo que contenga la cadena introducida como parametro o devuelve -1
     * en caso de que no exista esa cadena
     */
    public int findFirst(String searchString)
    {
        int index = 0;
        boolean found = false;
        int size = files.size();
        while (!found && index<size)
        {
           String filename = files.get(index);
           if(filename.contains(searchString))
           {
               found = true;
           }
           else
           {
               index ++;
           }    
        }
        if(found)
        {
            return index;
        }
        else
        {
            return -1;
        }
    }
}
