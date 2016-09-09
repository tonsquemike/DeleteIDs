/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deleteids;

import Funciones.Archivos;
import Funciones.MyListArgs;
import Funciones.MySintaxis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 @author UAEM
 */
public class DeleteIDs {
    DeleteIDs(String []args)
    {
        // write your code here
        String        ConfigFile      = "";
        String        IN              = "";
        String        OUT             = "";
        String       INDEX            = "";

        String indexes[];
        MyListArgs Param                    ;
        HashMap <String, Integer>toDelete = new HashMap<String, Integer>();
        boolean bnd = false;

        Param      = new MyListArgs(args)                  ;
        ConfigFile = Param.ValueArgsAsString("-CONFIG", "");

        if (!ConfigFile.equals(""))
        {
            Param.AddArgsFromFile(ConfigFile);
        }//fin if

        String Sintaxis      = "-IN:str -OUT:str -INDEX:str";
        MySintaxis Review    = new MySintaxis(Sintaxis, Param);

        IN            = Param.ValueArgsAsString ( "-IN"          , "" );
        OUT           = Param.ValueArgsAsString ( "-OUT"         , "" );
        INDEX         = Param.ValueArgsAsString ( "-INDEX"       , "" );


        BufferedWriter bw = Archivos.newBuffer(OUT);
        indexes       = Archivos.leerArchivoDeTexto(INDEX);

        for (int i = 0; i < indexes.length; i++) {

        }

        String line   = "";

        String []split;

        try (BufferedReader br = new BufferedReader(new FileReader(IN))) {
            while ((line = br.readLine()) != null){
                split = line.split(",");
                if(toDelete.get(split[0])>1){
                    Archivos.addLine(bw, line);
                }
            }
        }catch (Exception e){}

        Archivos.saveFile(bw);
    }
    
}
